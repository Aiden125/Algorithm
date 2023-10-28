package bakjun.string;

import java.util.Scanner;

public class B4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) {
            // 단어별로 입력 받기
            String s = sc.next();
            if (s.equals("end")) break;

            int aCheck = 0; // 모음 한번이상 체크
            int bCheck = 0; // 모음 연속 체크
            int dCheck = 0; // 자음 연속 체크
            int sameWordCount = 0;
            char prefix = '-';
            boolean falseCheck = false;

            // 입력받은 한 단어에 대한 처리
            for (char c : s.toCharArray()) {
                // 모음 체크
                if (c == 'a' || c == 'e' || c == 'i' ||
                        c == 'o' || c == 'u') {
                    aCheck++;

                    bCheck++;
                    dCheck = 0;
                } else {
                    dCheck++;
                    bCheck = 0;
                }

                if (bCheck >= 3 || dCheck >= 3) {
                    falseCheck = true;
                    break;
                }

                // 같은 글자 체크
                if (c == prefix) {
                    sameWordCount++;
                    if (c != 'e' && c != 'o' && sameWordCount == 1) {
                        falseCheck = true;
                        break;
                    }
                } else {
                    sameWordCount = 0;
                }

                prefix = c;
            }

            if (!falseCheck && aCheck > 0) {
                System.out.println("<"+s+"> is acceptable.");
            } else {
                System.out.println("<"+s+"> is not acceptable.");
            }
        }
    }
}
