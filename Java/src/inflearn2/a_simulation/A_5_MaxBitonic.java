package inflearn2.a_simulation;

import java.util.*;
class A_5_MaxBitonic {
    public int solution(int[] nums){
        int answer = 0;

        int max = -999;
        boolean increase = false;
        boolean decrease = false;
        int increaseCount = 0;
        int decreaseCount = 0;
        for (int i=0; i<nums.length-1; i++) {
            int left = nums[i];
            int right = nums[i+1];

            if (left == right || (left > right && !increase)) {
                increaseCount = 0;
                decreaseCount = 0;
                increase = false;
                decrease = false;
                continue;
            }

            if (left < right && !decrease) {
                increase = true;
                increaseCount++;
            } else if (left < right && decrease) {
                increaseCount = 1;
                decreaseCount = 0;
                decrease = false;
            } else if (left > right && increase) {
                decrease = true;
                decreaseCount++;
            }

            max = Math.max(max, (increaseCount + decreaseCount));
        }
        answer = max + 1;

        return answer;
    }

    public static void main(String[] args){
        A_5_MaxBitonic T = new A_5_MaxBitonic();
            System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1})); // 5
            System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 8
            System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 6
            System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }
}