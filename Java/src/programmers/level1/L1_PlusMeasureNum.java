package programmers.level1;

public class L1_PlusMeasureNum {
    public static void main(String[] args) {

        int left = 13;
        int right = 17;
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for(int targetNum=left; targetNum<=right; targetNum++) {

            int count = 0;
            for(int i=1; i<=Math.sqrt(targetNum); i++) {
                // 제곱근과 같으면 본인 x 본인이기 때문에 하나만 카운트
                if (Math.sqrt(targetNum)==i) {
                    count++;
                } else if (targetNum%i == 0) {
                    count += 2;
                }
            }

            if (count%2 == 0) {
                answer += targetNum;
            } else if (count%2 == 1) {
                answer -= targetNum;
            }

        }

        return answer;
    }

}
