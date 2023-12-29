package programmers.kit.stack;

import java.util.*;

public class FeatureDevelopment2 {
    public static void main(String[] args) {

//        int[] pro = {95, 90, 99, 99, 80, 99};
//        int[] sp = {1, 1, 1, 1, 1, 1};
//        System.out.println(Arrays.toString(FeatureDevelopment.solution(pro, sp))); // 1,3,2

        int[] pro2 = {90, 90};
        int[] sp2 = {10, 9};
        System.out.println(Arrays.toString(FeatureDevelopment2.solution(pro2, sp2))); // 1, 1
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 걸리는 총 날짜 계산
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int a = progresses[i];
            int b = speeds[i];
            int days = (int) Math.ceil(((100 - a) / (double)(b)));

            if (!q.isEmpty() && q.peek() < days) {
                list.add(q.size());
                q.clear();
            }

            q.offer(days);
        }
        list.add(q.size());

        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
