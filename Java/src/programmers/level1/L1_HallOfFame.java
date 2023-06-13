package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L1_HallOfFame {
    public static void main(String[] args) {

        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer;
        answer = new int[score.length];
        ArrayList<Integer> fameArr = new ArrayList<>();

        // 명예의전당 크기가 가수보다 더 클 경우
        // 어차피 모든 사람이 명예의 전당에 들어가기 때문에
        if (k>score.length) k = score.length;

        // 명예의 전당 만석 전
        int kMin = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            int currNum = score[i];
            fameArr.add(currNum);
            if (currNum < kMin) {
                kMin = currNum;
            }
            answer[i] = kMin;
        }
        Collections.sort(fameArr);

        for(int i=k; i<score.length; i++) {

            // 지금 가수 점수
            int releaseScore = score[i];
            // 명예의 전당 꼴찌 가수
            int min = fameArr.get(0);

            // 순위 비교 후 넣기, 빼기
            if (releaseScore > min) {
                fameArr.remove(0);
                fameArr.add(releaseScore);

                // 오름차순 정렬
                Collections.sort(fameArr);
            }

            int dayMinScore = fameArr.get(0);
            answer[i] = dayMinScore;
        }
        return answer;
    }
}
