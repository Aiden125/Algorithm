package programmers.level1;

public class L1_UniquePassword {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] checkSkip = new boolean[26];

        // 스킵할 배열 정해주기 true면 스킵 대상
        for(int i=0; i<skip.length(); i++) {
            char skipChar = skip.charAt(i);
            int a = skipChar-97;
            checkSkip[a] = true;
        }

        for(int i=0; i<s.length(); i++) {
            char baseChar = s.charAt(i);
            int baseIndex = baseChar-97;
            int skipCount = index;

            // 타겟인덱스랑 파이널 사이에 몇개의 스킵 대상이 있는지
            while(skipCount > 0) {
                skipCount--;
                baseIndex++;
                if (baseIndex >= 26) {
                    baseIndex = baseIndex-26;
                }
                if (checkSkip[baseIndex]) {
                    skipCount++;
                }
            }

            char finalStr = (char) (baseIndex+97);
            answer += String.valueOf(finalStr);
        }

        return answer;
    }
}
