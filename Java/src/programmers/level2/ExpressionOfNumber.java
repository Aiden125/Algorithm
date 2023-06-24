package programmers.level2;

public class ExpressionOfNumber {
    public static void main(String[] args) {

        int n = 15;
        System.out.println(solution(n)); // expected: 4
    }

    public static int solution(int n) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int total = 0;
        while(right <= n) {
            if (total==n) {
                answer++;
                right++;
                total += right;
            } else if (total < n) {
                right++;
                total += right;
            } else {
                total -= left;
                left++;
            }
        }
        return answer;
    }
}
