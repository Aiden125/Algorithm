package programmers.kit.bruteforce;

import java.util.ArrayList;

/**
 * 최대값을 먼저 만들어서 풀이하면 7자리일경우 시간복잡도가 너무 커짐, 해당 풀이는 x
 */
public class FindDecimal {
    public static void main(String[] args) {
        String a1 = "17";
        System.out.println(FindDecimal.solution(a1));
    }
    public static int solution(String numbers) {
        int answer = 0;

        ArrayList<Integer> givenList = new ArrayList<>();
        ArrayList<Integer> targetList = new ArrayList<>();
        // 만들 수 있는 최대값 찾기
        int maxValue = 0;
        for (char c  : numbers.toCharArray()) {
            int v = Integer.parseInt(String.valueOf(c));
            givenList.add(v);
            maxValue = Math.max(maxValue, v);
        }
        int max = 0;
        for (int i=0; i<numbers.length(); i++) {
            max += (maxValue * Math.pow(10, i)); // 제곱함수
        }
        // 그 안에 소수들 판단
        for (int target=0; target<=Math.sqrt(max); target++) {
            if (target < 2) continue;
            if (target == 2) answer++;

            for (int i=2; i<target; i++) {
                // 소수가 아닌 경우 판별
                if (target%i==0) {
                    break;
                }
            }
            answer++;
        }

        // 주어진 숫자로 만들 수 있는지

        return answer;
    }
}
