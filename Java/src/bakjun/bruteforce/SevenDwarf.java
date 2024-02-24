package bakjun.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SevenDwarf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int totalHeight = 0;
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
            totalHeight += arr[i];
        }

        boolean stop = false;
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (i==j) continue;
                if (totalHeight - arr[i] - arr[j] == 100 && !stop) {
                    arr[i] = 999;
                    arr[j] = 999;
                    stop = true;
                }
            }
        }

        Arrays.sort(arr);
        for (int i=0; i<7; i++) {
            System.out.println(arr[i]);
        }

    }
}
