package b2_b_bfs;

import java.io.*;
import java.util.*;
public class B_1_DfsAndBfs {
    static List<ArrayList<Integer>> arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작점

        visited = new boolean[n+1];
        arr = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        sb = new StringBuilder();
        DFS(v);
        sb.append("\n");
        visited = new boolean[n+1];
        BFS(v);

        System.out.println(sb);
    }

    static void DFS(int start) {
        visited[start] = true;
        sb.append(start + " ");

        ArrayList<Integer> node = arr.get(start);
        Collections.sort(node);
        for (int next : node) {
            if (visited[next]) continue;
            DFS(next);
        }
    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start + " ");

        while (!q.isEmpty()) {
            int a = q.poll();
            ArrayList<Integer> nodes = arr.get(a);
            Collections.sort(nodes);
            for (int next : nodes) {
                if (visited[next]) continue;
                sb.append(next + " ");
                q.offer(next);
                visited[next] = true;
            }
        }
    }
}
