package bakjun.string;

import java.util.Scanner;

public class B1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String targetStr = sc.next();
        int pointer = 0;
        long i = 0;
        final int pointerMax = targetStr.length();

        while(pointer != pointerMax) {
            i++;
            String numberStr = String.valueOf(i);

            for (char c : numberStr.toCharArray()) {
                if (c == targetStr.charAt(pointer)) {
                    pointer++;
                    if (pointer == pointerMax) break;
                }
            }
        }

        System.out.println(i);
    }
}
