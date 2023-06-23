package programmers.level1;

import java.util.Arrays;
// L1_모의고사
public class L1_MockExam {
    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5,1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers))); //  expected: 3
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] arr = {1,2,3,4,5};
        int[] brr = {2,1,2,3,2,4,2,5};
        int[] crr = {3,3,1,1,2,2,4,4,5,5};

        int[] scoreArr = new int[4];
        for(int i=0; i<answers.length; i++) {
            int aIndex = i > arr.length-1 ? i%(arr.length) : i;
            int bIndex = i > brr.length-1 ? i%(brr.length) : i;
            int cIndex = i > crr.length-1 ? i%(crr.length) : i;

            if (arr[aIndex] == answers[i]) {
                scoreArr[1]++;
            }
            if (brr[bIndex] == answers[i]) {
                scoreArr[2]++;
            }
            if (crr[cIndex] == answers[i]) {
                scoreArr[3]++;
            }
        }

        int max = 0;
        for(int i=0; i<scoreArr.length; i++) {
            if (scoreArr[i] > max) max = scoreArr[i];
        }
        // max가 0이면 아무도 문제를 못맞춘 것
        if (max == 0) {
            return answer;
        }
        String ansStr = "";
        for(int i=0; i<scoreArr.length; i++) {
            if (max == scoreArr[i]) {
                ansStr += i;
            }
        }

        answer = new int[ansStr.length()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(ansStr.charAt(i)));
        }

        return answer;
    }
}
