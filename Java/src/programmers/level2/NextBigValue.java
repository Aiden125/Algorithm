package programmers.level2;

public class NextBigValue {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        String a = Integer.toBinaryString(n);
        int aOneTotalNum = a.length() - a.replace("1", "").length();
        while(true) {
            n++;
            String b = Integer.toBinaryString(n);
            int bOneTotalNum = b.length() - b.replace("1", "").length();
            if (aOneTotalNum == bOneTotalNum) return n;
        }
    }
}
