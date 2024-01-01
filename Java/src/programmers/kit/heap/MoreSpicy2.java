package programmers.kit.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * priorityQueue로 구현시 자바는 최소힙으로 구현되고,
 * 삽입, 제거 등 시간이 O(nlogn)으로 소요되어서 최악의 경우에도 효율성 테스트 통과 가능
 * 힙트리 형태로 완전이진트리를 유지.
 */
public class MoreSpicy2 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(MoreSpicy2.solution(scoville, K)); // 2

//        int[] scoville2 = {3,5};
//        int K2 = 7;
//        System.out.println(MoreSpicy2.solution(scoville2, K2)); // 1
//
//        int[] scoville3 = {3,5};
//        int K3 = 20;
//        System.out.println(MoreSpicy2.solution(scoville3, K3)); // -1
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 만약 최대힙으로 쓰고 싶다면

        for (int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        // 조건 되면 바로 종료
        if (pq.peek() >= K) {
            return answer;
        }

        while(pq.size() >= 2) {
            answer++;

            int firstMin = pq.poll();
            int secondMin = pq.poll();
            int c = firstMin + secondMin*2;
            pq.offer(c);

            int check = pq.peek(); // 우선순위 큐이기 때문에 항상 작은값이 위에존재
            if (check >= K) {
                return answer;
            }

        }

        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
