package programmers.kit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class diskController2 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(diskController2.solution(jobs)); // 9
    }

    public static int solution(int[][] jobs) {
        int totalTimes = 0;
        int totalWaitTime = 0; // 수행되고난 직후 시간
        int jobsIndex = 0; // jobs배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 원본 배열 요청시간 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 처리 시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);

        while(count < jobs.length) {

            // 하나의 작업이 완료되는 시점(end)까지 들어온 요청 모두 넣기
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= totalWaitTime) {
                pq.add(jobs[jobsIndex]);
                jobsIndex++;
            }

            // q가 비어있다는건 작업완료(end)이후 다시 요청이 들어온다는 것
            if (pq.isEmpty()) {
                totalWaitTime = jobs[jobsIndex][0];
            } else {
                int[] temp = pq.poll();
                totalTimes += temp[1] + totalWaitTime - temp[0]; // 걸리는 시간 + 기다린시간 - 요청시간
                totalWaitTime += temp[1]; // 끝나는 시간
                count++;
            }
        }

        return (int) Math.floor(totalTimes / jobs.length);
    }
}

