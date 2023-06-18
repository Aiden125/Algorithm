package programmers.level1;

import java.util.Arrays;

public class L1_ReverseArray {
    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        int[] answer = {};
        String s = String.valueOf(n);
        answer = new int[s.length()];
        int reverseI = 0;
        for(int i=s.length()-1; i>=0; i--) {
            int value = Integer.parseInt(String.valueOf(s.charAt(i)));
            answer[reverseI++] = value;
        }
        return answer;
    }
}
