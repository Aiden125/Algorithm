package bakjun.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** Input
 * 3 4 5 (세로, 가로, 음식물 개수), 세로-가로 <= 100
 * 3 2
 * 2 2
 * 3 1
 * 2 3
 * 1 1
 */
public class AvoidFood1743_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] board;
    static int n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new boolean[n+1][m+1];

        for (int i=0; i<k; i++) {
            board[sc.nextInt()][sc.nextInt()] = true; // 음식물이 있는 경우
        }

        int countMax = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                // 음식물이 있으면서 방문 안한경우 방문
                if (board[i][j]) {
                    countMax = Math.max(countMax, BFS(i, j));
                }
            }
        }

        System.out.println(countMax);
    }

    static int BFS(int x, int y) {
        int answer = 1;
        Queue<int[] > q = new LinkedList<>();
        q.offer(new int[] {x, y});
        board[x][y] = false;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int k=0; k<4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (!board[nx][ny]) continue;
                q.offer(new int[] {nx, ny});
                board[nx][ny] = false;
                answer++;
            }
        }

        return answer;
    }
}
