package programmers.kit.Greedy;

public class JoyStick {
    public static void main(String[] args) {

        String a1 = "JAN";
        System.out.println(JoyStick.solution(a1)); // 23

        String a2 = "AAA";
        System.out.println(JoyStick.solution(a2));

        String a3 = "JEROEN";
        System.out.println(JoyStick.solution(a3)); // 56
    }
    public static int solution(String name) {
        int answer = 0;

        int pointer = 0;
        int count = 0;
        while(pointer < name.length()) {
            // BAAE
            char word = name.charAt(pointer);
            if (word == 'A') {
                count++;
                pointer++;
                continue;
            }
            if (count > 0) {
                // JEROEN
                int back = Math.abs((name.length()-1)-pointer)+1;
                answer += Math.min(count, back);
                count = 0;
            }
            int a1 = Math.abs('A' - word);
            int a2 = Math.abs('A' - word) + 1;
            int a3 = Math.abs('Z' - word) + 1;
            answer += Math.min(a1, Math.min(a2, a3));

            pointer++;
        }
        return answer;
    }
}
