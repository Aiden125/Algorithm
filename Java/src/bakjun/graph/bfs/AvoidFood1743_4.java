package bakjun.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** Input
 * 3 4 5 (세로, 가로, 음식물 개수), 세로-가로 <= 100
 * 3 2
 * 2 2
 * 3 1
 * 2 3
 * 1 1
 */
/** BufferedRader를 쓰는 것과 Scanner를 쓰는것에 메모리 차이도 생긴다. */

public class AvoidFood1743_4 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] board;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new boolean[n+1][m+1];

        for (int i=0; i<k; i++) {
            String[] s = br.readLine().split(" ");
            board[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true; // 음식물이 있는 경우
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
        Queue<int[]> q = new LinkedList<>();
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

