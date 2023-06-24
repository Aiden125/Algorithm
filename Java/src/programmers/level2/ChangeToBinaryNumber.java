package programmers.level2;

import java.util.Arrays;
// 프2 이진변환 반복하기
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class ChangeToBinaryNumber {
    public static void main(String[] args) {

        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s))); // expected: 3,8
    }

    public static int[] solution(String s) {
        int[] answer = {};

        int zeroNum = 0;
        int count = 0;

        while(!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();
            zeroNum += before - after;
            count++;

            s = Integer.toBinaryString(s.length());
        }

        answer = new int[] {count, zeroNum};
        return answer;
    }
}
