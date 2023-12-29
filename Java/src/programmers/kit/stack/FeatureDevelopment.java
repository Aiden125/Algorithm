package programmers.kit.stack;

import java.util.ArrayList;
import java.util.Arrays;

public class FeatureDevelopment {
    public static void main(String[] args) {

//        int[] pro = {95, 90, 99, 99, 80, 99};
//        int[] sp = {1, 1, 1, 1, 1, 1};
//        System.out.println(Arrays.toString(FeatureDevelopment.solution(pro, sp))); // 1,3,2

        int[] pro2 = {90, 90};
        int[] sp2 = {10, 9};
        System.out.println(Arrays.toString(FeatureDevelopment.solution(pro2, sp2))); // 1, 1
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 걸리는 총 날짜 계산
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<progresses.length; i++) {
            int a = progresses[i];
            int b = speeds[i];
            int days = (int) Math.ceil(((100 - a)/(b+0.0)));
            list.add(days);
        }

        // 걸리는 날짜 비교해서 계산
        ArrayList<Integer> answerList = new ArrayList<>();
        int count = 1;
        int left = 0;
        int right = 1;
        while(right < list.size()) {
            int leftDays = list.get(left);
            int rightDays = list.get(right);
            if (rightDays <= leftDays) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                left = right;
            }
            right++;
        }
        answerList.add(count);

        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
