package programmers.level1;

public class L1_PAndYNum {
    public static void main(String[] args) {

        String s = "pPoooyY";
        System.out.println(solution(s)); // expected: true
    }
    public static boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();

        int pNum = s.length() - s.replace("p", "").length();
        int yNum = s.length() - s.replace("y", "").length();
        if (pNum != yNum) {
            return false;
        }
        return answer;
    }
}
