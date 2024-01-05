package programmers.kit.bruteforce;

/**
 * sizes의 길이는 1이상 10,000 이하
 * 큰 값을 한쪽으로 몰고 각각의 맥스값 찾는 방식으로 풀이
 */
public class MinRectangle {
    public static void main(String[] args) {
        int[][] a = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(MinRectangle.solution(a)); // 4000
    }
    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxA = 0; // 왼쪽 큰 값
        int maxB = 0; // 오른쪽 큰 값
        
        // 큰 값을 한쪽으로 몰기
        for (int i=0; i<sizes.length; i++) {
            int first = sizes[i][0];
            int second = sizes[i][1];
            // 왼쪽이 더 크면 자리 바꾸기
            if (second > first) {
                sizes[i][0] = second;
                sizes[i][1] = first;
            }
            maxA = Math.max(sizes[i][0], maxA);
            maxB = Math.max(sizes[i][1], maxB);
        }
        answer = maxA * maxB;

        return answer;
    }
}
