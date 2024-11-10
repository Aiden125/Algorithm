package b2.a_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A_2_SearchPath_3 {
    static int[][] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        // 정점 이어주기
        answer = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    graph.get(i).add(j);
                    answer[i][j] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            DFS(graph, i, visited);
            for (int j=0; j<n; j++) {
                if (visited[j]) {
                    answer[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void DFS(ArrayList<ArrayList<Integer>> arr, int current, boolean[] visited) {
        ArrayList<Integer> nodes = arr.get(current);
        for (int next : nodes) {
            if (visited[next]) continue;
            visited[next] = true;
            DFS(arr, next, visited);
        }
    }

    // 0,0 들어와
    // DFS(0, 0) map[0][1] = 1
    // DFS(0, 1) map[0][2] = 1
    // DFS(0, 2) map[0][0] = 1

    // DFS(0, 0) map[0][1] = 1
}
