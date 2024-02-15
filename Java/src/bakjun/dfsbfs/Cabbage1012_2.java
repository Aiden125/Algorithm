package bakjun.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cabbage1012_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    static int T, M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> answer = new ArrayList<>();
        T = Integer.parseInt(br.readLine());

        for (int k=0; k<T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken());; // 세로 길이
            K = Integer.parseInt(st.nextToken());; // 배추 심어진 갯수

            board = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심어진 땅
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
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
