package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N78_re {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        backT(new ArrayList<>(temp), nums, 0);
        return answer;
    }

    void backT(List<Integer> path, int[] nums, int index) {
        answer.add(new ArrayList<>(path));

        for (int i=index; i<nums.length; i++) {
            path.add(nums[i]);
            backT(path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
