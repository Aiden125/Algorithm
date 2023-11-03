package bakjun.z_etc;

import java.util.Scanner;

// 음계 https://www.acmicpc.net/problem/2920
public class Scale2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "";
        for(int i=0; i<8; i++) {
            a += sc.next();
        }
        if(a.equals("12345678")) {
            System.out.println("ascending");
        } else if (a.equals("87654321")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
