package b2.a_dfs;

import java.io.*;

public class A_5_Rgb {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] map1;
    static char[][] map2;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map1 = new char[n][n];
        map2 = new char[n][n];
        for (int i=0; i<n; i++) {
            String a = br.readLine();
            for (int j=0; j<a.length(); j++) {
                char x = a.charAt(j);
                map1[i][j] = x;
                map2[i][j] = x == 'G' ? 'R' : x; // G인 경우 R로 변경
            }
        }

        StringBuilder sb = new StringBuilder();

        visited = new boolean[n][n];
        count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                DFS(map1, map1[i][j], i, j);
                count++;
            }
        }
        sb.append(count + " ");


        visited = new boolean[n][n];
        count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                DFS(map2, map2[i][j], i, j);
                count++;
            }
        }
        sb.append(count);

        System.out.println(sb);
    }

    static void DFS(char[][] map, char start, int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
            if (visited[nx][ny] || map[nx][ny] != start) continue;
            DFS(map, start, nx, ny);
        }
    }
}
