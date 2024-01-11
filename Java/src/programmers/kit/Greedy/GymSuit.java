package programmers.kit.Greedy;

import java.util.ArrayList;

public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(GymSuit.solution(n, lost, reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        ArrayList<Integer> reserveList = new ArrayList<>();
        for (int i=0; i<reserve.length; i++) {
            boolean check = false;
            for (int j=0; j<lost.length; j++) {
                if (lost[i] == reserve[j]) {
                    check = true;
                }
            }
            if (!check) {
                reserveList.add(reserve[0]);
            }
        }
        for (int i=0; i<lost.length; i++) {

        }

        return answer;
    }
}
