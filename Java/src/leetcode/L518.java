package leetcode;

import java.util.Arrays;
import java.util.Scanner;
/**
 * the hint : https://velog.io/@kai6666/%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-518.-Coin-Change-2-%EC%9E%90%EB%B0%94-%ED%92%80%EC%9D%B4
dp=[0]*(amount+1)
        dp[0] = 1
        for coin in coins:
        for i in range(1, amount+1):
        if i - coin >=0:
        dp[i] += dp[i-coin]
        return dp[-1]
 */
public class L518 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//    }
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int c : coins) {
            for(int j=c; j<=amount; j++) {
                arr[j] += arr[j-c];
            }
        }
        return arr[amount];
    }
}
