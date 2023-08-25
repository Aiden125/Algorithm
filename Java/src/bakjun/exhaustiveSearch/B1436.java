package bakjun.exhaustiveSearch;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1436
public class B1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        int x = 665;
        int count = 0;
        while(true) {
            x++;
            String validator = String.valueOf(x);
            if (validator.contains("666")) {
                count++;
                if (n==count) {
                    return validator;
                }
            }
        }
    }
}
