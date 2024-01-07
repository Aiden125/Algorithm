package programmers.kit.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 시험이 최대 1만 문제
 * 1,2,3번 수험자가 각각 찍는 패턴이 있다.
 * 문제가 주어졌을 때 가장 많이 맞추는 수험생 번호 리턴
 */
public class PreTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(PreTest.solution(a))); // 1
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        for (int i=0; i<answers.length; i++) {
            int target = answers[i];
            if (a[i%a.length] == target) score[0]++;
            if (b[i%b.length] == target) score[1]++;
            if (c[i%c.length] == target) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for (int i=0; i<score.length; i++) {
            if (score[i] == max) {
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
