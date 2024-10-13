package inflearn2.e_greedy;

import java.util.*;

public class E_3_SpringCooler {
    public int solution(int n, int[] nums) {
        int answer = 0;

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) continue;
            int start = i - nums[i];
            int end = i + nums[i];
            int[] a = new int[]{start, end};
            arr.add(a);
        }
        Collections.sort(arr, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int idx = 0;
        int curX = 0;
        while (curX < n) {
            boolean found = false;
            int maxX = 0;

            // 인덱스 먼저 넣고 while문을 쓸거면 귀찮게 변수로 빼지 말자
            while (idx < arr.size() && arr.get(idx)[0] <= curX) {
                maxX = Math.max(arr.get(idx)[1], maxX);
                found = true;
                idx++;
            }
            if (found) {
                curX = maxX;
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        E_3_SpringCooler T = new E_3_SpringCooler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
        /**
         * 3
         * 1
         * -1
         * 3
         */
    }
}

