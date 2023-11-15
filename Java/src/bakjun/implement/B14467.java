package bakjun.implement;

import java.util.Scanner;

public class B14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for (int i=0; i<n+1; i++) {
            arr[i] = -1;
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            int cawNum = sc.nextInt();
            int location = sc.nextInt();

            int preLocation = arr[cawNum];
            if (preLocation != -1 && location != preLocation) {
                answer++;
            }
            arr[cawNum] = location;
        }
        System.out.println(answer);
    }
}
