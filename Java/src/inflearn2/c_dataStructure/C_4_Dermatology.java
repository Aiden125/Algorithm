package inflearn2.c_dataStructure;

import java.util.*;

public class C_4_Dermatology {
    int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return (H * 60) + M;
    }

    /**
     * 문제를 약간 바꿔서 동일 시간에 여러 손님이 올수도 있다고 가정할 경우
     * @param laser
     * @param enter
     * @return
     */
    public int solution(int[] laser, String[] enter) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int endTime = 0; // 다음 입장 가능 시간
        int cIndex = 0; // 손님 index

        // 첫손님 q에 집어넣기(레이저 소요 시간)
        int laserRequireTime = laser[Integer.parseInt(enter[cIndex].split(" ")[1])];
        q.offer(laserRequireTime);
        endTime = getTime(enter[cIndex].split(" ")[0]); // endTime으로 바로 하면 안되고 enterTime을 넣어줘야함
        cIndex++;

        for (int time = endTime; time < 1200; time++) {
            while (cIndex < enter.length && time == getTime(enter[cIndex].split(" ")[0])) {
                // 손님 띄엄띄엄 오는 경우 예외처리
                if (q.isEmpty() && getTime(enter[cIndex].split(" ")[0]) > endTime) {
                    endTime = getTime(enter[cIndex].split(" ")[0]);
                }

                laserRequireTime = laser[Integer.parseInt(enter[cIndex].split(" ")[1])];
                q.offer(laserRequireTime);
                cIndex++;
            }
            if (!q.isEmpty() && time == endTime) {
                endTime += q.poll(); // 수술실에 넣기, 소요시간 추가
            }

            answer = Math.max(answer, q.size());
            System.out.println(time);
        }

        return answer;
    }

    public static void main(String[] args) {
        C_4_Dermatology T = new C_4_Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:39 1", "10:39 1", "10:39 1", "10:39 1"}));
        /**
         * 3
         * 4
         * 0
         * 4
         */
    }
}