package programmers.kit.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice3 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(StockPrice3.solution(prices))); // 4,3,1,1,0
    }

    public static int[] solution(int[] prices) {
        Stack<Integer> beginIdxsStack = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxsStack.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxsStack.empty() && prices[i] < prices[beginIdxsStack.peek()]) {
                int beginIdx = beginIdxsStack.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxsStack.push(i);
        }
        while (!beginIdxsStack.empty()) {
            int beginIdx = beginIdxsStack.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}
