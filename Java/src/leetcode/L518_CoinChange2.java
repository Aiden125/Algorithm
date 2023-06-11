package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class L518_CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(changeOtherWay(amount, coins));;
    }

    public static int change(int amount, int[] coins) {
        int[][] arr = new int[coins.length][amount+1]; // 0 1 2 3 4 5

        for(int i=0; i<coins.length; i++) {
            arr[i][0] = 1;
        }

        for(int i=0; i<coins.length; i++) {
            for(int j=0; j<=amount; j++) {
                int coinValue = coins[i];
                if(i==0) {
                    if (j%coinValue==0) {
                        arr[i][j] = 1;
                    }
                } else if (j/coinValue < 1){
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-coinValue];
                }
            }
        }

        return arr[coins.length-1][amount];
    }

    public static int changeOtherWay(int amount, int[] coins) {
        int[] arr = new int[amount+1]; // 0 1 2 3 4 5

        arr[0] = 1;
        for(int coinValue : coins) {
            for(int i=coinValue; i<=amount; i++) {
                arr[i] = arr[i] + arr[i-coinValue];
            }
        }
        return arr[amount];
    }
}
