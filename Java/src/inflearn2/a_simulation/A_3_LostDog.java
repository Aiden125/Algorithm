package inflearn2.a_simulation;

import java.util.*;
class A_3_LostDog {
	public int solution(int[][] board){
		int answer = 0;

        int dirH = 0;
        int dirD = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[] curH = {0, 0};
        int[] curD = {0, 0};
        int[] nextH = {0, 0};
        int[] nextD = {0, 0};

        // 보드에서 현수, 강아지 위치 찾아서 넣어주기
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j] == 2) {
                    curH[0] = i;
                    curH[1] = j;
                } else if (board[i][j] == 3) {
                    curD[0] = i;
                    curD[1] = j;
                }
            }
        }

        int time = -1;
        while (++time <= 10000) {
            if (curH[0] == curD[0] && curH[1] == curD[1]) {
                break;
            }
            // 현수 움직이기
            nextH[0] = curH[0] + directions[dirH][0];
            nextH[1] = curH[1] + directions[dirH][1];
            if (nextH[0] >= board.length || nextH[1] >= board.length ||
                nextH[0] < 0 || nextH[1] < 0 || board[nextH[0]][nextH[1]] == 1) {
                    dirH = (dirH + 1) % directions.length;
            } else {
                curH[0] = nextH[0];
                curH[1] = nextH[1];
            }

            // 강아지 움직이기
            nextD[0] = curD[0] + directions[dirD][0];
            nextD[1] = curD[1] + directions[dirD][1];
            if (nextD[0] >= board.length || nextD[1] >= board.length ||
                nextD[0] < 0 || nextD[1] < 0 || board[nextD[0]][nextD[1]] == 1) {
                    dirD = (dirD + 1) % directions.length;
            } else {
                curD[0] = nextD[0];
                curD[1] = nextD[1];
            }
        }
        answer = time <= 10000 ? time : -1;
		
		return answer;		
	}

	public static void main(String[] args){
		A_3_LostDog T = new A_3_LostDog();
        int[][] arr3 = {
            {0, 2, 0}, 
            {0, 0, 0}, 
            {0, 0, 3},
        };
		System.out.println(T.solution(arr3)); // 2
		int[][] arr1 = {
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1)); // 51
		int[][] arr2 = {
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2)); // 17
	}
}