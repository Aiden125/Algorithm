package inflearn2.c_dataStructure;

import java.util.*;

//CPU 스케쥴링
public class C_5_Cpu_schedule {
    public int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];

        int[][] inList = new int[tasks.length][3]; // 도착,소요,작업번호
        for (int i = 0; i < tasks.length; i++) {
            int[] a = {tasks[i][0], tasks[i][1], i};
            inList[i] = a;
        }
        Arrays.sort(inList, (a,b) -> Integer.compare(a[0], b[0])); // 첫번째 원소 비교, 두번째는 기존 순서 유지

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 첫번째 원소 비교 후 두번째 원소 비교
        int endTime = 0;
        pq.offer(new int[]{inList[0][1], inList[0][2]});
        endTime = inList[0][0]; // 소요시간이 아니라 시작 시간으로 넣어주는거 까먹지 말기
        int cIndex = 1;
        int outIndex = 0;

        for (int time = endTime; time < 200000; time++) {
            while (cIndex < inList.length && time == inList[cIndex][0]) {
                // 작업간 시간이 붕뜨는 경우 방지
                if (pq.isEmpty() && endTime < inList[cIndex][0]) {
                    endTime = inList[cIndex][0];
                }
                pq.offer(new int[]{inList[cIndex][1], inList[cIndex][2]});
                cIndex++;
            }

            if (!pq.isEmpty() && time == endTime) {
                int[] a = pq.poll();
                endTime += a[0]; // 소요시간
                answer[outIndex++] = a[1]; // 작업번호
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        C_5_Cpu_schedule T = new C_5_Cpu_schedule();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
        /**
         * [1,3,0,2,4]
         * [5,4,2,0,1,3]
         * [7,0,6,1,4,2,3,5]
         * [1,3,0,2]
         */
    }
}
