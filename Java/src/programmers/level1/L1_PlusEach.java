package programmers.level1;

// 자릿수 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class L1_PlusEach {
    public static void main(String[] args) {

        int n = 123;
        System.out.println(solution(n)); // expected : 6
    }

    public static int solution(int n) {
        int answer = 0;

        String a = String.valueOf(n);
        for(int i=0; i<a.length(); i++) {
            answer += Integer.parseInt(String.valueOf(a.charAt(i)));
        }

        return answer;
    }

    public static int solution_2(int n) {
        int answer = 0;

        while (n>=10) {
            int singleDigit = n - ((n/10) * 10);
            answer += singleDigit;
            n = n/10;
        }
        answer += n;

        return answer;
    }
}
