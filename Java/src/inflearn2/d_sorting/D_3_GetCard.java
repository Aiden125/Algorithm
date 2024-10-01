package inflearn2.d_sorting;

import java.util.*;

public class D_3_GetCard {
    public int solution(int[] nums, int k) {
        int answer = 0;

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        ArrayList<Integer> diffArr = new ArrayList<>();
        for (int i=0; i<arr.length; i = i+2) {
            diffArr.add(arr[i] - arr[i+1]);
        }
        Collections.sort(diffArr, (a, b) -> b.compareTo(a));

        HashMap<Integer, Integer> bestNumber = new HashMap<>();
        for (int i=0; i<k; i++) {
            bestNumber.put(diffArr.get(i), bestNumber.getOrDefault(diffArr.get(i), 0) + 1);
        }

        for (int i=0; i<arr.length; i=i+2) {
            int left = arr[i];
            int right = arr[i+1];
            int diff = left - right;
            if (bestNumber.containsKey(diff)) {
                answer += left;
                bestNumber.put(diff, bestNumber.getOrDefault(diff, 0) - 1);
                if (bestNumber.get(diff) == 0) {
                    bestNumber.remove(diff);
                }
            } else {
                answer += right;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        D_3_GetCard T = new D_3_GetCard();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
        /**
         * 28
         * 34
         * 60
         * 283
         * 129
         */
    }
}
