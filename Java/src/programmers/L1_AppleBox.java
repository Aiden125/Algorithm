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
        // 사과들 정렬
        Arrays.sort(score);
        int appleNum = score.length; // 사과박스 size

        int index = appleNum-m; // 오름차순이기 때문에 시작 인덱스를 큰쪽에서부터
        while(index >= 0) {
            answer += (score[index] * m);
            index -= m;
        }

        return answer;
    }
}
