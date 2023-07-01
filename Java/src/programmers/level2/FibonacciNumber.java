package programmers.level2;

// 프2 피보나치 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(solution(5)); // exp: 5
    }

    public static int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }
        return arr[n];
    }

}
