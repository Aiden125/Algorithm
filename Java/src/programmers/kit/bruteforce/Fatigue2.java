package programmers.kit.bruteforce;

public class Fatigue2 {
    static boolean[] visited;
    static int answer = 0;
    static boolean flag;
    public static void main(String[] args) {

        // 기본 테스트 케이스
        int k1 = 80;
        int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k1, dungeons1));  // 예상 결과: 3

        // 모든 던전 탐험 불가능한 경우
        int k3 = 80;
        int[][] dungeons3 = {{100, 30}, {120, 40}, {150, 50}};
        System.out.println(solution(k3, dungeons3));  // 예상 결과: 0

        // 던전이 한 개인 경우
        int k4 = 150;
        int[][] dungeons4 = {{120, 30}};
        System.out.println(solution(k4, dungeons4));  // 예상 결과: 1
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return answer;
    }

    public static void DFS(int depth, int remain, int[][] dungeons) {
        // 이미 모든 던전을 다 돌 수 있는 케이스를 찾았다면 더 진행할 필요x
        if (flag) {
            return;
        }
        // 오면 일단 던전 다 돌기
        for (int i=0; i<dungeons.length; i++) {
            // 방문했거나 피로도가 부족하면 건너뛰기
            if (visited[i] || remain - dungeons[i][0] < 0) {
                continue;
            }

            // 방문가능하면 방문하고 다음뎁스 넘어가기
            visited[i] = true;
            int cost = dungeons[i][1];
            DFS(depth + 1, remain - cost, dungeons);
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
        if (answer == dungeons.length) flag = true;
    }

}
