package bakjun.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ApartNumbering {
    static ArrayList<Integer> complex = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 맵 받아서 색칠하기
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 맵이 방문 가능하면 dfs 탐색
                if (map[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j, map);
                    complex.add(count);
                    count = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(complex.size()).append("\n");
        Collections.sort(complex, Collections.reverseOrder());
        for (int i=complex.size()-1; i>=0; i--) {
            sb.append(complex.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x, int y, int[][] map) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            } else if (map[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            count++;
            DFS(nx, ny, map);
        }
    }
}
