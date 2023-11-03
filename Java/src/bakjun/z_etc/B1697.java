package bakjun.z_etc;

import java.util.*;

public class B1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int target = sc.nextInt();
        int[] dis = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);

        while(!q.isEmpty()) {
            int current = q.poll();

            if (current == target) break; // 목표 찾음

            for(int i=0; i<3; i++){
                int nStep = -1;
                if(i==0) nStep = current-1;
                if(i==1) nStep = current+1;
                if(i==2) nStep = current*2;

                if (nStep<0 || nStep > dis.length-1) continue; // 탐색 불필요
                if (dis[nStep] != 0) continue; // 탐색 불필요
                q.offer(nStep);
                dis[nStep] = dis[current] + 1;

                if (nStep == target) break; // 목표 찾음
            }
        }

        System.out.println(dis[target]);
    }
}
