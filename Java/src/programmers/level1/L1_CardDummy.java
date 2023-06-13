package programmers.level1;

import java.util.HashMap;

public class L1_CardDummy {
    public static void main(String[] args) {
        String[] card1 = {"i", "drink", "water"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(card1, card2, goal));

        String[] card5 = {"a", "b", "c"};
        String[] card6 = {"d", "e", "f"};
        String[] goal7 = {"a", "d", "f"};
        System.out.println(solution(card5, card6, goal7)); // expected "NO"

    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        HashMap<String, Integer> c1Map = new HashMap<>();
        HashMap<String, Integer> c2Map = new HashMap<>();

        // hashMap에 담아주기 O(n)
        for(int i=0; i<cards1.length; i++) {
            c1Map.put(cards1[i], i);
        }
        for(int i=0; i<cards2.length; i++) {
            c2Map.put(cards2[i], i);
        }

        // goal 순회 돌면서 c1, c2에서 각각 착아보기
        int c1LastIndex = -1;
        int c2LastIndex = -1;
        for (int i=0; i<goal.length; i++) {
            String targetStr = goal[i];

            // cards1에서 찾기
            int c1CurIndex = c1Map.getOrDefault(targetStr, -1);
            if (c1CurIndex != -1) { // 찾은 경우
                // 찾았는데 이전 인덱스보다 같거나 작은 경우, 카드를 뛰어넘은 경우
                if (c1CurIndex <= c1LastIndex  || c1CurIndex - c1LastIndex > 1) {
                    answer = "No";
                    break;
                } else {
                    c1LastIndex = c1CurIndex;
                }
            }
            
            // cards2에서 찾기
            int c2CurIndex = c2Map.getOrDefault(targetStr, -1);
            if (c2CurIndex != -1) {
                // 찾았는데 이전 인덱스보다 같거나 작은 경우, 카드를 뛰어넘은 경우
                if (c2CurIndex <= c2LastIndex || c2CurIndex - c2LastIndex > 1) {
                    answer = "No";
                    break;
                } else {
                    c2LastIndex = c2CurIndex;
                }
            }

        }

        return answer;
    }

}
