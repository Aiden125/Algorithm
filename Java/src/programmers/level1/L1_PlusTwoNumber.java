package programmers.level1;

import java.util.Arrays;
// L1 두 개 뽑아서 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class L1_PlusTwoNumber {
    public static void main(String[] args) {

        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        boolean[] bo = new boolean[10001];
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int a = numbers[i];
                int b = numbers[j];

                bo[a+b] = true;
            }
        }

        int count = 0;
        for(int i=0; i<bo.length; i++) {
            if(bo[i]) count++;
        }

        answer = new int[count];

        int count2 = 0;
        for(int i=0; i<bo.length; i++) {
            if(bo[i]) {
                answer[count2++] = i;
            }
        }

        return answer;
    }
}
