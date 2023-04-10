package programmers;
/**
 * 프로그래머스 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * */
public class WayToSchool {
    public static void main(String[] args) {
        Solution_WayToSchool st = new Solution_WayToSchool();
        int[][] puddles1 = {{2, 2}};
        int result1 = st.solution(4, 3, puddles1); // 예상 결과: 4
        System.out.println(result1);
    }
}
class Solution_WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] board = new int[n][m];

        // 웅덩이 0으로 만들어주기
        for (int i=0; i<puddles.length; i++) {
            // 좌표랑 인덱스를 맞추기 위해 -1
            int x = puddles[i][0] -1;
            int y = puddles[i][1] -1;
            board[x][y] = -1;
        }
        board[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 웅덩이면 건너뛰기
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                    continue;
                }
                if(i!=0){ // 위쪽에 값이 존재하면 더해주기
                    board[i][j] = board[i][j] + board[i-1][j] % mod;
                }
                if(j!=0){ // 왼쪽에 값이 존재하면 더해주기
                    board[i][j] = board[i][j] + board[i][j-1] % mod;
                }
            }
        }

        return board[n-1][m-1] % mod;
    }
}
