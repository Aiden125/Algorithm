package bakjun.graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Cabbage1012 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    static int T, M, N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> answer = new ArrayList<>();
        T = sc.nextInt();

        for (int k=0; k<T; k++) {
            M = sc.nextInt(); // 가로 길이
            N = sc.nextInt(); // 세로 길이
            K = sc.nextInt(); // 배추 심어진 갯수

            board = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심어진 땅
            for (int i=0; i<K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }

            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    // 방문 안했고 배추 심어져 있으면 고
                    if (!visited[i][j] && board[i][j] == 1) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            answer.add(count);
            
            // 방문 배열, 보드 초기화
            for (int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;
                }
            }
        }

        for (int c : answer) {
            System.out.println(c);
        }

    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int k=0; k<4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            } else if (visited[nx][ny] || board[nx][ny] != 1) {
                continue;
            }
            DFS(nx, ny);
        }

    }
}
