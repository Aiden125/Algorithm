package b2.a_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class A_1_ConnectedComponent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 개수
        int m = sc.nextInt(); // 간선 개수

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        boolean[] used = new boolean[n];
        int answer = 0;

        for (int i=0; i<n; i++) {
            if (used[i]) continue;
            DFS(used, arr, i);
            answer++;
        }

        System.out.println(answer);
    }

    static void DFS(boolean[] used, ArrayList<ArrayList<Integer>> arr, int i) {
        used[i] = true; // 현재 노드 방문처리

        for (int neighbor : arr.get(i)) {
            if (used[neighbor]) continue;
            DFS(used, arr, neighbor);
        }
    }
}
