package programmers;

import java.util.HashMap;
import java.util.Map;

public class L1_1 {
    public static void main(String[] args) {
        Solution1_1 st = new Solution1_1();
        System.out.println(st.solution("banana"));
    }
}
class Solution1_1 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            if (map.get(a) == null) {
                answer[i] = -1;
            }else {
                answer[i] = i - map.get(a);
            }
            map.put(a, i);

        }
        return answer;
    }
}
