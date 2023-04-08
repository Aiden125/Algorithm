package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class N78Other {
    public static void main(String[] args) {
        Solution78O st = new Solution78O();
        // Test Case 1
        String[] strs = {"A","B","C"};
        List<List<String>> result1 = st.subsets2(strs);
        System.out.println(result1); // 예상 출력: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

    }
}
class Solution78O {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> subsets2(String[] strs) {
        List<String> a = new ArrayList<>();
        backT2(a, strs, 0);

        return answer;
    }

    public void backT2(List<String> path, String[] strs, int index) {
        answer.add(new ArrayList<>(path));

        for(int i=index; i<strs.length; i++) {
            path.add(strs[i]);
            backT2(path, strs, i+1);
            path.remove(path.size()-1); // 마지막 인덱스 제거
        }
    }
}