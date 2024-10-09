package inflearn2.d_sorting;

import java.util.*;

public class D_6_MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(Arrays.stream(tasks).boxed().toArray(Integer[]::new)
                ));
        arr.add(0);
        Collections.sort(arr);

        HashSet<Integer> set = new HashSet<>();
        for (int i=1; i<arr.size(); i++) {
            int a = arr.get(i) - arr.get(i-1);
            if (a == 0) { // 같은 값 연속으로 있는 경우 제외
                continue;
            }

            long rest = arr.size() - i;
            long roundTime = rest * a;
            if (k >= roundTime) {
                k -= roundTime;
                set.add(arr.get(i));
            } else {
                k = k % rest; // 이 값을 나눠도 되는지에 대한 확신 부족
                break;
            }
        }

        int count = 0;
        for (int i=0; i<tasks.length; i++) {
            if (set.contains(tasks[i])) continue;

            if (count == k) {
                answer = i + 1;
                break;
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        D_6_MultiTasking T = new D_6_MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
        /**
         * 3
         * 6
         * 5
         */
    }

}
