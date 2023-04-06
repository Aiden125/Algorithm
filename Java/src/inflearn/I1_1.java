package inflearn;

import java.util.Scanner;

public class I1_1 {
    public int sol(String s, char c) {
        int count = 0;
        for(char a : s.toCharArray()) {
            if(a == c) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();
        Character s3 = s2.charAt(0);

        I1_1 tt = new I1_1();
        System.out.println(tt.sol(s, s3));

    }
}
