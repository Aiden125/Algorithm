package programmers.kit.stack;

import java.util.Arrays;

public class StockPrice2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(StockPrice2.solution(prices))); // 4,3,1,1,0
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int count = 1;
        for (int left = 0; left < prices.length; left++) {
            for (int right = left + 1; right < prices.length; right++) {
                // 더 커지거나 같은 경우
                if (prices[left] <= prices[right] && right < prices.length-1) {
                    count++;
                } else { // 더 작아지는 경우 answer에 할당
                    answer[left] = count;
                    count = 1;
                    break;
                }
            }
        }

        return answer;
    }
}
