package bakjun.implement;

import java.util.Scanner;

public class B1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = -1;
        }

        for (int i=0; i<n; i++) {
            int position = sc.nextInt();

            for (int j=0; j<n; j++) {
                if (arr[j] == -1) {
                    if (position == 0) {
                        arr[j] = i+1;
                        break;
                    } else {
                        position--;
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
