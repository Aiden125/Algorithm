package bakjun.bruteforce;

import java.util.Scanner;

public class bundaegi15721 {
    public static void main(String[] args) {
        String[] arr = {"번", "데기", "번", "데기", "번", "데기"};
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int t = sc.nextInt();
        int daegi = sc.nextInt(); // 데기면 1, 번이면 0


        int n = 1;
        int bunCount = 0;
        int daeCount = 0;
        int totalCount = 0;
        boolean found = false;
        while(!found) {
            for (int i=0; i<arr.length; i++) {
                if (i==0 || i==2) {
                    bunCount++;
                    totalCount++;
                } else if (i==1 || i==3) {
                    daeCount++;
                    totalCount++;
                }
                if (i==4) {
                    for (int j=0; j<n+1; j++) {
                        bunCount++;
                        totalCount++;
                        if ((daegi == 0 && bunCount == t)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (i==5) {
                    for (int j=0; j<n+1; j++) {
                        daeCount++;
                        totalCount++;
                        if ((daegi == 1 && daeCount == t)) {
                            found = true;
                            break;
                        }
                    }
                }
                if ((daegi == 0 && bunCount == t) || (daegi == 1 && daeCount == t)) {
                    found = true;
                    break;
                }
            }
            n++;
        }
        System.out.println((totalCount-1)%a);

    }
}
