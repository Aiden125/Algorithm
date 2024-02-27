package bakjun.graph.dfs;

import java.util.Scanner;

public class Dom10552 {
    static int[] favoriteChannel;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        favoriteChannel = new int[m+1];
        visited = new boolean[m+1];

        // 나이 적은 노인이 우선순위이므로 이미 선점되면 재선점 x
        while(--n >= 0) {
            int f = sc.nextInt();
            int h = sc.nextInt();

            // 아래 처리를 통해 이미 선점된 채널은 안건드리게
            if (favoriteChannel[h] == 0) favoriteChannel[h] = f;
        }

        System.out.println(DFS(p));
    }

    static int DFS(int channel) {
        if (visited[channel]) answer = -1;
        else if (favoriteChannel[channel] != 0) {
            visited[channel] = true;
            answer++;
            DFS(favoriteChannel[channel]);
        }
        return answer;

    }
}
