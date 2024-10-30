package b2.a_dfs;

import java.util.*;
public class A_1_ConnectedComponent_2 {
    static boolean[] visited;
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int nodeSize = sc.nextInt();
        int edgeSize = sc.nextInt();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=nodeSize; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<edgeSize; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        visited = new boolean[nodeSize+1];
        for (int i=1; i<=nodeSize; i++) {
            if (visited[i]) continue;
            DFS(arr, i);
            answer++;
        }

        System.out.println(answer);
    }

    static void DFS(ArrayList<ArrayList<Integer>> arr, int node) {
        visited[node] = true;

        ArrayList<Integer> next = arr.get(node);
        for (int x : next) {
            if (visited[x]) continue;
            DFS(arr, x);
        }
    }
}
