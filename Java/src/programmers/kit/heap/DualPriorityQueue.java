package programmers.kit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DualPriorityQueue {
    public static void main(String[] args) {
//        String[] a1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        System.out.println(Arrays.toString(DualPriorityQueue.solution(a1))); // 0,0

        String[] a2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        String[] a2 = {"I -45", "I 653", "I -642", "I 45", "I 97", "I 333"};
        System.out.println(Arrays.toString(DualPriorityQueue.solution(a2))); // 333, -45
    }
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((v1, v2) -> v2-v1); // 큰 값부터 내림차순
        for (String op : operations) {
            int num = Integer.parseInt(op.split(" ")[1]);
            if (op.contains("I")) {
                pq.add(num);
                maxPq.add(num);
            } else if (op.contains("D -") && !pq.isEmpty()) {
                // 큐에서 최소값 삭제
                int min = pq.poll();
                maxPq.remove(min);
            } else if (op.contains("D") && !pq.isEmpty()) {
                // 큐에서 최대값 삭제
                int max = maxPq.poll();
                pq.remove(max);
            }
        }
        if (!pq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}
