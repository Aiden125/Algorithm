package inflearn2.e_greedy;

import java.util.*;

public class E_1_Titanic {
    public int solution(int[] nums, int m) {
        int answer = 0;

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= m) {
                l++;
                r--;
                answer++;
            } else {
                r--;
                answer++;
            }
        }
        /**
         * 50 100 100 100 이렇게 있더라도 어차피 마지막 answer는 하나 늘어나기 때문에
         * 위에서 l < r로 하고 밑에 if문을 쓰는 대신
         * 그냥 l <= r로 처리해도 같은 결과
         */
//        if (l==r) {
//            answer++;
//        }

        return answer;
    }

    public static void main(String[] args) {
        E_1_Titanic T = new E_1_Titanic();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
        /**
         * 3
         * 5
         * 14
         */
    }
}
