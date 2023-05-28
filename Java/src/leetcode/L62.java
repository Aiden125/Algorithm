package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point62 {
    int y;
    int x;
    Point62(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
// 62번 unique paths
public class L62 {
    static int[] dy = {0, 1}; // 오 아래
    static int[] dx = {1, 0}; // 오 아래
    static int[][] board;
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[m][n];
        System.out.println(solution(m, n));
    }

    public static int solution(int m, int n) {
        int answer = dfs(0, 0);
        return answer;
    }

    static int dfs(int y, int x) {
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
