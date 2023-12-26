package programmers.kit.stack;

import java.util.ArrayList;

public class DontLikeSameNumber {
    public static void main(String[] args) {
        int[] a = {1,1,3,3,0,1,1};
        DontLikeSameNumber.solution(a); // 1,3,0,1

    }

    public static int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        int num = -1;
        for (int a : arr) {
            if (a != num) {
                num = a;
                list.add(a);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
