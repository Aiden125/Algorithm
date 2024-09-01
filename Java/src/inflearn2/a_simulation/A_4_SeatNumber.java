package inflearn2.a_simulation;

import java.util.*;

public class A_4_SeatNumber {
    // 가로 c, 세로 r
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];

        // 방향 정의
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;

        // 예외처리(의자보다 사람이 많은 경우)
        if (k > c * r) {
            return answer;
        }

        // 방문 체크
        boolean[][] arr = new boolean[c][r];
        int[] location = {0, 0};
        arr[0][0] = true;

        // 오는 사람 순서대로 배정
        int count = 1;
        while (count < k) {
            int currentX = location[0];
            int currentY = location[1];
            int nextX = currentX + directions[dirIndex][0];
            int nextY = currentY + directions[dirIndex][1];

            if (nextX < 0 || nextY < 0 || nextX >= c || nextY >= r || arr[nextX][nextY]) {
                dirIndex = (dirIndex + 1) % 4;
                continue;
            }

            location[0] = nextX;
            location[1] = nextY;
            arr[nextX][nextY] = true;
            count++;
        }

        answer[0] = location[0] + 1;
        answer[1] = location[1] + 1;

        return answer;
    }

    public static void main(String[] args) {
        A_4_SeatNumber T = new A_4_SeatNumber();
        System.out.println(Arrays.toString(T.solution(6, 5, 12))); // 6,3
        System.out.println(Arrays.toString(T.solution(6, 5, 20))); // 2,3
        System.out.println(Arrays.toString(T.solution(6, 5, 30))); // 4,3
        System.out.println(Arrays.toString(T.solution(6, 5, 31))); // 0,0
    }
}