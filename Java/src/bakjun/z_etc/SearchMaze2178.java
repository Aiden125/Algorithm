package bakjun.z_etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class SearchMaze2178 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        for(int i=0; i<n; i++) {
            String a = sc.next();
            for(int j=0; j<a.length(); j++) {
                map[i][j] = Character.getNumericValue(a.charAt(j));
            }
        }

        dfs(0, 0);

        System.out.println(distance[n-1][m-1]);
    }

    static void dfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point a = q.poll();
            visited[a.x][a.y] = true;

            for(int i=0; i<4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];

                // out of Index
                if(ny <0 || nx<0 || nx >= n || ny>=m) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                q.offer(new Point(nx, ny));
                distance[nx][ny] = distance[a.x][a.y] + 1;
            }
        }
    }
}
