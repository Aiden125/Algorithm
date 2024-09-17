package inflearn2.b_hashing;

import java.util.*;

public class B_3_Make_Diff_Frequencies {
    public int solution(String s){
        int answer = 0;

        // 1. 몇번 사용했는지
        HashMap<Character, Integer> useCount = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            useCount.put(s.charAt(i), useCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 2. 사용 횟수 표기 set을 사용해서 중복된 사용횟수 있는지 비교
        HashSet<Integer> set = new HashSet<>();
        for (char c : useCount.keySet()) {
            int used = useCount.get(c);
            while (set.contains(used) && used > 0) {
                answer++;
                used--;
            }

            if (used != 0) {
                set.add(used);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        B_3_Make_Diff_Frequencies T = new B_3_Make_Diff_Frequencies();
        System.out.println(T.solution("aaabbbcc")); // 2
        System.out.println(T.solution("aaabbc")); // 0
        System.out.println(T.solution("aebbbbc")); // 2
        System.out.println(T.solution("aaabbbcccde")); // 5
        System.out.println(T.solution("aaabbbcccdddeeeeeff")); // 8
    }
}
