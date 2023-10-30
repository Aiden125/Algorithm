package bakjun.implement;

import java.util.Scanner;

public class B10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String[][] arr = new String[x][y];

        // 2차원 배열 입력
        for (int i=0; i<x; i++) {
            String str = sc.next();
            for (int j=0; j<y; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        // 2차원 배열 for문
        for (int i=0; i<x; i++) {
            int dis = -1;
            for (int j=0; j<y; j++) {
                if (dis != -1) {
                    dis++;
                }

                if (arr[i][j].equals("c")) {
                    dis = 0;
                }

                System.out.print(dis + " ");
            }
            System.out.println();
        }
    }
}
