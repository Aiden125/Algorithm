package bakjun.dfsbfs;

import java.util.Scanner;

public class ColorBlindness10026 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] board;
    static char[][] board2;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new char[n][n];
        board2 = new char[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String line = sc.next();
            for (int j=0; j<line.length(); j++) {
                board[i][j] = line.charAt(j);
                board2[i][j] = line.charAt(j) == 'G' ? 'R' : line.charAt(j);
            }
        }

        int aCount = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    int a = DFS(i, j, 1, board[i][j]);
                    aCount += a;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                visited[i][j] = false;
            }
        }

        int bCount = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    int b = DFS(i, j, 2, board2[i][j]);
                    bCount += b;
                }
            }
        }

        System.out.println(aCount + " " + bCount);

    }

    static int DFS(int x, int y,int flag, char keyword) {
        visited[x][y] = true;
        for (int k=0; k<4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (flag == 1 && board[nx][ny] != keyword || visited[nx][ny]) {
                continue;
            }
            if (flag == 2 && board2[nx][ny] != keyword || visited[nx][ny]) {
                continue;
            }
            DFS(nx, ny, flag, keyword);
        }

        return 1;
    }
}
