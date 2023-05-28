package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Point62_2 {
    int y;
    int x;
    Point62_2(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
// 62번 unique paths
public class L62_2 {
    static int[] dy = {0, 1}; // 오 아래
    static int[] dx = {1, 0}; // 오 아래
    static int[][] board;
    static int m, n;

    public int uniquePaths(int m, int n) {
        board = new int[m][n];
        return bfs(m, n);
    }

    static int bfs(int y, int x) {
        int answer = 0;
        Queue<Point62> q = new LinkedList<>();
        q.offer(new Point62(0, 0));

        while(!q.isEmpty()) {
            Point62 current = q.poll();

            for(int i=0; i<2; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny>=m || nx>=n || ny<0 || nx<0) continue;
                q.offer(new Point62(ny, nx));
                board[ny][nx] += 1;
            }

        }
        answer = board[m-1][n-1];

        return answer;
    }
}
