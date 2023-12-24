package programmers.kit.hash;

import java.util.HashMap;

public class Phoneketmon {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(Phoneketmon.solution(nums));

        int[] nums2 = {3,3,3,2,2,4};
        System.out.println(Phoneketmon.solution(nums2));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int possibleCount = nums.length / 2; // 집을 수 있는 최대 수
        HashMap<Integer, Integer> map = new HashMap<>();

        // 어차피 종류만 따지니까 1로 기록
        for (int num : nums) {
            map.put(num, 1);
        }

        // 키만큼 즉, 종류만큼 반복시키면서 종류 수 누적시키기
        for (int a : map.keySet()) {
            if (answer < possibleCount) {
                answer++;
            }
        }

        return answer;
    }
}
