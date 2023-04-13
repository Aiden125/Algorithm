package inflearn;

import java.util.Scanner;

public class I8_2 {
    static int c, n;
    static int max = -999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
           arr[i] = sc.nextInt();
        }
        dfs(0, 0, arr);
        System.out.println(max);
    }

    // 81 58 42 33 61
    static void dfs(int depth, int targetSum, int[] arr){
        if(targetSum > c) return;
        if(targetSum > max) max = targetSum;
        if(depth == n) {
            return;
        }else{
            dfs(depth+1, targetSum+arr[depth], arr); // 다 더하는쪽
            dfs(depth+1, targetSum, arr); // 다 안 더하는 쪽
        }
    }
}
