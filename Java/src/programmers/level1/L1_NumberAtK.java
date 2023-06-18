package programmers.level1;

import java.util.Arrays;

public class L1_NumberAtK {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) { // commands 길이만큼 answer에 채워야하기에
            // 찾기 쉬운 형태로 값 꺼내주기
            int startIndex = commands[i][0] -1;
            int endIndex = commands[i][1] -1;
            int kIndex = commands[i][2] -1; // 최종 위치

            // 새로운 배열 만들어주기
            int arr[] = new int[endIndex-startIndex+1];
            int resetIndex = 0;
            for(int j=startIndex; j<=endIndex; j++) {
                arr[resetIndex++] = array[j];
            }

            // 뽑은 배열 정렬(퀵정렬 n logn)
            Arrays.sort(arr);

            // 목표 값 찾아서 answer에 담아주기
            answer[i] = arr[kIndex];
        }
        return answer;
    }
}
