package programmers.kit.bruteforce;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        System.out.println(Arrays.toString(Carpet.solution(a, b))); // 4,3

        int a2 = 8;
        int b2 = 1;
        System.out.println(Arrays.toString(Carpet.solution(a2, b2))); // 3,3
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        for (int x=1; x<=sum/2; x++) {
            if (sum%x != 0) continue;
            int y = sum/x;

            int currentBrown = (x * 2) + ((y-2)*2);
            if (brown == currentBrown) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}
