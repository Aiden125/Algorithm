package programmers.level1;

public class L1_MiddleWord {
    public static void main(String[] args) {

//        String s = "abcde";
//        System.out.println(solution(s));

        String s = "a";
        System.out.println(solution(s));// expected: "a"
    }

    public static String solution(String s) {
        String answer = "";

        // 3보다 길이가 짧은 경우 뒤에 로직이 불편해져서 따로 예외처리
        if (s.length() < 3) {
            return s;
        }
        int middleIndex = (s.length()-1)/2;
        // 짝수
        if (s.length()%2==0) {
            answer = s.substring(middleIndex, middleIndex+2);
        }
        // 홀수
        else {
            answer = s.substring(middleIndex, middleIndex+1);
        }
        return answer;
    }
}
