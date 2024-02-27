package bakjun.graph.dfs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class FindArea2583 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] board;
    static boolean[][] visited;
    static int m, n;
    static int countMap = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        
        board = new boolean[m][n];
        visited = new boolean[m][n];
        
        // 못지나가는 영역 처리해주기
        while(--k >= 0) {
            int startJ = sc.nextInt();
            int startI = sc.nextInt();
            int endJ = sc.nextInt();
            int endI = sc.nextInt();
            for (int i=startI; i<endI; i++) {
                for (int j=startJ; j<endJ; j++) {
                    board[i][j] = true;
                    visited[i][j] = true;
                }
            }
        }

        ArrayList<Integer> preAnswer = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!board[i][j] && !visited[i][j]) { // board가 false면 가능한 땅, visited false면 안간 곳
                    int count = DFS(i, j);
                    preAnswer.add(count);
                    countMap = 0;
                }
            }
        }
        Collections.sort(preAnswer);
        System.out.println(preAnswer.size());
        for (int a : preAnswer) {
            System.out.print(a + " ");
        }

    }

    static int DFS(int x, int y) {
        visited[x][y] = true;
        countMap++;

        for (int k=0; k<4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            } else if (board[nx][ny] || visited[nx][ny]) {
                continue;
            }
            DFS(nx, ny);
        }
        return countMap;
    }
}
