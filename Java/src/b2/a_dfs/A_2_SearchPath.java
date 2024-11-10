package b2.a_dfs;

import java.util.*;
public class A_2_SearchPath {
    static int[][] map;
    static int[][] answer;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 개수

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            arr.add(new ArrayList<>());
        }

        // 정점 이어주기
        map = new int[n][n];
        answer = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    arr.get(i).add(j);
                    map[i][j] = 1;
                    answer[i][j] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 0) {
                    visit = new boolean[n];
                    DFS(arr, i, i, visit);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println(); // 행 끝에서 줄바꿈
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> arr, int start, int current, boolean[] visit) {
        ArrayList<Integer> nodes = arr.get(current);
        for (int next : nodes) {
            if (visit[next]) continue;
            answer[start][next] = 1;
            visit[next] = true;
            DFS(arr, start, next, visit);
        }
    }

    // 0,0 들어와
    // DFS(0, 0) map[0][1] = 1
    // DFS(0, 1) map[0][2] = 1
    // DFS(0, 2) map[0][0] = 1

    // DFS(0, 0) map[0][1] = 1
}
