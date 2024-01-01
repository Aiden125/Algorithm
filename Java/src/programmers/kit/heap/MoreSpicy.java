package programmers.kit.heap;

import java.util.ArrayList;
import java.util.Collections;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(MoreSpicy.solution(scoville, K)); // 2

//        int[] scoville2 = {3,5};
//        int K2 = 7;
//        System.out.println(MoreSpicy.solution(scoville2, K2)); // 1
//
//        int[] scoville3 = {3,5};
//        int K3 = 20;
//        System.out.println(MoreSpicy.solution(scoville3, K3)); // -1
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<scoville.length; i++) {
            list.add(scoville[i]);
        }
        Collections.sort(list);

        // 조건 되면 바로 종료
        if (list.get(0) >= K) {
            return answer;
        }

        while(list.size() >= 2) {
            answer++;

            int a = list.remove(0);
            int b = list.remove(0);
            int c = a + b*2;
            list.add(0, c);

            // 조건 안 맞으면 정렬 후 다시 시도
            for (int i=0; i<list.size()-1; i++) {
                int aa = list.get(i);
                int bb = list.get(i+1);
                if (aa >= bb) {
                    list.set(i+1, aa);
                    list.set(i, bb);
                } else {
                    break;
                }
            }

            int check = list.get(0);
            if (check >= K) {
                return answer;
            }

        }

        if (list.get(0) < K) {
            answer = -1;
        }

        return answer;
    }
}
