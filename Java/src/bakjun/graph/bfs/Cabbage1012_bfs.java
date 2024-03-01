package bakjun.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cabbage1012_bfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, n, m;
    static boolean[][] board;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 개수, 세로, 가로, 총 지문 개수
        t = sc.nextInt();

        while (--t >= 0) {
            // 땅 만들기
            n = sc.nextInt();
            m = sc.nextInt();
            board = new boolean[n][m];
            visited = new boolean[n][m];

            int a = sc.nextInt();
            for (int i=0; i<a; i++) {
                board[sc.nextInt()][sc.nextInt()] = true;
            }

            int count = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (!visited[i][j] && board[i][j]) {
                        visited[i][j] = true;
                        BFS(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] currentNode = q.poll();
//            visited[currentNode[0]][currentNode[1]] = true; // 여기서 하면 이미 중복된걸 많이 넣기 때문에 메모리 초과

            for (int k=0; k<4; k++) {
                int nx = currentNode[0] + dx[k];
                int ny = currentNode[1] + dy[k];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (visited[nx][ny] || !board[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
    }

}