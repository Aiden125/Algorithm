package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class QSumBetween2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int q1Sum = 0;
        int q2Sum = 0;
        for(int i : queue1) {
            q1Sum += i;
            q1.add(i);
        }
        for(int i : queue1) {
            q2Sum += i;
            q2.add(i);
        }
        if (q1Sum + q2Sum%2 == 1) return -1;

        while(true) {
            if (q1Sum == q2Sum) return answer;

            if (q1Sum > q2Sum) {
                int q1Poll = q1.poll();
                q1Sum -= q1Poll;
                q2.offer(q1Poll);
            } else {
                int q2Poll = q2.poll();
                q2Sum -= q2Poll;
                q1.offer(q2Poll);
            }

            if (answer > 300000) break;
        }
        return -1;
    }
}
