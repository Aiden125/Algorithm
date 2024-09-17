package inflearn2.b_hashing;

public class B_1_One_Used_String {
    public static void main(String[] args){
        B_1_One_Used_String T = new B_1_One_Used_String();
        System.out.println(T.solution("statitsics")); // 3
        System.out.println(T.solution("aabb")); // -1
        System.out.println(T.solution("stringshowtime")); // 3
        System.out.println(T.solution("abcdeabcdfg")); // 5
    }

    public int solution(String s){
        int answer = 0;

        int[] count = new int[26];
        int[] firstUsedIndex = new int[26];

        for (int i=0; i<s.length(); i++) {
            int charIndex = s.charAt(i) - 97;
            count[charIndex]++;
            if (count[charIndex] == 1) {
                firstUsedIndex[charIndex] = i+1;
            }
        }

        int min = 99999;
        for (int i=0; i<count.length; i++) {
            int countValue = count[i];
            if (countValue == 1) {
                min = Math.min(min, firstUsedIndex[i]);
            }
        }

        if (min == 99999) {
            answer = -1;
        } else {
            answer = min;
        }

        return answer;
    }
}



