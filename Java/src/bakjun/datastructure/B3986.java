package bakjun.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int i=0; i<n; i++) {
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            for (char c : s.toCharArray()) {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    char current = st.peek();
                    if (current == c) {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                }
            }
            if (st.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
