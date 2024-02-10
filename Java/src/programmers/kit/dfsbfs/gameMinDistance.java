package programmers.kit.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// 0은 벽이 있는 자리, 1은 벽 없는 자리
// x, y헷갈리지 않게 주의
// 배열에서 i == height, h == width와 같음
public class gameMinDistance {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {

    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int width = maps[0].length;
        int height = maps.length;
        int[][] visit = new int[height][width];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0)); // 0,0시작
        visit[0][0] = 1; // 칸을 세는 거기 때문에 처음에 1부터 시작

        while (!q.isEmpty()) {
            Node position = q.poll();
            int curX = position.x;
            int curY = position.y;

            // 최종점 찾은 경우, 답을 못찾는 경우 종료
            if (curX == height-1 && curY == width-1) break;
            if (maps[height-1][width-1] == 0) break;

            // 4방향 탐구
            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 오버 플로우 처리
                if (nx < 0 || nx > height-1 || ny < 0 || ny > width-1) {
                    continue;
                }
                // 막힌길, 이미 방문한 곳 제외
                if (maps[nx][ny] == 0 || visit[nx][ny] > 0) {
                    continue;
                }
                q.offer(new Node(nx, ny));
                visit[nx][ny] = visit[curX][curY] + 1; // 거리 1증가

            }
        }

        // 값이 있으면 넣고 없으면 -1
        if (visit[height-1][width-1] > 0) {
            answer = visit[height-1][width-1];
        } else {
            answer = -1;
        }

        return answer;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
