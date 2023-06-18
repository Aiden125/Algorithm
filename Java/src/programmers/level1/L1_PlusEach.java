package programmers.level1;

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
}
