package nowon_study.week3;

import java.util.*;

public class ThreeSum15_2 {
    public static void main(String[] args) {
        // Input: nums = [-1,0,1,2,-1,-4]
        // Output: [[-1,-1,2],[-1,0,1]]
        int[] a1 = {-1,0,1,2,-1,-4};
        System.out.println(ThreeSum15_2.threeSum(a1));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();

        Arrays.sort(nums); // nlog n

        Set<List<Integer>> set = new HashSet<>();

        int firstIndex = 0;
        while (firstIndex < nums.length - 2) {
            int firstValue = nums[firstIndex];
            
            // 중복된 값 처리
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex-1]) {
                firstIndex++;
                continue;
            }
            // 작은 값 처리
            if (-firstValue > nums[nums.length-2] + nums[nums.length-1]) {
                firstIndex++;
                continue;
            }

            int targetTwoSum = -firstValue;

            int leftIndex = firstIndex+1;
            int rightIndex = nums.length-1;

            while (leftIndex < rightIndex) {
                int leftValue = nums[leftIndex];
                int rightValue = nums[rightIndex];

                int currentSum = leftValue + rightValue;
                if (currentSum == targetTwoSum) {
                    set.add(Arrays.asList(firstValue, leftValue, rightValue));
                    leftIndex++;
                } else if (currentSum > targetTwoSum) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }

            firstIndex++;
        }

        arr.addAll(set);

        return arr;
    }
}
