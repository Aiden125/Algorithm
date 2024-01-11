package programmers.kit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {4,5};
        int[] reserve = {3,4};
        System.out.println(GymSuit.solution(n, lost, reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.sort(lost);

        for (int i=0; i<n; i++) {
            arr[i] = 1;
        }

        for (int i=0; i<lost.length; i++) {
            arr[lost[i]-1] -= 1;
        }

        for (int i=0; i<reserve.length; i++) {
            arr[reserve[i]-1] += 1;
        }

        for (int i=0; i<n; i++) {
            if (arr[i] == 0 && i > 0 && arr[i-1] > 1) {
                arr[i-1] -= 1;
                arr[i] = 1;
            } else if (arr[i] == 0 && i+1 < n && arr[i+1] >1) {
                arr[i+1] -= 1;
                arr[i] = 1;
            }
        }

        for (int i=0; i<n; i++) {
            if (arr[i] > 0) answer++;
        }

        return answer;
    }
}
