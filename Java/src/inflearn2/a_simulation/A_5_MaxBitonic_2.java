package inflearn2.a_simulation;

import java.util.*;
class A_5_MaxBitonic_2 {
    public int solution(int[] nums){
        int answer = 0;

        ArrayList<Integer> peeksIndex = new ArrayList<>();

        for (int i=1; i<nums.length-1; i++) {
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peeksIndex.add(i);
            }
        }

        for (int index : peeksIndex) {
            int count = 1;
            int left = index;
            int right = index;

            while (left >= 1 && nums[left-1] < nums[left]) {
                count++;
                left--;
            }
            while (right < nums.length - 1 && nums[right] > nums[right+1]) {
                count++;
                right++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args){
        A_5_MaxBitonic_2 T = new A_5_MaxBitonic_2();
            System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1})); // 5
            System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 8
            System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 6
            System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }
}