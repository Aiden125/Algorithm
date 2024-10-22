package inflearn2.f_dfs;

import java.util.*;

public class F_4_Palindrome {
    HashSet<String> answerSet;
    boolean[] used;
    int n;
    public String[] solution(String s) {
        String[] answer = {};

        // 초기화
        n = s.length();
        answerSet = new HashSet<>();
        used = new boolean[n];

        // 순환
        DFS(0, s, "");

        if (answerSet.isEmpty()) return answer;
        answer = new String[answerSet.size()];
        int c = 0;
        for (String a : answerSet) {
            answer[c++] = a;
        }

        return answer;
    }

    void DFS(int depth, String s, String curString) {

        if (depth == s.length()) {
            StringBuilder a = new StringBuilder();
            a.append(curString);
            a.reverse();
            if (a.toString().equals(curString)) {
                answerSet.add(curString);
            }
        }
        for (int i=0; i<s.length(); i++) {
            if (used[i]) continue;

            char a = s.charAt(i);
            used[i] = true;
            DFS(depth + 1, s, curString + a);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        F_4_Palindrome T = new F_4_Palindrome();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
        /**
         * baaab, aabbaa, abaaba
         * bcacb, cbabc
         * 6개의 정답
         * []
         * 12개의 정답
         */
    }
}