package programmers.kit.hash;

import java.util.HashMap;

public class Costume {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Costume.solution(clothes)); // exp : 5
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // 옷 종류 담는 맵에 넣어주기
        for (int i=0; i<clothes.length; i++) {
            String clothesKey = clothes[i][1];
            map.put(clothesKey, map.getOrDefault(clothesKey, 0) + 1);
        }

        // 안입는 경우까지 고려해서 경우의 수 계산
        int count = 1;
        for (String key : map.keySet()) {
            int num = map.get(key) + 1; // 안입는 경우까지 더하기
            count *= num;
        }
        answer = count - 1;

        return answer;
    }
}
