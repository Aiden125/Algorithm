package bakjun;

import java.util.Scanner;

public class B1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            int a = Integer.parseInt(String.valueOf(s.charAt(i)));

            String answerStr = String.valueOf(answer);
            for(int j=0; j<answerStr.length(); j++) {
                if (s.charAt(i) == answerStr.charAt(j)) {
                    if (++i>=s.length()) {
                        System.out.println();
                        break;
                    }
                }
            }
            answer++;

        }

    }
}
