package bakjun.string;

import java.util.Locale;
import java.util.Scanner;
public class B20437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String w = sc.next(); // super 5, index 4
        int k = sc.nextInt(); // 2

        int firstAnswer = Integer.MAX_VALUE;
        int secondAnswer = -1;
        boolean foundAll = false;

        int slidingSize = 1;
        // 끝까지 슬라이딩 윈도우
        while(slidingSize <= w.length()) {

            // k짜리 슬라이딩 윈도우 1번
            for (int i=0; i<w.length()-slidingSize; i++) { // abaa aba
                int[] arr = new int[26];

                int slidingStart = i;
                int slidingEnd = i+slidingSize-1;
                for (int j=i; j<=slidingEnd; j++) { // abaa, baaa, aaab, aaba
                    arr[w.charAt(j)-97]++;
                    if (arr[w.charAt(j)-97] == k) {
                        firstAnswer = Math.min(firstAnswer, slidingSize);
                        if (w.charAt(slidingStart) == w.charAt(slidingEnd)) {
                            secondAnswer = slidingSize; // 가장긴거라 끝까지 가야함
                        }
                    }
                }
            }

            // 다 찾았거나 끝까지 다 돈 경우
            if (w.length() == slidingSize) {
                System.out.println(firstAnswer + " " + secondAnswer);
                break;
            } else {
                slidingSize++;
            }

        }
    }
}
