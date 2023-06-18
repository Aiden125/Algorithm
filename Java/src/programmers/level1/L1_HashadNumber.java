package programmers.level1;

public class L1_HashadNumber {
    public static void main(String[] args) {

        int x = 10;
        System.out.println(solution(x)); // expected: true
    }

    public static boolean solution(int x) {
        boolean answer = true;

        String[] arr = String.valueOf(x).split("");

        int dd = 0;
        for(int i=0; i<arr.length; i++) {
            dd += Integer.parseInt(arr[i]);
        }

        if (x%dd!=0) {
            return false;
        }
        return answer;
    }
}
