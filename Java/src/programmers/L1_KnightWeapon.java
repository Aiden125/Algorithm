package programmers;

public class L1_KnightWeapon { // O(루트n)
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            double numberValue = i;
            int count = 0;

            for(int j=1; j*j<=numberValue; j++) {
                if (j*j == numberValue) {
                    count++;
                } else if (numberValue%j == 0) {
                    count += 2;
                }
            }

            if (count > limit) {
                count = power;
            }
            answer += count;
        }
        return answer;
    }
}
