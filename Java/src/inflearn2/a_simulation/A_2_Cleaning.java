package inflearn2.a_simulation;

import java.util.*;
class A_2_Cleaning {
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2]; 
        int time = k;
		
		// 보드 돌 방향 정의
        int direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		// 현재, 다음 방향
		int curX = 0;
		int curY = 0;
		int nextX = 0;
		int nextY = 0;

		// 시간초에 따라 방향 결정
        while (time-- > 0) { // 초 계산 헷갈리면 1초인 경우 떠올리기
			nextX = curX + directions[direction][0];
			nextY = curY + directions[direction][1];

			// 오버플로우 or 벽에 막히면 무조건 회전
			if (nextX >= board.length || nextY >= board.length ||
				nextX < 0 || nextY < 0 ||
				board[nextX][nextY] == 1) {
				direction = (direction + 1) % directions.length;
				continue;
			} else if (board[nextX][nextY] == 0) { // 갈 수 있으면 이동하기
				curX = nextX;
				curY = nextY;
			}

        }
		answer[0] = curX;
		answer[1] = curY;
		return answer;
	}

	public static void main(String[] args){
		A_2_Cleaning T = new A_2_Cleaning();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}
}