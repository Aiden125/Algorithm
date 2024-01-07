package programmers.kit.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 1. 주어진 숫자 조합 파악
 * 2. 숫자들이 소수인지 판단
 */
public class FindDecimal2 {
    static HashSet<Integer> numbersSet = new HashSet<>();

    public static void main(String[] args) {
//        String a1 = "17";
//        System.out.println(FindDecimal2.solution(a1)); // 3

        String a2 = "011";
        System.out.println(FindDecimal2.solution(a2)); // 2
    }
    public static int solution(String numbers) {
        int answer = 0;

        // 만들 수 있는 조합들 만들기
        dfs("", numbers);

        // 소수 찾기
        for (int target : numbersSet) {
            boolean decimal = true;
            if (target < 2) continue;
            for (int i=2; i<=Math.sqrt(target); i++) {
                if (target%i == 0) {
                    decimal = false;
                    break;
                }
            }
            if (decimal) {
                answer++;
            }
        }

        return answer;
    }
    public static void dfs(String comb, String others) {
        // 1. 현재 조합을 set에 추가
        if (comb.length() > 0) {
            numbersSet.add(Integer.parseInt(comb));
        }

        // 2. 조합 만들기
        for (int i=0; i<others.length(); i++) { // 한글자는 comb에 조합해주고 나머지 글자 합치기
            String newComb = comb + others.charAt(i);
            String newOthers = others.substring(0, i) + others.substring(i+1);
            dfs(newComb, newOthers);
        }
    }
}
