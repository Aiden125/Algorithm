package programmers.kit.hash;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringSortExample {
    public static void main(String[] args) {;
        String[] s = {"c", "1", "10", "11", "100", "3", "15", "30", "1009", "3100", "9999"};
        Arrays.sort(s);
        System.out.println(Arrays.toString(s)); // 1, 10, 100, 1009, 11, 15, 3, 30, 3100, 9999, c

        String[] a = {"119", "111", "110", "119112", "120", "121", "12011192223"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); // 110, 111, 119, 119112, 120, 12011192223, 121

    }
}
