package inflearn2.c_dataStructure;

import java.util.*;

class C_4_Dermatology_Sample {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }

    public int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        // 들어온 시간, 소요 시간인덱스를 inList에 넣어준다.
        for (int i = 0; i < n; i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        // q에 첫 손님 넣기. 일단 넣고 바로 빼는 형식으로 진행
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int finishTime = inList[0][0];
        int customerIndex = 1;
        
        // time을 기반으로 for문 진행
        for (int t = finishTime; t <= 1200; t++) {
            if (customerIndex < n && t == inList[customerIndex][0]) {
                if (Q.isEmpty() && inList[customerIndex][0] > finishTime) finishTime = inList[customerIndex][0];

                // q에 소요되는 시간 인덱스를 넣어준다.
                Q.offer(inList[customerIndex][1]);
                customerIndex++;
            }

            // q에 손님이 있고 현재 시간이 finishTime이란건 아무도 없다는 뜻 즉, 수술실에 넣는 행위
            if (t == finishTime && !Q.isEmpty()) {
                int idx = Q.poll();
                finishTime += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        C_4_Dermatology_Sample T = new C_4_Dermatology_Sample();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}