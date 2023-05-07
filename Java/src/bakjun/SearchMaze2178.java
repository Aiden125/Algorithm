package bakjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 "미로 탐색" 문제
public class SearchMaze2178 {
    static int n; // 세로
    static int m; // 가로

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 좌표
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 좌표
    static int[][] vec;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        vec = new int[n][m];
        visited = new boolean[n][m];
        
        // 입력
        for(int i=0; i<n; i++) {
            String line = sc.next();
            for(int j=0; j<m; j++) {
                vec[i][j] = line.charAt(j) -'0';
            }
        }

        visited[0][0] = true;
        bfs(0, 0); // x, y 좌표
        System.out.println(vec[n-1][m-1]);
        
    }

    static void bfs(int x, int y) {
        // q에 배열을 넣는 법
        Queue<int[]> q = new LinkedList<>();
        // q에 좌표배열을 넣어버림
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >=n || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY] || vec[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new int[] {nextX, nextY});
                vec[nextX][nextY] = vec[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }

        }
    }
}
