package programmers.kit.hash;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringSortExample {
    public static void main(String[] args) {;
        String[] a = {"c", "1", "10", "01", "11", "100", "3", "15", "30", "1009", "3100", "9999"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        // 01, 1, 10, 100, 1009, 11, 15, 3, 30, 3100, 9999, c

        String[] b = {"0000", "000", "0", "00"};
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        // 0, 00, 000, 0000

        String[] c = {"0", "01", "002", "010", "100"};
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        // 0, 002, 01, 010, 100

        String[] d = {"119", "111", "110", "119112", "120", "121", "12011192223"};
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));
        // 110, 111, 119, 119112, 120, 12011192223, 121

    }
}
