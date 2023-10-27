package bakjun.string;

import java.util.Scanner;

public class B1522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int aCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }
        s = s+s; // 원형처럼 만들어주려고
        // aabaa
        // acount = 4, s.length = 5
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<s.length()-aCount; i++) {
            int bCount = 0;
            for(int j=i; j<i+aCount; j++) {
                if (s.charAt(j) == 'b') {
                    bCount++;
                }
            }
            minValue = Math.min(minValue, bCount);
        }

        System.out.println(minValue);
    }
}
