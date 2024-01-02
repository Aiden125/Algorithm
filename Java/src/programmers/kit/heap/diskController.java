package programmers.kit.heap;

import java.util.PriorityQueue;

public class diskController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(diskController.solution(jobs)); // 9
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        pq.offer(jobs[0][1]);
        int times = 0;
        int index= 1;
        while(!pq.isEmpty()) {
            int currentTask = pq.poll();
            times += currentTask;
            for (int i=0; i<jobs.length; i++) {
                if (i < index) {
                    continue;
                }
                if (jobs[i][1] <= times) {
                    pq.offer(jobs[i][1]);
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}

