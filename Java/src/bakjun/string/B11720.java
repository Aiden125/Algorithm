package bakjun.string;

import java.util.Scanner;

public class B11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        for (char a : s.toCharArray()) {
            int cc = Integer.parseInt(String.valueOf(a));
            count += cc;
        }
        System.out.println(count);
    }
}
