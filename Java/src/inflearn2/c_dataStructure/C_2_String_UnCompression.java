package inflearn2.c_dataStructure;

import java.util.*;

public class C_2_String_UnCompression {
    public String solution(String s) {
        String answer = "";
        Stack<Character> st = new Stack<>();

        for (Character a : s.toCharArray()) {
            if (a == ')') {
                StringBuilder reverse = new StringBuilder();
                while (st.peek() != '(') {
                    reverse.append(st.pop());
                }
                st.pop(); // '(' pop해주기
                reverse.reverse(); // 원래대로 만들어주기

                String num = "";
                int count = 1;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num = st.pop() + num;
                }
                if (!num.equals("")) {
                    count = Integer.parseInt(num);
                }
                while (--count >= 0) {
                    for (Character bb : reverse.toString().toCharArray()) {
                        st.push(bb);
                    }
                }

            } else {
                st.add(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        answer = sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        C_2_String_UnCompression T = new C_2_String_UnCompression();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
        System.out.println(T.solution("10(ab)"));
        /**
         * abbabbabbef
         * ababkbcbcbc
         * abcdcdcd abcdcdcd
         * ababacacacacacacababacacacacacac
         * absgsgabsgsgabsgsg
         * abababababababababab
         */
    }
}
