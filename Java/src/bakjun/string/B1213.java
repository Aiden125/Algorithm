package bakjun.string;

import java.util.Scanner;

public class B1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        String centerStr = "";
        boolean failedCheck = false;
        int oddCount = 0;

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c-65]++;
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i]%2 == 1) {
                oddCount++;
                centerStr = ((char)(i+65) + "");
                if (oddCount > 1) {
                    failedCheck = true;
                    System.out.println("I'm Sorry Hansoo");
                    break;
                }
            }
        }

        if (!failedCheck) {
            String answer;
            for (int i=0; i<arr.length; i++) {
                for (int j=0; j<arr[i]/2; j++) {
                    sb.append(((char)(i+65))); // string으로 알아서 변환
                }
            }
            String prefix = sb.toString();
            String suffix = sb.reverse().toString();
            if (!centerStr.isEmpty()) {
                answer = prefix + centerStr + suffix;
            } else {
                answer = prefix + centerStr + suffix;
            }

            System.out.println(answer);
        }

    }
}
