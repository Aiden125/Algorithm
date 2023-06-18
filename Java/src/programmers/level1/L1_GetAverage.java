package programmers.level1;

public class L1_GetAverage {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0.0;

        double tot = 0;
        for(int i=0; i<arr.length; i++) {
            tot += arr[i];
        }
        answer = tot/arr.length;

        return answer;
    }
}
