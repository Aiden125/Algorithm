package bakjun.z_etc;

import java.util.Scanner;

public class B14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int answer = -1;

        for(int i=target/5; i>=0; i--) {
            int bb = i*5;
            if (bb == target) {
                answer = i;
                break;
            } else {
                if ((target - bb)%2 == 0) {
                    answer = i + (target - bb)/2;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
