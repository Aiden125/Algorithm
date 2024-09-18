package inflearn2.c_dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C_3_Order_Entry_Front_Door_Sample {
    public int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length, prev = 1;
        int[] answer = new int[n];
        for(int t = 0, i = 0, cnt = 0; ; t++){
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                if(t < arrival[i]){
                    t = arrival[i];
                    prev = 1;
                }
            }
            while(i < n && arrival[i] <= t) {
                if (state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }
            if(prev == 1) {
                if(!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
                else{
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            }else if(prev == 0) {
                if(!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                }else{
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if(cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        C_3_Order_Entry_Front_Door_Sample T = new C_3_Order_Entry_Front_Door_Sample();
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
