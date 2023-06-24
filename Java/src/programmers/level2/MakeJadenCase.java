package programmers.level2;
// JadenCase 문자열 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class MakeJadenCase {
    public static void main(String[] args) {

        String s = "   3people unFollowed   me    ";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        s = s.toLowerCase();

        if (!s.contains(" ")) {
            String first = s.substring(0, 1).toUpperCase();

            String other = s.substring(1);

            answer += first + other;
            return answer;
        }
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            String a = arr[i];
            if (a.length() < 1) {
                answer += " ";
                continue;
            }
            String first = a.substring(0, 1).toUpperCase();
            String other = a.substring(1);
            answer += first + other;
            if (i!=arr.length-1) {
                answer += " ";
            }
        }

        while(answer.length() != s.length()) {
            answer += " ";
        }
        return answer;
    }
}
