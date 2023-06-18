package programmers.level1;

public class L1_EvenOdd {

    public String solution(int num) {
        String answer = "";

        if (num%2 ==0) {
            answer = "Even";
        } else {
            return "Odd";
        }
        return answer;
    }
}
