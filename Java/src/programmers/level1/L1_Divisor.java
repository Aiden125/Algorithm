package programmers.level1;

// 프1 - 약수의 합
// https://school.programmers.co.kr/learn/courses/30/lessons/12928
public class L1_Divisor {
    public static void main(String[] args) {

        int n = 16;
        System.out.println(solution(n)); // expected: 31

    }
    public static int solution(int n) {
        int answer = 0;
        // 특정숫자 = 작은파트너 * 큰파트너
        // 작은파트너가 큰파트너를 넘어가는 시점은 계산할 필요x
        for(int smallNum=1; smallNum<=Math.sqrt(n); smallNum++) {
            if (n%smallNum==0) { // 약수인지 확인
                int bigNum = n/smallNum;
                if (bigNum == smallNum) {
                    answer += smallNum;
                } else {
                    answer += smallNum + bigNum;
                }
            }
        }
        return answer;
    }
}
