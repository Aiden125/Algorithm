package b2_b_bfs;

import java.io.*;
import java.util.*;

// 25m
public class B_2_OrganicCabbage {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int z = 0; z < T; z++) {
            String[] a = br.readLine().split(" ");
            m = Integer.parseInt(a[0]); // 가로(j)
            n = Integer.parseInt(a[1]); // 세로(i)
            k = Integer.parseInt(a[2]); // 배추가 심어진 위치

            map = new int[m][n]; // 가로, 세로
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                String[] b = br.readLine().split(" ");
                int c = Integer.parseInt(b[0]);
                int d = Integer.parseInt(b[1]);
                map[c][d] = 1;
            }

            int answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j< n; j++) {
                    if (visited[i][j] || map[i][j] == 0) continue;
                    BFS(i, j);
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}
