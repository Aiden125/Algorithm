package programmers.level1;
/**
 * 문자열 나누기 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 * */
public class L1_0 {
    public static void main(String[] args) {
        Solution_0 st = new Solution_0();
        int test = st.solution("abracadabra");
        System.out.println(test);
    }

}
class Solution_0 {
    static char temp;

    public int solution(String s) {
        int answer = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(count == 0) {
                temp = s.charAt(i);
                count++;
            }else {
                if(s.charAt(i) == temp) count ++;
                else {
                    if(--count == 0) answer++;
                }
            }
        }
        if(count != 0) answer++;
        return answer;
    }
}