package programmers.level1;

import java.util.HashMap;

public class L1_CharacterTest {


    public static void main(String[] args) {
//        String[] a= {"AN", "CF", "MJ", "RT", "NA"};
//        int[] b= {5, 3, 2, 7, 5};
//        System.out.println(solution(a, b)); // TCMA

        String[] a= {"AN", "CF", "MJ", "RT", "NA"};
        int[] b= {4, 4, 4, 4, 4};
        System.out.println(solution(a, b)); // RCJA
    }

    static final char R = 'R';
    static final char T = 'T';
    static final char C = 'C';
    static final char F = 'F';
    static final char J = 'J';
    static final char M = 'M';
    static final char A = 'A';
    static final char N = 'N';
    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);

            int choice = choices[i];

            int value = choice-4;
            if(value < 0) { // 앞에꺼에 동의
                map.put(a, map.getOrDefault(a, 0) + Math.abs(value));
            }else if (value > 0) { // 뒤에꺼에 동의
                map.put(b, map.getOrDefault(b, 0) + value);
            }
        }

        int rr = map.getOrDefault(R, 0);
        int tt = map.getOrDefault(T, 0);
        int cc = map.getOrDefault(C, 0);
        int ff = map.getOrDefault(F, 0);
        int jj = map.getOrDefault(J, 0);
        int mm = map.getOrDefault(M, 0);
        int aa = map.getOrDefault(A, 0);
        int nn = map.getOrDefault(N, 0);

        // 사전 우선순위를 먼저 넣기
        if (rr >= tt) {
            answer += R;
        }else {
            answer += T;
        }

        if (cc >= ff) {
            answer += C;
        } else {
            answer += F;
        }

        if (jj >= mm) {
            answer += J;
        } else {
            answer += M;
        }

        if (aa >= nn) {
            answer += A;
        } else {
            answer += N;
        }
        return answer;
    }

}
