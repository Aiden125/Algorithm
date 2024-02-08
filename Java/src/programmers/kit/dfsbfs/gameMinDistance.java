package programmers.kit.dfsbfs;

public class gameMinDistance {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {

        int[][] a1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(gameMinDistance.solution(a1));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps.length; j++) {

            }
        }
        return answer;
    }
}
