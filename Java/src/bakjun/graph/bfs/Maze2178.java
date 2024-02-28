package bakjun.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dis;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        // board 채워주기
        for (int i=1; i<=n; i++) {
            String[] s = br.readLine().split("");
            int j = 1;
            for (String a : s) {
                board[i][j] = Integer.parseInt(a);
                j++;
            }
        }

        dis[1][1] = 1;
        BFS(1, 1);
        System.out.println(dis[n][m]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] current = q.poll();

            for (int k=0; k<4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (dis[nx][ny] > 0 || board[nx][ny] == 0) continue;
                dis[nx][ny] = dis[current[0]][current[1]] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
    }
}
