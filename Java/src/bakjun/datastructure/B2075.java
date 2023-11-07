package bakjun.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n*n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[(i*n)+j] = sc.nextInt();
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[arr.length-n]);
    }
}
