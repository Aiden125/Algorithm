package bakjun.dfsbfs;

import java.util.HashMap;
import java.util.Scanner;

public class Alphabet1987 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] visited;
    static int r, c;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); // 세로
        c = sc.nextInt(); // 가로

        board = new char[r][c];
        visited = new boolean[r][c];
        for (int i=0; i<r; i++) {
            String a = sc.next();
            for (int j=0; j<a.length(); j++) {
                board[i][j] = a.charAt(j);
            }
        }
        HashMap<Character, Boolean> duplicated = new HashMap<>();
        DFS(1, 0, 0, duplicated);

        System.out.println(max);
    }

    static void DFS(int dis, int x, int y, HashMap<Character, Boolean> duplicated) {
        max = Math.max(max, dis);
        visited[x][y] = true;
        duplicated.put(board[x][y], true);

        for (int k=0; k<4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            } else if (visited[nx][ny]) {
                continue;
            } else if (duplicated.getOrDefault(board[nx][ny], false)) {
                continue;
            }
            DFS(dis + 1, nx, ny, duplicated);
            visited[nx][ny] = false;
            duplicated.put(board[nx][ny], false);
        }

    }
}
