package b2.a_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 언제 cycle 이 되는가? --> 본인한테 돌아올때
 * 2. 하나씩만 추가하는 방법
 */
public class A_6_PickNumber_2 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        ArrayList<Integer> answer = new ArrayList<>();
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=n; i++) {
            visited[i] = true;
            DFS(i, i, arr, answer);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int x : answer) {
            System.out.println(x);
        }
    }

    static void DFS(int start, int current, int[] arr, ArrayList<Integer> answer) {
        int nextNode = arr[current];

        if (!visited[nextNode]) {
            visited[nextNode] = true;
            DFS(start, arr[current], arr, answer);
            visited[nextNode] = false;
        }

        if (start == arr[current]) {
            answer.add(current);
        }
    }
}
