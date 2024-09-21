package inflearn2.c_dataStructure;

import java.util.*;

public class C_4_Dermatology {
    int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return (H * 60) + M;
    }
    public int solution(int[] laser, String[] enter) {
        int answer = 0;

        // 처음부터 다시 진행 필요
        return answer;
    }

    public static void main(String[] args) {
        C_4_Dermatology T = new C_4_Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
        /**
         * 3
         * 4
         * 0
         */
    }
}