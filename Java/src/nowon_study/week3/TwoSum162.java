package nowon_study.week3;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum162 {
    public static void main(String[] args) {

        int[] a1 = {2,7,11,15};
        int a2 = 9;
        System.out.println(Arrays.toString(TwoSum162.twoSum(a1, a2))); // 1,2

        int[] b1 = {2,3,4};
        int b2 = 6;
        System.out.println(Arrays.toString(TwoSum162.twoSum(b1,b2))); // 1,3

        int[] c1 = {-1, 0};
        int c2 = -1;
        System.out.println(Arrays.toString(TwoSum162.twoSum(c1,c2)  )); // 1,2
    }

    static public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i=0; i<numbers.length; i++) {
            int currentTarget = target - numbers[i];
            int secondIndex = map.getOrDefault(currentTarget, -1);
            if (map.getOrDefault(currentTarget, -1) >= 0) {
                return new int[] {i+1, secondIndex+1};
            }
        }
        return null;
    }
}
