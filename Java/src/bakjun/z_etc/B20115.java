package bakjun.z_etc;

import java.util.Scanner;

public class B20115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            sum += a;
            max = Math.max(a, max);
        }
        double result = ((sum - max)/2) + max;
        System.out.println(result);
    }
}
