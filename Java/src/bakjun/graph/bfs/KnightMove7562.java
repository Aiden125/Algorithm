package bakjun.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 3 // T테스트 케이스
 * 8 // 세로 가로 크기
 * 0 0 // 나이트 출발 위치
 * 7 0 // 도착 예정지
 * 100
 * 0 0
 * 30 50
 * 10
 * 1 1
 * 1 1
 */
public class KnightMove7562 {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int T;
    static int n;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i=0; i<T; i++) {
            n = sc.nextInt();
            board = new int[n][n];

            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            BFS(startX, startY);
            System.out.println(board[endX][endY] - 1);
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        board[x][y] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int i=0; i<dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] > 0) continue;

                q.offer(new int[] {nx, ny});
                board[nx][ny] = board[current[0]][current[1]] + 1;
            }
        }
    }
}
