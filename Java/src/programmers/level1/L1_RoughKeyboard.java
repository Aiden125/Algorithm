package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class L1_RoughKeyboard {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(Arrays.toString(solution(keymap, targets)));

        String[] keymap2 = {"AGZ", "BSSS"};
        String[] targets2 = {"ASA","BGZ"};
        System.out.println(Arrays.toString(solution(keymap2, targets2)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>();

        // 키보드 키 별로 순환
        for(int i=0; i<keymap.length; i++) {
            String s = keymap[i]; // ABCD

            // 각 문자를 한 글자씩 순환
            for(int j=0; j<s.length(); j++) {
                char currentChar = s.charAt(j);
                int location = map.getOrDefault(currentChar, -1);
                if (location == -1 || location > j) { // 키가 없는 경우
                    map.put(currentChar, j+1); // 인덱스가 아닌 누르는 횟수로 넣어야 하기 때문에 +1
                }
            }
        }

        // 키보드에서 최종 값 구하기
        for(int i=0; i< targets.length; i++) {
            String targetStr = targets[i];
            int result = 0;

            for(int j=0; j<targetStr.length(); j++) {
                char miniTarget = targetStr.charAt(j);
                int resultChunk = map.getOrDefault(miniTarget, -1);
                if (resultChunk == -1) {
                    result = -1;
                    break;
                } else {
                    result += resultChunk;
                }
            }

            answer[i] = result;
        }

        return answer;
    }
}
