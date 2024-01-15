package programmers.kit.bruteforce;

public class VowelDictionary {
    static int cnt = 0;
    static String vowel = "AEIOU";
    static boolean flag = false;
    public static void main(String[] args) {
//        String a1 = "AAAAE";
//        System.out.println(VowelDictionary.solution(a1)); // 6

        String a2 = "AAAE";
        System.out.println(VowelDictionary.solution(a2)); // 10
    }
    public static int solution(String word) {
        DFS("", word);
        return cnt;
    }
    static void DFS(String currentWord, String targetWord) {
        // 5글자 넘어가면 대상이 아니어서 더이상 진행x
        if (flag || currentWord.length() > vowel.length()) {
            return;
        }
        if (currentWord.length()>0) {
            cnt +=1;
        }
        if (currentWord.equals(targetWord)) {
            flag = true;
        }
        for (int i=0; i<vowel.length(); i++) {
            String nextWord = currentWord + vowel.charAt(i);
            DFS(nextWord, targetWord);
        }
    }
}
