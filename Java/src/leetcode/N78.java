package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 리트코드 subset
 * https://leetcode.com/problems/subsets/
 * */

public class N78 {
    public static void main(String[] args) {
        Solution78 st = new Solution78();
        // Test Case 1
        int[] nums1 = {1,2,3};
        List<List<Integer>> result1 = st.subsets(nums1);
        System.out.println(result1); // 예상 출력: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

        // Test Case 2
//        int[] nums2 = {0};
//        List<List<Integer>> result2 = st.subsets(nums2);
//        System.out.println(result2); // 예상 출력: [[], [0]]
    }
}
class Solution78 {
        List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> a = new ArrayList<>();
        backT(a, nums, 0);

        return answer;
    }

    public void backT(List<Integer> b, int[] nums, int index) {
        answer.add(new ArrayList<>(b));

        for(int i=index; i<nums.length; i++) {
            b.add(nums[i]);
            backT(b, nums, i+1);
            b.remove(b.size()-1); // 마지막 인덱스 제거
        }
    }
}