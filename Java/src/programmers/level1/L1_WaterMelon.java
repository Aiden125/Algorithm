package programmers.level1;

public class L1_WaterMelon {
    public static void main(String[] args) {

    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int repeat = n/2;
        for(int i=1; i<=repeat; i++) {
            sb.append("수박");
        }
        if (n%2 == 1) {
            sb.append("수");
        }

        return sb.toString();
    }
}
