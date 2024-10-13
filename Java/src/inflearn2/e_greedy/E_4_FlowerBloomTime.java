package inflearn2.e_greedy;

import java.util.*;

public class E_4_FlowerBloomTime {
    public int solution(int[] plantTime, int[] growTime) {
        int answer = 0;

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i=0; i<plantTime.length; i++) {
            arr.add(new int[] {growTime[i], plantTime[i]});
        }

        Collections.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]); // 앞에 오게하고 싶으면 앞에다 쓰기

        int max = -1;
        int curTime = 0;
        for (int i=0; i<arr.size(); i++) {
            int[] x = arr.get(i);
            curTime += x[1];
            max = Math.max(max, curTime + x[0]);
        }
        answer = max;
        return answer;
    }

    public static void main(String[] args) {
        E_4_FlowerBloomTime T = new E_4_FlowerBloomTime();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
        /**
         * 8
         * 11
         * 8
         * 54
         * 29
         */

    }
}
