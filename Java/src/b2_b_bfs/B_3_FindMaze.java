package b2_b_bfs;

import java.io.*;
import java.util.*;

// 15m
public class B_3_FindMaze {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                int cc = a.charAt(j) - '0';
                map[i][j] = cc;
            }
        }

        BFS(0, 0);
        System.out.println(visited[n-1][m-1]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            int[] qqq = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = qqq[0] + dx[i];
                int ny = qqq[1] + dy[i];

                if (nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] > 0 || map[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny});
                visited[nx][ny] = visited[qqq[0]][qqq[1]] + 1;
            }
        }
    }
}
