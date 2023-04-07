package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class l3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        ArrayList<Integer> bb = new ArrayList<Integer>();
        for(int i=0; i<a; i++) {
            bb.add(sc.nextInt());
        }
    }
}
