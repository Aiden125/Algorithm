package programmers;

public class L1_Coke {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;
        System.out.println(solution(a, b, n));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a) {
            int current = (n/a) * b; // 이번에 받은 콜라
            n = (n%a) + current; // 바꾸고 남은 여분 콜라 + 받은 콜라 더해주기
            answer += current; // 개수 더해주기
        }
        return answer;
    }
}
