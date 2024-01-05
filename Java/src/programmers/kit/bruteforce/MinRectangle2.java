package programmers.kit.bruteforce;

/**
 * sizes의 길이는 1이상 10,000 이하
 * 큰 값을 한쪽으로 몰고 각각의 맥스값 찾는 방식으로 풀이
 * --> 큰 값을 몰 필요없이 큰 값을 가로로 잡고, 작은 값을 세로로 잡으면 해결
 */
public class MinRectangle2 {
    public static void main(String[] args) {
        int[][] a = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(MinRectangle2.solution(a)); // 4000
    }
    public static int solution(int[][] sizes) {
        int x = 0; // 가로
        int y = 0; // 세로

        // 큰 값을 한쪽으로 몰기
        for (int i=0; i<sizes.length; i++) {
            x = Math.max(x, Math.max(sizes[i][0], sizes[i][1]));
            y = Math.max(y, Math.min(sizes[i][0], sizes[i][1]));
        }

        return x * y;
    }
}
