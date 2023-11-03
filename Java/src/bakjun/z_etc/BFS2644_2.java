package bakjun.z_etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS2644_2 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        // 하나에 하나를 달아줘야하는 개념

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람 수
        int start = sc.nextInt();
        int end = sc.nextInt();
        int peopleRelation = sc.nextInt(); //

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<peopleRelation; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        bfs(start);

        if(distance[end] > 0) {
            System.out.println(distance[end]);
        } else {
            System.out.println("-1");
        }

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int vertex = q.poll();

            for(int i=0; i<list[vertex].size(); i++) {
                int next = list[vertex].get(i);

                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    distance[next] = distance[vertex]+1;
                }
            }
        }
    }
}
