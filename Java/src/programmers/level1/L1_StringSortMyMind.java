package programmers.level1;

import java.util.Arrays;

public class L1_StringSortMyMind {
    public static void main(String[] args) {

    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        char[] a = new char[strings.length];
        for(int i=0 ;i<strings.length; i++) {
            a[i] = strings[i].charAt(n);
        }

        Arrays.sort(a);
        for(int i=0; i<strings.length; i++) {
        }
        return answer;
    }
}
