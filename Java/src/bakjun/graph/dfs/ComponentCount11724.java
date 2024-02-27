package bakjun.graph.dfs;

import java.util.*;

public class ComponentCount11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        // 1~6번 노드 순차 loop
        for (int i=1; i<=n; i++) {
            // 방문 안했었으면 answer++
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            answer++;
            q.offer(i);

            // 현재 노드와 연결된 노드 모두 방문 처리
            while(!q.isEmpty()) {
                int currentNode = q.poll();
                ArrayList<Integer> connectedNodes = arr.get(currentNode);
                for (int connectedNode : connectedNodes) {
                    if (visited[connectedNode]) {
                        continue;
                    }
                    q.offer(connectedNode);
                    visited[connectedNode] = true;
                }
            }
        }
        System.out.println(answer);
    }

}
