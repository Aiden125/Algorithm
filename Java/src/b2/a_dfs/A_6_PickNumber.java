package b2.a_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 언제 싸이클이 되는가? -> 본인한테 다시 돌아올 때
 * 1. 경로 자체를 등록하는 경우
 */
public class A_6_PickNumber {
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> selfArray = new ArrayList<>();
        visited = new boolean[n+1];

        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == i) {
                visited[i] = true;
                selfArray.add(i);
            }
        }

        for (int i=1; i<=n; i++) {
            if (visited[i]) continue;

            ArrayList<Integer> nodePath = new ArrayList<>();
            HashMap<Integer, Boolean> nodePathValidator = new HashMap<>();
            DFS(arr, i, nodePath, nodePathValidator);

            boolean isCycle = true;
            for (int x : nodePath) {
                if (!nodePathValidator.getOrDefault(x, false)) {
                    isCycle = false;
                    break;
                }
            }
            if (isCycle) {
                selfArray.addAll(nodePath);
                for (int x : nodePath) {
                    visited[x] = true;
                }
            } else {
                visited[i] = true;
            }
        }

        Collections.sort(selfArray);
        System.out.println(selfArray.size());
        for (int x : selfArray) {
            System.out.println(x);
        }
    }

    static void DFS(int[] arr, int current, ArrayList<Integer> nodePath, HashMap<Integer, Boolean> nodePathValidator) {
        visited[current] = true;
        nodePath.add(current);

        int next = arr[current];
        nodePathValidator.put(next, true);

        if (!visited[next]) {
            DFS(arr, next, nodePath, nodePathValidator);
        }
        visited[current] = false;
    }
}
