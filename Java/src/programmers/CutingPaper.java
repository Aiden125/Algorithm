package programmers;

public class CutingPaper {
    public static void main(String[] args) {
        Solution st = new Solution();
        int answer = st.solution(2, 2);
        System.out.println(answer);
    }

}
class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        return M*N -1;
    }
}
