package programmers.kit.bruteforce;

public class Fatigue {
    // 방문배열
    static boolean[] visited;
    static int answer = 0;
    static boolean flag = false;
    public static void main(String[] args) {

        int k = 80;
        int[][] d = {{80,20}, {50,40}, {30,10}};
        System.out.println(Fatigue.solution(k, d)); // 3
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return answer;
    }

    static void DFS(int depth, int remain, int[][] dungeons) {
        if (flag) {
            return;
        }
        for (int i=0; i<dungeons.length; i++) {
            // 방문했거나, 피로도가 부족한 경우는 continue
            if (visited[i] || remain - dungeons[i][0] < 0) {
                continue;
            }
            visited[i] = true; // 방문 체크
            int cost = dungeons[i][1];
            DFS(depth+1, remain-cost, dungeons);
            visited[i] = false; // 방문 해제
        }
        answer = Math.max(answer, depth);
        if (answer == dungeons.length) flag = true;
    }


}
