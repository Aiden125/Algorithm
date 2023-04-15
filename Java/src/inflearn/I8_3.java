package inflearn;

import java.util.Scanner;

public class I8_3 {
    static int n, m; // 제한시간, 문제
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] times = new int[n];
        int[] scores = new int[n];
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }
        dfs(0, 0, 0, times, scores);
        System.out.println(answer);
    }

    static void dfs(int depth, int scoreSum, int timeSum, int[] times, int[] scores) {
        if(timeSum <= m) {
            if(scoreSum > answer) answer = scoreSum;
        }
        if(depth == n) return;

        dfs(depth+1, scoreSum+scores[depth], timeSum+times[depth], times, scores); // 푸는 가지
        dfs(depth+1, scoreSum, timeSum, times, scores); // 안푸는 가지
    }
}
