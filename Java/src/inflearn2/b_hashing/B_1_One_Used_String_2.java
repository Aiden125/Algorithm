package inflearn2.b_hashing;

import java.util.*;
public class B_1_One_Used_String_2 {
    public static void main(String[] args){
        B_1_One_Used_String_2 T = new B_1_One_Used_String_2();
        System.out.println(T.solution("statitsics")); // 3
        System.out.println(T.solution("aabb")); // -1
        System.out.println(T.solution("stringshowtime")); // 3
        System.out.println(T.solution("abcdeabcdfg")); // 5
    }

    public int solution(String s){
        int answer = 0;

        // 사용횟수 표기
        HashMap<Character, Integer> useCount = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            useCount.put(s.charAt(i), useCount.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i=0; i<s.length(); i++) {
            if (useCount.get(s.charAt(i)) == 1) {
                return i+1; // 문제에서 인덱스는 1부터 시작
            }
        }
        return answer;
    }
}



