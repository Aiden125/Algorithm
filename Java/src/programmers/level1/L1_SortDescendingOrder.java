package programmers.level1;

import java.util.Arrays;

public class L1_SortDescendingOrder {
    public static void main(String[] args) {

        int n = 118372;
        System.out.println(solution(n)); // expected: 873211
    }

    public static long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
