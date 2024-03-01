package nowon_study.week3;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum162_2 {
    public static void main(String[] args) {

        int[] a1 = {2,7,11,15};
        int a2 = 9;
        System.out.println(Arrays.toString(TwoSum162_2.twoSum(a1, a2))); // 1,2

        int[] b1 = {2,3,4};
        int b2 = 6;
        System.out.println(Arrays.toString(TwoSum162_2.twoSum(b1,b2))); // 1,3

        int[] c1 = {-1, 0};
        int c2 = -1;
        System.out.println(Arrays.toString(TwoSum162_2.twoSum(c1,c2)  )); // 1,2
    }

    static public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (true) { // 답이 무조건 있다고 주어지기에 true로
            int leftValue = numbers[left];
            int rightValue = numbers[right];

            int sum = leftValue + rightValue;
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
