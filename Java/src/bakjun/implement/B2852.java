package bakjun.implement;

import java.util.Scanner;

public class B2852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int aScore = 0;
        int bScore = 0;
        int aTime = 0;
        int bTime = 0;
        int preTime = 0;
        for (int i=0; i<t+1; i++) {
            int team = 0;
            String time = "";
            if (i==t) {
                team = -999;
                time = "48:00";
            } else {
                team = sc.nextInt();
                time = sc.next();
            }

            int timeA = Integer.parseInt(time.substring(0, time.indexOf(":")));
            int timeB = Integer.parseInt(time.substring(time.indexOf(":")+1));
            int currentTime = (timeA * 60) + timeB;
            if (aScore > bScore) {
                aTime += currentTime - preTime;
            } else if (bScore > aScore) {
                bTime += currentTime - preTime;
            }

            preTime = (timeA * 60) + timeB;

            if (team == 1) {
                aScore++;
            } else {
                bScore++;
            }
        }

        System.out.printf("%02d:%02d\n", aTime/60, aTime%60);
        System.out.printf("%02d:%02d", bTime/60, bTime%60);
    }
}
