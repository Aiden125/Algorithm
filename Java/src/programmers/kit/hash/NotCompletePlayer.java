package programmers.kit.hash;

import java.util.HashMap;

public class NotCompletePlayer {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(NotCompletePlayer.solution(participant, completion)); // leo
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        // 1. 선수 명단 세팅
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 2. 완료한 사람은 -1
        for (String p : completion) {
            map.put(p, map.getOrDefault(p, 0) - 1);
        }

        // 3. value가 1인 사람의 이름을 answer에 저장
        for (String p : participant) {
            int a = map.get(p);
            if (a == 1) {
                answer = p;
            }
        }

        return answer;
    }
}
