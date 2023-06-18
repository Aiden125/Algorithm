package programmers.level1;

public class L1_Divisor {
    public static void main(String[] args) {

//        int n = 16;
//        System.out.println(solution(n)); // expected: 31
        int n2 = 0;
        System.out.println(solution(n2)); // expected: 0
    }
    public static int solution(int n) {
        int answer = 0;

        for(int i=1; i<=Math.sqrt(n); i++) {
            if (n%i==0) {
                int b = n/i;
                // 약수가 서로 같은 경우 두번 연산 안하기 위해
                if (b == i) {
                    answer += i;
                } else {
                    answer += i + b;
                }
            }
        }
        return answer;
    }
}
