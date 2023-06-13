package programmers;

import java.util.Arrays;
import java.util.Collections;

public class L1_AppleBox {
    public static void main(String[] args) {

        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int appleNum = score.length; // 7

        int index = appleNum-m; // 33 30
        while(index >= 0) { // 인덱스 기준이라 1 작음
            answer += (score[index] * m);
            index -= m;
        }

        return answer;
    }
}
