package inflearn2.a_simulation;

import java.util.*;
class A_1_Ladder {
	public char[] solution(int n, int[][] ladder){
		char[] answer = new char[n];
		
        // 보드 색칠
        int[][] board = new int[ladder.length][n];
        for (int i=0; i<ladder.length; i++) {
            for (int num : ladder[i]) {
                board[i][num-1] = 1;
                board[i][num] = -1;
            }
        }

        // 각 멤버들이 보드 따라가기
        for (int j=0; j<n; j++) {
            int currentLocation = j;
            int nextLocation = 0;
            for (int i=0; i<board.length; i++) {
                nextLocation = currentLocation + board[i][currentLocation];
                currentLocation = nextLocation;
            }
            answer[currentLocation] = (char)(j + 65);
        }

		return answer;
	}

	public static void main(String[] args){
		A_1_Ladder T = new A_1_Ladder();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}