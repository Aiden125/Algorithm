package programmers.level1;

public class L1_Babbling2 {
    public static void main(String[] args) {

        String[] babb = {"aya", "yee", "u", "maa"};
        System.out.println(solution(babb));

        String[] babb2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babb2));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String a = "aya";
        String b = "ye";
        String c = "woo";
        String d = "ma";

        for(String bb : babbling){
            if (bb.contains(a+a) || bb.contains(b+b) ||
            bb.contains(c+c) || bb.contains(d+d)) {
                continue;
            }
            bb = bb.replace(a, "1");
            bb = bb.replace(b, "1");
            bb = bb.replace(c, "1");
            bb = bb.replace(d, "1");
            bb = bb.replace("1", "");
            if (bb.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
