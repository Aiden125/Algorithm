package inflearn2.c_dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C_3_Order_Entry_Front_Door_Sample {
    public int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int arrivalLength = arrival.length, prevState = 1;
        int[] answer = new int[arrivalLength];
        for (int time = 0, index = 0, arrivalCnt = 0; ; time++) {
            if (enter.isEmpty() && exit.isEmpty() && index < arrivalLength) {
                if (time < arrival[index]) {
                    time = arrival[index];
                    prevState = 1;
                }
            }
            while (index < arrivalLength && arrival[index] <= time) {
                if (state[index] == 0) enter.offer(index);
                else exit.offer(index);
                index++;
            }
            if (prevState == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = time;
                    prevState = 1;
                } else {
                    answer[enter.poll()] = time;
                    prevState = 0;
                }
            } else if (prevState == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = time;
                    prevState = 0;
                } else {
                    answer[exit.poll()] = time;
                    prevState = 1;
                }
            }
            arrivalCnt++;
            if (arrivalCnt == arrivalLength) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        C_3_Order_Entry_Front_Door_Sample T = new C_3_Order_Entry_Front_Door_Sample();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 0, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
        /**
         * 0 2 3 1 4 5 8 9
         * 0 2 3 1 4 5 9 8
         * 3 6 4 7 5 8
         * 2 3 4 5 6 8 11 9 10 12
         */
    }
}
