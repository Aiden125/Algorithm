package inflearn2.e_greedy;

public class E_2_MoveCount {
    public int solution(int[] nums) {
        int answer = 0;

        int[] arr = new int[6]; // 0 1 2 3 4 5
        for (int x : nums) {
            arr[x]++;
        }

        answer += Math.min(arr[2], arr[3]);
        arr[2] = arr[2] - answer;
        arr[3] = arr[3] - answer;
        for (int i=2; i<arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        E_2_MoveCount T = new E_2_MoveCount();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
        /**
         * 4
         * 3
         * 5
         */
    }
}
