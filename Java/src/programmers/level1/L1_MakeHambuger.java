package programmers.level1;

import java.util.Stack;

public class L1_MakeHambuger {
    public static void main(String[] args) {

        int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient)); // exp = 5
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        // 1 2 3 1이 되어야만 햄버거 완성
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<ingredient.length; i++) {
            sb.append(ingredient[i]);
        }

        String str = sb.toString();
        while(str.contains("1231")) {
            answer += countString(str);
            str = str.replace("1231", "");
        }

        return answer;
    }

    private static int countString(String a) {
        return (a.length() - a.replace("1231", "").length())/4;
    }
}
