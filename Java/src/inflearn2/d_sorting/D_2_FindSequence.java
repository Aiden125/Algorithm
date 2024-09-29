package inflearn2.d_sorting;

import java.util.*;

public class D_2_FindSequence {
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];

        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            int x2 = x * 2;
            if (map.getOrDefault(x2, -1) > 0) {
                map.put(x2, map.get(x2) - 1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int x : nums) {
            if (map.getOrDefault(x, -1) > 0) {
                arr.add(x);
                map.put(x, map.get(x) - 1);
            }
        }

        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        D_2_FindSequence T = new D_2_FindSequence();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
        /**
         * 1,3,5
         * 1,1,3,7
         * 2,3,5,5,7,7
         */
    }
}
