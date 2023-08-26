package bakjun.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1436
public class B17484 {
    static int dh[] = {1, 1, 1};
    static int dw[] = {-1, 0, 1};
    static int arr[][];
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int firstIndex = 0;
        for(int i=0; i<m; i++) {
            if (min > arr[i][0]) {
                firstIndex = i;
                min = arr[i][0];
            }
        }
        search(firstIndex, 0);

    }

    public static int search(int h, int w) {
        int cost = arr[h][w];

        while(true) {
            int min = Integer.MAX_VALUE;
            // 가장 작은 값 탐색
            for(int i=0; i<3; i++) {
                int nh = h + dh[i];
                int nw = w + dw[i];
                if (nh<0 || nh > m || nw <0 || nw > n) continue;
                if ()
            }
        }

        int nh = h;

        // 한칸씩 전진

        nh += 1;
    }
}
