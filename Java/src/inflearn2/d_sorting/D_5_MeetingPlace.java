package inflearn2.d_sorting;

import java.util.*;

public class D_5_MeetingPlace {
    public int solution(int[][] board) {
        int answer = 0;

        ArrayList<int[]> students = new ArrayList<>();

        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 1) {
                    students.add(new int[] {i, j});
                }
            }
        }

        ArrayList<Integer> distance = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 0) {
                    int curDistance = 0;
                    for (int k=0; k<students.size(); k++) {
                        int x = students.get(k)[0];
                        int y = students.get(k)[1];
                        curDistance += Math.abs(x - i) + Math.abs(y - j);
                    }
                    distance.add(curDistance);
                }
            }
        }

        Collections.sort(distance);
        answer = distance.get(0);

        return answer;
    }

    public static void main(String[] args) {
        D_5_MeetingPlace T = new D_5_MeetingPlace();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
        /**
         * 8
         * 8
         * 37
         */
    }
}
