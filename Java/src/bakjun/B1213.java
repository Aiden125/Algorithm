package bakjun;

import java.util.Scanner;

public class B1213 {
    public static void main(String[] args) {
        String answer = "";
        int[] a = new int[26];
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        // 배열에 카운트 담기
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            a[cc-97] = a[cc-97]+1;
        }

        // 카운트를 기준으로 홀 수가 두개 이상인 경우 분류
        int evenCheck = 0; // evenCheck = 0일 경우 짝만, 1일 경우 홀 1개 2이상일 경우 불가
        for(int i=0; i<a.length; i++) {
            int ccc = a[0];
            if (ccc%2 != 0) evenCheck++;
        }

        if (evenCheck >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            int oddNumIndex = -999;
            for(int i=0; i<a.length; i++) {
                if(a[i]%2 == 1){
                    oddNumIndex = i;
                } else if (a[i]>0 && a[i]%2 == 0){
                    char oddChar = (char) (i+97-'0');
                    for(int j=0; j<a[i]/2; j++) {
                        answer += oddChar;
                    }
                }
            }

            StringBuffer sb = new StringBuffer(answer);
            String answerReverse = sb.reverse().toString();

            if (oddNumIndex == -999) {
                answer = answer + answerReverse;
            } else {
                answer = answer + (a[oddNumIndex]-'0') + answerReverse;
            }


        }
    }
}
