package inflearn2.c_dataStructure;

import java.util.*;

public class C_1_Max_Length_Sequence {
    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            // 같은 숫자는 뛰어넘게
            if (nums[i] == nums[i+1]) continue;

            if (nums[i] + 1 == nums[i+1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        answer = max;
        return answer;
    }

    public static void main(String[] args) {
        C_1_Max_Length_Sequence T = new C_1_Max_Length_Sequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
        /**
         * 5
         * 10
         * 1
         * 7
         * 3
         */
    }
}
