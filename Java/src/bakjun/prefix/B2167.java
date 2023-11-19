package bakjun.prefix;

import java.util.Scanner;

public class B2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int t = sc.nextInt();
        for (int k=0; k<t; k++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            int sum = 0;
            for (int i=startX; i<=endX; i++) {
                for (int j=startY; j<=endY; j++) {
                    sum += arr[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
