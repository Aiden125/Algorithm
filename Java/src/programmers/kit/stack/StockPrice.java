package programmers.kit.stack;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(StockPrice.solution(prices))); // 4,3,1,1,0
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int left = 0;
        int right = 1;
        int count = 1;

        while(left < prices.length) {

            // 마지막까지 도달하면
            if (right >= prices.length-1) {
                answer[left] = count;
                left++;
                right = left+1;
                count = 1;
                continue;
            }

            // 왼쪽이 오른쪽보다 작으면
            if (prices[left] <= prices[right]) {
                right++;
                count++;
            }
            // 왼쪽이 오른쪽보다 크면
            else {
                answer[left] = count;
                count = 1;
                left++;
                right = left+1;
            }
        }
        answer[prices.length-1] = 0;

        return answer;
    }
}
