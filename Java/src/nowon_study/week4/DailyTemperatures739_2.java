package nowon_study.week4;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739_2 {
    public static void main(String[] args) {
        int[] a = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(DailyTemperatures739_2.dailyTemperatures(a))); // 1,1,4,2,1,1,0,0

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<int[]> st = new Stack<>(); // 숫자, 인덱스
        for (int i=0; i<temperatures.length; i++) {
            while (!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                int[] current = st.pop();
                answer[current[1]] = i - current[1];
            }
            st.push(new int[]{temperatures[i], i});
        }

        return answer;
    }
}
