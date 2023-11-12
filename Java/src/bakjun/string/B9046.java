package bakjun.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int[] arr = new int[26];
            String s = br.readLine().replaceAll(" ", "");
            int max = -1;
            for (char c : s.toCharArray()) {
                int idx = c - 97;
                arr[idx]++;
                if (arr[idx] > max) {
                    max = arr[idx];
                }
            }

            int maxValueCount = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[j] == max) {
                    maxValueCount++;
                }
            }

            if (maxValueCount > 1) {
                System.out.println("?");
            } else {
                System.out.println((char) (arr[max]+97));
            }
        }
    }
}
