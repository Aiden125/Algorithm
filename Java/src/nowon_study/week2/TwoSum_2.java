package nowon_study.week2;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
public class TwoSum_2 {
    public static void main(String[] args) {
//        int[] a1 = {2, 7, 11, 15};
//        int a2 = 9;
//        System.out.println(Arrays.toString(TwoSum.twoSum(a1, a2))); // 0,1

        int[] b1 = {3,2,4};
        int b2 = 6;
        System.out.println(Arrays.toString(TwoSum_2.twoSum(b1, b2))); // 1, 2
    }

    public static int[] twoSum(int[] nums, int target) { // 2 3 4
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
