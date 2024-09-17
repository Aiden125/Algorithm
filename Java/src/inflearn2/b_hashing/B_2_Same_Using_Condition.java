package inflearn2.b_hashing;

import java.util.*;
public class B_2_Same_Using_Condition {
    public int[] solution(String s){
        int[] answer = new int[5];

        int[] useCountArray = new int[5];

        int max = -1;
        // 배열 만들고 맥스값 표기
        for (int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - 97;
            useCountArray[index]++;
            max = Math.max(max, useCountArray[index]);
        }

        // 정답 배열 채워주기
        for (int i=0; i<answer.length; i++) {
            answer[i] = max - useCountArray[i];
        }

        return answer;
    }

    public static void main(String[] args){
        B_2_Same_Using_Condition T = new B_2_Same_Using_Condition();
        System.out.println(Arrays.toString(T.solution("aaabc"))); // [0,2,2,3,3]
        System.out.println(Arrays.toString(T.solution("aabb"))); // [0,0,2,2,2]
        System.out.println(Arrays.toString(T.solution("abcde"))); // [0,0,0,0,0]
        System.out.println(Arrays.toString(T.solution("abcdeabc"))); // [0,0,0,1,1]
        System.out.println(Arrays.toString(T.solution("abbccddee"))); // [1,0,0,0,0]
    }
}
