package programmers.kit.bruteforce;

import java.util.ArrayList;

public class PowerGrid {
    static ArrayList<Integer>[] graph;
    static int min;
    public static void main(String[] args) {
        int n2 = 9;
        int[][] k2 = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        System.out.println(PowerGrid.solution(n2, k2)); // 3

        int n1 = 4;
        int[][] k1 = {{1,2}, {2,3}, {3,4}};
        System.out.println(PowerGrid.solution(n1, k1)); // 0
    }

    public static int solution(int n, int[][] wires) {
        int answer = -1;
        graph = new ArrayList[n+1];
        min = n;

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

//            int aa = n - (graph[v1].size()+1);
//            int bb = graph[v1].size()+1;
//            int diff = Math.abs(aa - bb);
//            min = Math.min(min, diff);

            boolean[] visited = new boolean[n + 1];

            // 해당 간선을 그래프에서 제거
            int cnt = dfs(1, visited); // 임의의 시작점에서 dfs 탐색

            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        answer = min;
        return answer;
    }

    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }

}
