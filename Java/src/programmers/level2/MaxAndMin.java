package programmers.level2;

// 최댓값과 최솟값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class MaxAndMin {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s)); // expected: 1 4
    }
    public static String solution(String s) {
        String answer = "";
        // 1. 문자열 배열로 분리
        String[] arr = s.split(" ");

        // 2. int value로 변환
        // 3. min, max값 찾기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String a : arr) {
            int target = Integer.parseInt(a);
            if (target > max) max = target;
            if (target < min) min = target;
        }

        answer = min + " " + max;
        return answer;
    }
}
