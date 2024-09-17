package inflearn2.b_hashing;

import java.util.*;

public class B_4_Subsequence_With_Negative_Numbers {
    public int solution(int[] nums, int m){
        int answer = 0;
        // 1. 조합 넣어줄 hashMap
        HashMap<Integer, Integer> combinationOfNumber = new HashMap<>();
        combinationOfNumber.put(0, 1); // 0 조합은 1개 가지고 시작

        // 2. for문 돌면서 조합 비교
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int targetNumber = sum - m;
            if (combinationOfNumber.containsKey(targetNumber)) {
                answer += combinationOfNumber.get(targetNumber);
            }
            combinationOfNumber.put(sum, combinationOfNumber.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        B_4_Subsequence_With_Negative_Numbers T = new B_4_Subsequence_With_Negative_Numbers();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5)); // 5
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5)); // 5
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3)); // 6
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0)); // 2
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0)); // 1
    }
}
