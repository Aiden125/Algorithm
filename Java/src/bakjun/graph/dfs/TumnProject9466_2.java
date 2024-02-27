package bakjun.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TumnProject9466_2 {
    static int[] arr;
    static boolean visited[], done[];
    static int teamCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            for (int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<=n; i++) {
                if (!done[i]) {
                    DFS(i);
                }
            }

            System.out.println(n - teamCount);
            teamCount = 0;

        }

    }

    static void DFS(int i) {
        // 이미 방문한 경우 팀 편성
        if (visited[i]) {
            teamCount++;
            done[i] = true;
        } else {
            visited[i] = true;
        }

        if (!done[arr[i]]) {
            DFS(arr[i]);
        }

        visited[i] = false;
        done[i] = true;
    }

}
