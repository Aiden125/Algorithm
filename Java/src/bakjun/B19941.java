package bakjun;

import java.util.Scanner;

public class B19941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char aaa = s.charAt(i);
            if (aaa == 'P') {
                int lt = i-k;
                int rt = i+k;
                for(int j=lt; j<=rt; j++){
                    if (j>0 && j<s.length() && s.charAt(j) == 'H') {
                        count++;
                        break;
                    }
                }
            }
        }
    }
}
