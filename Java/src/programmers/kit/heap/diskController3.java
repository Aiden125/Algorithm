package programmers.kit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class diskController3 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(diskController3.solution(jobs)); // 9

    }

    public static int solution(int[][] jobs) {
        int totalTimes = 0;
        int jobIndex = 0;
        int waitTimeUntilNow = 0;
        int doneCount = 0;

        // 기존 jobs배열 오름차순 정렬(요청시간 순서)
        Arrays.sort(jobs, (v1, v2) -> v1[0] - v2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]); // 첫번째요소 오름차순

        // 한 턴씩 진행된다 보면됨
        while(doneCount < jobs.length) {
            // 요청시기가 현재 기다린 시간보다 짧으면 넣어주기
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= waitTimeUntilNow) {
                pq.add(jobs[jobIndex++]);
            }
            
            if (!pq.isEmpty()) {
                int[] currentTask = pq.poll();
                totalTimes += currentTask[1] + waitTimeUntilNow - currentTask[0]; // 실행시간 + 기다린시간 - 요청시기
                waitTimeUntilNow += currentTask[1];
                doneCount++;
            } else {
                // 다음 작업의 요청시기로 변경, 요청부터 끝날때까지 기다린시기를 뜻하기 때문에
                // 별도 시간계산을 하지는 않는다.
                waitTimeUntilNow = jobs[jobIndex][0];
            }
        }

        return totalTimes / jobs.length;
    }
}

