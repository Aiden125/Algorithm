package bakjun.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfRelatives2644_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        int[] dis = new int[n+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i=0; i<r; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            arr.get(p1).add(p2);
            arr.get(p2).add(p1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        while (!q.isEmpty()) {
            int current = q.poll();
            visited[current] = true; // 이걸 어디 두는지는 상관x
            ArrayList<Integer> nexts = arr.get(current);
            for (int next : nexts) {
                if (visited[next]) continue;
                q.offer(next);
                dis[next] = dis[current] + 1;
            }
        }
        if (dis[b] > 0) {
            System.out.println(dis[b]);
        } else {
            System.out.println(-1);
        }
    }
}
