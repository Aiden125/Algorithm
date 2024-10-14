package inflearn2.e_greedy;

import java.util.*;

public class E_5_BattleGame {
    public int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        int[] teamArr = new int[26];
        int totalPower = 0;

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i=0; i<students.length; i++) {
            int a = students[i].charAt(0) - 97;
            int b = Integer.parseInt(students[i].split(" ")[1]);
            arr.add(new int[] {b, a, i}); // 공격력, 팀, 학생번호
            teamArr[a] += b;
            totalPower += b;
        }

        Collections.sort(arr, (a,b) -> b[0] - a[0]); // 공격력 내림차순

        for (int i=0; i<arr.size(); i++) {
            int[] x = arr.get(i);
            int power = x[0];

            // 공격력이 같은애가 있으면 과정 반복
            int end = i;
            while (end < arr.size() && power == arr.get(end)[0]) {
                teamArr[arr.get(end)[1]] -= arr.get(end)[0];
                totalPower -= arr.get(end)[0];
                end++;
            }

            for (int k=i; k<end; k++) {
                answer[arr.get(k)[2]] = totalPower - teamArr[arr.get(k)[1]];
            }

            i = end-1; // end까지는 이미 처리했으니 점프
        }

        return answer;
    }

    public static void main(String[] args) {
        E_5_BattleGame T = new E_5_BattleGame();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
        /**
         * 35 21 0 10 21
         * 35 21 0 10 38 59 21
         * 15 23 82 0 15 82 0
         * 45 20 20 0 0 20 75
         */
    }
}
