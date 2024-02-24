package bakjun.bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MoonTrip17484 {
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int[][] board;
    static int cost = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        board = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int startJ = -1;
        for (int j=0; j<m; j++) {
            if (min > board[0][j]) {
                startJ = j;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, startJ));
        cost += board[0][startJ];

        int preDirection = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            int minValue = Integer.MAX_VALUE;
            int currentDirection = -1;
            for (int i=0; i<3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (ny < 0 || ny >= m) continue;
                if (preDirection == i) continue;
                if (minValue > board[nx][ny]) {
                    currentDirection = i;
                }
            }
            preDirection = currentDirection;

            q.offer(new Node(x + dx[preDirection], y + dy[preDirection]));
            cost += board[x + dx[preDirection]][y + dy[preDirection]];
            if (x + dx[preDirection] >= n - 1) break;
        }

        System.out.println(cost);
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