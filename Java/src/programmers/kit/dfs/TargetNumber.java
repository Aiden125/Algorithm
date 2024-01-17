package programmers.kit.dfs;

public class TargetNumber {
    static int answer = 0;
    public static void main(String[] args) {

        int[] a1 = {1,2,3};
        int t1 = 6;
        System.out.println(TargetNumber.solution(a1, t1)); // 1

//        int[] a2 = {4,1,2,1};
//        int t2 = 4;
//        System.out.println(TargetNumber.solution(a2, t2)); // 2
    }
    public static int solution(int[] numbers, int target) {
        DFS(0, 0, numbers, target);
        return answer;
    }
    static void DFS(int depth, int sum, int[] numbers, int target) {
        if (sum == target && depth == numbers.length) {
            answer++;
        }
        if (depth < numbers.length) {
            DFS(depth + 1, sum + numbers[depth], numbers, target);
            DFS(depth + 1, sum - numbers[depth], numbers, target);
        }
    }
}
