package bakjun.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Input
 * 6 4 (가로, 세로), 1은 익은 토마토, 0은 안익은, -1은 토마토 없음, 최소 기간 출력
 * 1 -1 0 0 0 0
 * 0 -1 0 0 0 0
 * 0 0 0 0 -1 0
 * 0 0 0 0 -1 1
 */
public class Tomato7576_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m,n;
    static int[][] board, dis;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        m = Integer.parseInt(s[0]); // 가로
        n = Integer.parseInt(s[1]); // 세로

        board = new int[n][m];
        dis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        // 입력 채워주기 및 익은 토마토면 q에 넣기
        for (int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            for (int j=0; j<s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if (board[i][j] == 0) {
                    dis[i][j] = -1;
                } else if (board[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    dis[i][j] = 1;
                }
            }
        }

        BFS(q);

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dis[i][j] == -1) {
                    count = -1;
                }
            }
        }

        if (count > 0) count -= 1;
        System.out.println(count);

    }

    static void BFS(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int k=0; k<4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == -1 || dis[nx][ny] > 0) {
                    continue;
                }
                q.offer(new int[] {nx, ny});
                dis[nx][ny] = dis[current[0]][current[1]] + 1;
                count = Math.max(count, dis[nx][ny]);
            }
        }
    }
}
