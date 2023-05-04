package bakjun;

import java.util.*;

public class BFS2644 {
    static ArrayList<Integer>[] graph; // 인접 리스트
    static boolean[] visited; // 방문 체크
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int targetA = sc.nextInt(); // start
        int targetB = sc.nextInt(); // end
        int pepopleNum = sc.nextInt();

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        // arrayList 초기화
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<pepopleNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(targetA);

        if (distance[targetB] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(distance[targetB]);
        }

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            int v = q.poll(); // v :: 볼텍스(정점)

            for (int i=0; i<graph[v].size(); i++) {
                int next = graph[v].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[v] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
