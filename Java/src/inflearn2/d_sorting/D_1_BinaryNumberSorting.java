package inflearn2.d_sorting;

import java.util.*;

public class D_1_BinaryNumberSorting {
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int countOne = 0;
            String a = Integer.toBinaryString(num);
            for (char x : a.toCharArray()) {
                if (x == '1') {
                    countOne++;
                }
            }
            arr.add(new int[]{countOne, num});
        }

        Collections.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i)[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        D_1_BinaryNumberSorting T = new D_1_BinaryNumberSorting();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
    /**
     * [8,5,6,9,7]
     * [1,2,4,3,5]
     * [5,12,17,7,21,23,45]
     */
}

