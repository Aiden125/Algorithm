package inflearn;

import java.util.Scanner;

/**
 * 합이 같은 부분 집합
 * https://cote.inflearn.com/contest/10/problem/08-01
 * */
public class I8_1 {
    static int n, total = 0;
    static String answer = "NO";
    boolean flag = false;

    public static void main(String[] args) {
        I8_1 t = new I8_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            total += arr[i];
        }
        t.dfs(0, 0, arr);
        System.out.println(answer);
    }
    public void dfs(int depth, int sum, int[] arr){

        if(flag) return;
        if(sum > total/2) return;
        if(depth == n) {
            if((total-sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }else {
            dfs(depth+1, sum+arr[depth], arr);
            dfs(depth+1, arr[depth], arr);
        }

    }

}
