package programmers.kit.dfsbfs;

public class ChangeWord {
    static int answer = 999;
    public static void main(String[] args) {

//        String a1 = "hit";
//        String b1 = "cog";
//        String[] c1 = {"hot", "dot", "dog", "lot", "log", "cog"};
//        System.out.println(ChangeWord.solution(a1, b1, c1)); // 4

//        String a2 = "hit";
//        String b2 = "cog";
//        String[] c2 = {"hot", "dot", "dog", "lot", "log"};
//        System.out.println(ChangeWord.solution(a2, b2, c2)); // 0

        String a3 = "hit";
        String b3 = "hot";
        String[] c3 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(ChangeWord.solution(a3, b3, c3)); // 1


    }

    public static int solution(String begin, String target, String[] words) {
        // DFS로 풀이
        boolean[] visited = new boolean[words.length];
        DFS(0, begin, target, words, visited);
        if (answer == 999) answer = 0;
        return answer;
    }

    static void DFS(int depth, String currentWord, String target, String[] words, boolean[] visited) {
        if (depth > visited.length) return;
        String nextWord = "";
        int currentIndex = -999;
        // 단어가 있을때만 진행
        if (currentWord.length() > 0) {
            // 한 단어씩 비교
            for (int i=0; i<words.length; i++) {
                // 이미 방문한 단어 제외
                if (visited[i]) {
                    continue;
                }
                // 방문한 단어가 아니면 뽑아서 비교
                String a = words[i];
                int canNext = 0;
                // 다음 단어로 가능한 지 체크
                for (int j=0; j<currentWord.length(); j++) {
                    if (a.charAt(j) != currentWord.charAt(j)) {
                        canNext++;
                    }
                    if (canNext > 1) {
                        break;
                    }
                }
                if (canNext == 1) {
                    nextWord = a;
                    currentIndex = i;
                    visited[i] = true;
                    if (nextWord.equals(target)) {
                        answer = Math.min(answer, depth + 1);
                    }
                    DFS(depth + 1, nextWord, target, words, visited);
                    visited[currentIndex] = false;
                }
            }
        }
    }
}
