package programmers.level1;

import java.util.Arrays;

public class L1_XIntervalN {
    public static void main(String[] args) {

        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(solution(x, n)));
    }
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        long expend = x;
        for(int i=0; i<n; i++) {
            answer[i] = expend;
            expend += x;
        }
        return answer;
    }

}
