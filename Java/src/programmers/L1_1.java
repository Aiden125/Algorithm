package programmers;

public class L1_1 {
    public static void main(String[] args) {
        Solution1_1 st = new Solution1_1();
        System.out.println(st.solution("banana"));
    }
}
class Solution1_1 {
    public int[] solution(String s) {
        int[] answer = {};

        int[] b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        for(int i=0; i<s.length(); i++) {
            int cc = s.charAt(i)-97;
            if(b[cc] == -1) {
                b[cc] = i+1;
            }
            answer[i] = b[cc];
        }
        return answer;
    }
}
