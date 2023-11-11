package bakjun.string;

import java.util.ArrayList;
import java.util.Scanner;

public class B2179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> arr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            arr.add(sc.next());
        }

        int answerIndex1 = 0;
        int answerIndex2 = 0;
        int max = 0;
        for (int i=0; i<n-1; i++) {
            String str1 = arr.get(i);
            for (int j=i+1; j<n; j++) {
                String str2 = arr.get(j);
                
                // 문자열 1, 2비교해서 같은 개수를 세주기
                int maxLen = Math.min(str1.length(),str2.length());
                int count = 0;
                for (int k=0; k<maxLen; k++) {
                    boolean diffCheck = str1.charAt(k) == str2.charAt(k);
                    if (!diffCheck) {
                        break;
                    } else {
                        count++;
                        if (max < count) {
                            answerIndex1 = i;
                            answerIndex2 = j;
                            max = count;
                        }
                    }

                }
                
            }
        }
        System.out.println(arr.get(answerIndex1));
        System.out.println(arr.get(answerIndex2));

    }
}
