package b2.a_dfs;

import java.io.*;
import java.util.*;

public class A_4_MeasureArea {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, k;
        String[] a = br.readLine().split(" ");
        m = Integer.parseInt(a[0]); // i
        n = Integer.parseInt(a[1]); // j
        k = Integer.parseInt(a[2]); // coordinate(좌표)

        int[][] map = new int[m][n];
        visited = new boolean[m][n];
        for (int z=0; z<k; z++) {
            String[] b = br.readLine().split(" ");
            int startJ = Integer.parseInt(b[0]);
            int startI = Integer.parseInt(b[1]);
            int endJ = Integer.parseInt(b[2]);
            int endI = Integer.parseInt(b[3]);

            for (int i=startI; i<endI; i++) {
                for (int j=startJ; j<endJ; j++) {
                    map[i][j] = -1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] || map[i][j] == -1) continue;
                count = 0;
                DFS(map, i, j);
                answer.add(count);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size());
        sb.append("\n");
        for (int x : answer) {
            sb.append(x);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static void DFS(int[][] map, int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
            if (map[nx][ny] == -1 || visited[nx][ny]) continue;
            DFS(map, nx, ny);
        }
    }
}
