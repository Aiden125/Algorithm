package bakjun;

import java.util.Scanner;

public class B20365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        for(char a : s.toCharArray()) {
            if(a == 'B') {
                count ++;
            } else {
                count --;
            }
        }

        int colorCount = 0;
        boolean sw = false;
        if(count > 0) { // B가 많은 경우
           for(int i=0; i<s.length(); i++) {
               if (sw && s.charAt(i)=='B') {
                   sw = false;
                   colorCount++;
               }
               if (s.charAt(i) == 'R') {
                   sw = true;
                   if(i==s.length()-1) colorCount++;
               }
           }
        } else {
            for(int i=0; i<s.length(); i++) {
                if (sw && s.charAt(i)=='R') {
                    sw = false;
                    colorCount++;
                }
                if (s.charAt(i) == 'B') {
                    sw = true;
                    if(i==s.length()-1) colorCount++;
                }
            }
        }

        System.out.println(++colorCount);
    }
}
