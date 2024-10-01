package inflearn2.d_sorting;

import java.util.*;

public class D_4_Judge {
    public int solution(int[] score, int k) {
        int answer = 0;

        Arrays.sort(score);

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = left + k - 1;
        while (right < score.length || min == Integer.MAX_VALUE) {
            if (score[right] - score[left] <= 10) {
                int sum = 0;
                int average = 0;
                for (int i=left; i<=right; i++) {
                    sum += score[i];
                }
                average = sum/k;
                min = Math.min(min, average);
            }
            left++;
            right++;
        }
        answer = min;
        return answer;
    }

    public static void main(String[] args) {
        D_4_Judge T = new D_4_Judge();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
        /**
         * 89
         * 88
         * 92
         * 90
         */
    }
}
