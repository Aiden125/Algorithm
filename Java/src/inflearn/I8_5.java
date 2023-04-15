package inflearn;
// 동전 교환 https://cote.inflearn.com/contest/10/problem/08-05
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class I8_5 {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int targetSum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Integer[] coins = new Integer[n];
        for(int i=0; i<n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        targetSum = sc.nextInt();

        dfs(0, 0, coins);
        System.out.println(answer);

    }

    /** 코인을 1개, 2개 포함시키는 경우를 dfs로 구함 */
    static void dfs(int coinCount, int sum, Integer[] coins) {
        if(sum > targetSum || coinCount > answer) return;

        if(sum == targetSum) {
            answer = Math.min(answer, coinCount);
        } else {
            for(int i=0; i<n; i++) {
                dfs(coinCount+1, sum+coins[i], coins);
            }
        }
    }

}
