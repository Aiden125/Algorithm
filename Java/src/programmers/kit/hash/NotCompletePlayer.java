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
        
        // 지원자들 이름과 수 누적시키기(같은 이름도 있으니까 orDefault 활용)
        for (String a : participant) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        // 완료한사람들은 빼버리기
        for (String comp : completion) {
            map.put(comp, map.get(comp)-1);
        }

        // 지원자 중 아직 1인 값을 가진 이름 정답에 할당
        for (String a : participant) {
            int count = map.get(a);
            if (count > 0) {
                answer = a;
            }
        }
        return answer;
    }
}
