package bakjun;

import java.util.Scanner;

public class B19941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        char[] abc = new char[n];
        for(int i=0; i<n; i++) {
            abc[i] = s.charAt(i);
        }

        int count = 0;
        for(int i=0; i<abc.length; i++) {
            char aaa = abc[i];
            if (aaa == 'P') {
                int lt = i-k;
                int rt = i+k;
                for(int j=lt; j<=rt; j++){
                    if (j>=0 && j<abc.length && abc[j] == 'H') {
                        count++;
                        abc[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
