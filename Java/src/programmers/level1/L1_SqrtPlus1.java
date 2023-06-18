package programmers.level1;

public class L1_SqrtPlus1 {
    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n)); // expected: 144
    }

    public static  long solution(long n) {
        long answer = 0;

        double a = Math.sqrt(n);
        double b = Math.floor(a);
        if (a==b) {
            long c = (long) a+1;
            answer = (long) (c * c);
        } else {
            answer = -1;
        }

        return answer;
    }
}
