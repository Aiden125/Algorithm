package bakjun.implement;

import java.util.Scanner;

public class B8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[N][4];
        int aValue = 0;
        int bValue = 0;
        int cValue = 0;
        for (int i = 0; i < N; i++) {
            int countryCode = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[i][0] = countryCode;
            arr[i][1] = a;
            arr[i][2] = b;
            arr[i][3] = c;

            if (countryCode == k) {
                aValue = a;
                bValue = b;
                cValue = c;
            }
        }

        int moreBig = 0;
        // 본인보다 큰 애들 있으면 체크해주기
        for (int i = 0; i < N; i++) {
            if (arr[i][1] > aValue ||
                    arr[i][1] == aValue && arr[i][2] > bValue ||
                    arr[i][1] == aValue && arr[i][2] == bValue && arr[i][3] > cValue) {
                moreBig++;
            }
        }

        System.out.println(moreBig + 1); // 본인 등수 포함
    }
}
