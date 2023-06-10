package programmers;

public class L1_Repainting {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};
        int result = solution(n, m, section);
        System.out.println(result);

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] wall = new boolean[n+1];

        // 배열 벽 만들기
        for(int i=0; i<section.length; i++) {
            int a = section[i];
            wall[a] = true;
        }

        // 배열 벽 칠해주기
        int pointerIndex = 0;
        int pointer = 0;
        while(pointer<=n-m && pointerIndex<section.length) {
            pointer = section[pointerIndex];
            if (wall[pointer] && pointer+m<=n) {
                answer++;
                for(int i=0; i<m; i++) {
                    wall[pointer+i] = false;
                }
            }
            pointerIndex++;
        }

        // 남은 부분 있다면 칠해주기
        for(int i=n; i>n-m; i--) {
            if(wall[i]) {
                answer++;
                break;
            }
        }

        return answer;
    }
}
