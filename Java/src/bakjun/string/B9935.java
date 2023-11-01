package bakjun.string;

import java.util.Scanner;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String given = sc.next();
        String delimiter = sc.next();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < given.length(); i++) {
            st.push(given.charAt(i));

            if (st.size() >= delimiter.length()) {
                boolean isSame = true;
                for (int j = 0; j < delimiter.length(); j++) {
                    if (st.get(st.size() - delimiter.length() + j) != delimiter.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < delimiter.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        if (sb.toString().length() < 1) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }

    }

}
