package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 등수구하기 https://cote.inflearn.com/contest/10/problem/02-08
public class I2_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
            al.add(a, i+1);
        }
        for(int i=0; i<n; i++) {

        }

    }
}
