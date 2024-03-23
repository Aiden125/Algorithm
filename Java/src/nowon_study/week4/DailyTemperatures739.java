package nowon_study.week4;

import java.util.Arrays;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] a = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(DailyTemperatures739.dailyTemperatures(a))); // 1,1,4,2,1,1,0,0

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            int day = 0;
            for (int j=i+1; j<temperatures.length; j++) {
                int left = temperatures[i];
                int right = temperatures[j];
                if (left < right) {
                    day = j - i;
                    break;
                }
            }
            answer[i] = day;
        }

        return answer;
    }
}
