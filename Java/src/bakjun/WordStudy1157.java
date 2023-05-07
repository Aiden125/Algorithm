package bakjun;

import java.util.Scanner;

// 백준 "단어 공부" 문제
public class WordStudy1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        a = a.toUpperCase();
        int[] b = new int[26];
        // 65 == A
        for(char ee : a.toCharArray()) {
            int check = ee-65;
            b[check] += 1;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<b.length; i++) {
            if(max < b[i]) {
                max = b[i];
                index = i;
            }
        }

        int count = 0;
        for(int i=0; i<b.length; i++) {
            if (b[i] == max) count++;
        }


        if(count > 1) {
            System.out.println("?");
        }else {
            // 명시적 형변환을 사용하면됨 복잡하게 생각하지 않아도 됨
            char xx = (char)(index+65);
            System.out.println(xx);
        }
    }
}
