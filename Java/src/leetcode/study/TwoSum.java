package leetcode.study;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
//        int[] a1 = {2, 7, 11, 15};
//        int a2 = 9;
//        System.out.println(Arrays.toString(TwoSum.twoSum(a1, a2))); // 0,1

        int[] b1 = {3,2,4};
        int b2 = 6;
        System.out.println(Arrays.toString(TwoSum.twoSum(b1, b2))); // 1, 2
    }

    public static int[] twoSum(int[] nums, int target) { // 2 3 4
        int[] answer = new int[2];

        int[] copyNum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            copyNum[i] = nums[i];
        }
        Arrays.sort(copyNum);

        int left = 0;
        int right = nums.length - 1;
        while (left < copyNum.length && right >= 0) {
            int leftNum = copyNum[left];
            int rightNum = copyNum[right];
            if (leftNum + rightNum > target) {
                right--;
            } else if (leftNum + rightNum < target) {
                left++;
            } else {
                boolean leftFound = false;
                boolean rightFound = false;
                for (int i=0; i<nums.length; i++) {
                    if (nums[i] == leftNum && !leftFound) {
                        answer[0] = i;
                        leftFound = true;
                    }
                    if (nums[i] == rightNum && !rightFound && i != answer[0]) {
                        answer[1] = i;
                        rightFound = true;
                    }
                    if (leftFound && rightFound) {
                        break;
                    }
                }
                break;
            }
        }

        return answer;
    }
}
