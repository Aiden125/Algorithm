package bakjun.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 3 6 세로 가로, D==굴, S==고슴도치, *==물, X==돌
 * D...*.
 * .X.X..
 * ....S.
 */
public class Escape3055 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int[][] dis;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        dis = new int[n][m];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int[] endLocation = new int[2];

        for (int i=0; i<n; i++) {
            String str = sc.next();
            for (int j=0; j<str.length(); j++) {
                char word = str.charAt(j);
                board[i][j] = word;
                if (word == '*') {
                    q1.offer(new int[] {i, j});
                    dis[i][j] = 1;
                } else if (word == 'S') {
                    q2.offer(new int[] {i, j});
                    dis[i][j] = 1;
                } else if (word == 'D') {
                    endLocation = new int[] {i, j};
                }
            }
        }

        BFS(q1, q2);

        if (board[endLocation[0]][endLocation[1]] == 'S') {
            System.out.println(dis[endLocation[0]][endLocation[1]] - 1);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static void BFS(Queue<int[]> q1, Queue<int[]> q2) {
        Queue<int[]> q = new LinkedList<>();
        while(!q1.isEmpty()) {
            q.offer(q1.poll());
        }
        while(!q2.isEmpty()) {
            q.offer(q2.poll());
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i=0; i<dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dis[nx][ny] > 0 || board[nx][ny] == 'X' || dis[nx][ny] == 'S' || dis[nx][ny] == '*') continue;
                if (board[curX][curY] == '*' && board[nx][ny] == 'D') continue;

                q.offer(new int[] {nx, ny});
                dis[nx][ny] = dis[curX][curY] + 1;
                board[nx][ny] = board[curX][curY];
            }
        }
    }
}
