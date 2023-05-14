package bakjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2{
    int y, x;
    Point2(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class B2178_2 {
    static int n, m;
    static int board[][];
    static boolean visited[][];
    static int distance[][];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        for(int i=0; i<n; i++) {
            String a = sc.next();
            for(int j=0; j<a.length(); j++) {
                int b = a.charAt(j) - '0';
                board[i][j] = b;
            }
        }

        dfs(0, 0);

        System.out.println(distance[n-1][m-1]+1);
    }

    static void dfs(int y, int x) {
        Queue<Point2> q = new LinkedList<>();
        q.offer(new Point2(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Point2 current = q.poll();

            for(int i=0; i<4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny<0 || nx<0 || ny>=n || nx>=m || visited[ny][nx]) continue;
                if (board[ny][nx] == 0) continue;
                q.offer(new Point2(ny, nx));
                visited[ny][nx] = true;
                distance[ny][nx] = distance[current.y][current.x] +1;
            }
        }
    }
}
