package inflearn2.f_dfs;

public class F_3_BadukCompetition_2 {
    int minDiff;
    boolean[] whiteTeams;
    public int solution(int[][] cans) {
        int answer = 0;

        // 초기화
        whiteTeams = new boolean[cans.length];
        minDiff = Integer.MAX_VALUE;
        
        DFS(0, cans);
        answer = minDiff;
        return answer;
    }
    
    void DFS(int depth, int[][] cans) {

        if (depth == cans.length / 2) {
            int wScore = 0;
            int bScore = 0;
            for (int i=0; i<cans.length; i++) {
                if (whiteTeams[i]) {
                    wScore += cans[i][0];
                } else {
                    bScore += cans[i][1];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(wScore - bScore));
            return;
        }

        for (int i=0; i<cans.length; i++) {
            if (whiteTeams[i]) continue;

            whiteTeams[i] = true;
            DFS(depth + 1, cans);
            whiteTeams[i] = false;
        }
    }


    public static void main(String[] args) {
        F_3_BadukCompetition_2 T = new F_3_BadukCompetition_2();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
        /**
         * 2
         * 0
         * 1
         */
    }

}
