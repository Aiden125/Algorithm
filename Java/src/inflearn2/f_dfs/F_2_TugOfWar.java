package inflearn2.f_dfs;

import java.util.*;

public class F_2_TugOfWar {
    HashSet<String> set;
    boolean[] used;
    String students = "1234567";
    int totalAnswer;

    public int solution(int[][] fight) {
        int answer = 0;
        totalAnswer = 0;
        set = new HashSet<String>();
        used = new boolean[7];

        for (int i=0; i<fight.length; i++) {
            String a = fight[i][0] + "" + fight[i][1];
            String b = fight[i][1] + "" + fight[i][0];
            set.add(a);
            set.add(b);
        }

        dfs(0, "");

        answer = totalAnswer;
        return answer;
    }

    void dfs(int depth, String line) {
        if (line.length() >= 2) {
            String twoStudents = line.substring(line.length()-2);
            if (set.contains(twoStudents)) return;
        }

        if (depth == 7) {
            totalAnswer++;
            return;
        }

        for (int i=0; i<students.length(); i++) {
            if (used[i]) continue;

            String a = line + students.charAt(i);
            used[i] = true;
            dfs(depth+1, a);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        F_2_TugOfWar T = new F_2_TugOfWar();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        /**
         * 1968
         * 864
         * 720
         * 3600
         * 646
         */
    }
}
