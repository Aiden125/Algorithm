package bakjun.z_etc;

import java.util.Scanner;

public class B20365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int bCnt = 0;
        int rCnt = 0;
        char before = 'a';
        for(int i=0; i<n; i++) {
            char cur = s.charAt(i);
            if (cur!=before) {
                if (cur == 'R') bCnt++;
                else rCnt++;
            }

            before = cur;
        }
        System.out.println(Math.min(bCnt, rCnt) + 1);
    }
}
