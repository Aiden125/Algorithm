package b2.a_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_3_SetNumberApt {
    static boolean[][] visited;
    static int homeCount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            int j = 0;
            for (char a : line.toCharArray()) {
                map[i][j] = a - '0';
                j++;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;
                homeCount = 0;
                DFS(map, i, j);
                answer.add(homeCount);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);
        sb.append(answer.size());
        sb.append("\n");
        for (int x : answer) {
            sb.append(x);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int[][] map, int x, int y) {
        visited[x][y] = true;
        homeCount++;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
            if (map[nx][ny] == 0 || visited[nx][ny]) continue;
            DFS(map, nx, ny);
        }
    }
}
