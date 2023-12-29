package programmers.kit.stack;

import java.util.ArrayList;
import java.util.Arrays;

public class FeatureDevelopment {
    public static void main(String[] args) {

        int[] pro = {95, 90, 99, 99, 80, 99};
        int[] sp = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(FeatureDevelopment.solution(pro, sp))); // 1,3,2
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<progresses.length; i++) {
            int a = progresses[i];
            int b = speeds[i];
            int days = (int) Math.ceil((100 - a)/b);
            list.add(days);
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        int count = 1;
        for (int i=0; i<list.size()-1; i++) {
            int a = list.get(i);
            int b = list.get(i+1);
            if (a >= b && i < list.size()-1) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
