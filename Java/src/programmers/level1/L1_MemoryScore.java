package programmers.level1;

import java.util.HashMap;

public class L1_MemoryScore {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] year = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        solution(name, year, photo);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];

        HashMap<String, Integer> peopleAndScore = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            peopleAndScore.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            int totalScore = 0;
            for(int j=0; j<photo[i].length; j++) {
                int score = peopleAndScore.getOrDefault(photo[i][j], 0);
                totalScore += score;
            }
            answer[i] = totalScore;
        }
        return answer;
    }
}
