package inflearn2.c_dataStructure;

import java.util.*;

public class C_3_Order_Entry_Front_Door {
    public int[] solution(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];

        Queue<Integer> inQ = new LinkedList<>();
        Queue<Integer> outQ = new LinkedList<>();

        int stateSwitch = 1; // 1은 나감, 0은 들어옴 우선순위
        int time = 0;
        int index = 0;
        int count = 0;
        int emptyTime = 0;
        while (count < arrival.length) {
            while(index < arrival.length && arrival[index] <= time) {
                if (state[index] == 1) {
                    outQ.offer(index);
                    if (emptyTime > 0) {
                        stateSwitch = 1;
                        emptyTime = 0;
                    }
                } else {
                    inQ.offer(index);
                    if (emptyTime > 0) {
                        stateSwitch = 0;
                        emptyTime = 0;
                    }
                }
                index++;
            }

            if (inQ.isEmpty() && outQ.isEmpty()) {
                emptyTime++;
            } else {
                emptyTime = 0;
            }
            if (stateSwitch == 1) {
                if (!outQ.isEmpty()) {
                    answer[outQ.poll()] = time;
                    count++;
                } else if (!inQ.isEmpty()){
                    answer[inQ.poll()] = time;
                    count++;
                    stateSwitch = 0;
                }
            } else {
                if (!inQ.isEmpty()) {
                    answer[inQ.poll()] = time;
                    count++;
                } else if (!outQ.isEmpty()){
                    answer[outQ.poll()] = time;
                    count++;
                    stateSwitch = 1;
                }
            }

            time++;
        }

        return answer;
    }

    public static void main(String[] args) {
        C_3_Order_Entry_Front_Door T = new C_3_Order_Entry_Front_Door();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
        /**
         * 0 2 3 1 4 5 8 9
         * 3 6 4 7 5 8
         * 2 3 4 5 6 8 11 9 10 12
         */
    }
}
