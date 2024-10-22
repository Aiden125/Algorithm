package inflearn2.f_dfs;

public class F_3_BadukCompetition {
    int whiteTeamCounter;
    int minDiff;
    public int solution(int[][] cans) {
        int answer = 0;

        // 초기화
        whiteTeamCounter = 0;
        minDiff = Integer.MAX_VALUE;
        
        DFS(0, cans, 0, 0);
        answer = minDiff;
        return answer;
    }
    
    void DFS(int depth, int[][] cans, int wScore, int bScore) {

        if (depth == cans.length) {
            if (whiteTeamCounter == cans.length/2) {
                minDiff = Math.min(minDiff, Math.abs(wScore - bScore));
            }
            return;
        }
        for (int i=0; i<2; i++) {
            if (i==0) {
                whiteTeamCounter++;
                DFS(depth+1, cans, wScore + cans[depth][i], bScore);
                whiteTeamCounter--;
            } else {
                DFS(depth+1, cans, wScore, bScore + cans[depth][i]);
            }
        }
    }


    public static void main(String[] args) {
        F_3_BadukCompetition T = new F_3_BadukCompetition();
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
