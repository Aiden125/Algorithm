package bakjun.z_etc;

import java.util.Arrays;
import java.util.Scanner;

public class B20300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        long max = Integer.MIN_VALUE;
        int lt = 0;
        int rt = arr.length-1;
        long last = arr[arr.length-1];
        if (arr.length%2 == 1) {
            rt = arr.length-2;
        }
        while(lt < rt) {
            long a = arr[lt] + arr[rt];
            if (a > max) max = a;
            lt++; rt--;
        }
        if (last > max) max = last;
        System.out.println(max);
    }
}
