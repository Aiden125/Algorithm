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
            for (int j=0; j<s.length(); j++) {
                int charValue = s.charAt(j) - 97;
                arr[charValue]++;
                if (arr[charValue] > max) {
                    max = j;
                }
            }

            int maxValueCount = 0;
            int finalIndex = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[j] == max) {
                    maxValueCount++;
                    finalIndex = j;
                }
            }

            if (maxValueCount > 1) {
                System.out.println("?");
            } else {
                System.out.println((char) (arr[finalIndex]+97));
            }
        }
    }
}
