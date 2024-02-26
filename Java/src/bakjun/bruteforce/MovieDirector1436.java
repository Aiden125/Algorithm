package bakjun.bruteforce;

import java.util.Scanner;

public class MovieDirector1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double num = 665;
        int count = 0;
        while(true) {
            if (String.valueOf(++num).contains("666")) {
                if (++count == n) {
                    System.out.println((int)num);
                    break;
                }
            }
        }
    }
}
