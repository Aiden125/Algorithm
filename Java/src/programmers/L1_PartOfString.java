package programmers;

public class L1_PartOfString {
    public static void main(String[] args) {

        String t = "3141592";
        String p = "271";
        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        int lt = 0;
        int rt = p.length()-1; // 2

        while(rt<t.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=lt; i<=rt; i++) {
                sb.append(t.charAt(i));
            }
            long b = Long.parseLong(sb.toString());
            long c = Long.parseLong(p);
            if (b<=c) {
                answer++;
            }
            lt++;
            rt++;
        }
        return answer;
    }
}
