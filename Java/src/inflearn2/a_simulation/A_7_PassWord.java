package inflearn2.a_simulation;

import java.util.*;

public class A_7_PassWord
{
    public int solution(int[] keypad, String password){
        int answer = 0;

        HashMap<Character, int[]> map = new HashMap<>();

        for (int i=0; i<keypad.length; i++) {
            char num = (char) (keypad[i]+'0');
            int x = i / 3;
            int y = i % 3;
            map.put(num, new int[]{x, y});
        }

        int count = 0;
        for (int i=0; i<password.length()-1; i++) {
            if (password.charAt(i) == password.charAt(i+1)) {
                continue;
            }

            int[] left = map.get(password.charAt(i));
            int[] right = map.get(password.charAt(i+1));
            if ( (Math.abs(left[0] - right[0]) > 1) || (Math.abs(left[1] - right[1]) > 1) ) {
                count += 2;
            } else {
                count += 1;
            }
        }
        answer = count;


        return answer;
    }

    public static void main(String[] args){
        A_7_PassWord T = new A_7_PassWord();
 		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218")); // 8
 		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592")); // 12
 		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677")); // 13
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122")); // 8
    }

}