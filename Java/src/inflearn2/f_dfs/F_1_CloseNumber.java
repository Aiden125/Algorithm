package inflearn2.f_dfs;

public class F_1_CloseNumber {
    static int min;

    public int solution(int n){
        int answer = 0;

        this.min = Integer.MAX_VALUE;

        String str = String.valueOf(n);
        String target = "";
        boolean[] used = new boolean[str.length()];
        dfs(0, str, target, used, n);

        if (min == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = min;
        }

        return answer;
    }

    void dfs(int depth, String str, String target, boolean[] used, int originNumber) {
        if (depth==str.length()) {
            if (Integer.parseInt(target) > originNumber) {
                min = Math.min(min, Integer.parseInt(target));
            }
            return;
        }
        for (int i=0; i<str.length(); i++) {
            if (used[i] == true) continue;

            used[i] = true;
            dfs(depth+1, str, target + str.charAt(i), used, originNumber);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        F_1_CloseNumber T = new F_1_CloseNumber();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
        /**
         * 132
         * -1
         * 20735
         * 71127
         * 54321
         */
    }
}