package inflearn2.e_greedy;

import java.util.*;

public class E_6_MaxPeople {
    public int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0;

        // 탈 수 있는 인원수만큼 ktx에 넣어주기
        int[] ktx = new int[n+1];
        for (int i=0; i<trans.length; i++) {
            int start = trans[i][0];
            int end = trans[i][1];
            for (int j=start; j<=end; j++) {
                ktx[j] += trans[i][2];
            }
        }

        // 어린이 타는 순서대로 정렬
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]); // 2차원 배열이라 직접 정렬조건 지정 필요

        // 승차 배열, 계속 정렬
        ArrayList<Integer> arr = new ArrayList<>();

        int boardingIndex = 0;
        for (int i=0; i<=n; i++) {
            // 내릴 애들 내려
            while (!arr.isEmpty() && arr.get(0) == i) {
                arr.remove(0);
                answer++;
            }
            // 탈 애들 타
            while (boardingIndex < bookings.length && bookings[boardingIndex][0] == i) {
                arr.add(bookings[boardingIndex][1]);
                boardingIndex++;
            }
            Collections.sort(arr);

            // 인원 초과 내려
            while (arr.size() > ktx[i]) {
                arr.remove(arr.size() -1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        E_6_MaxPeople T = new E_6_MaxPeople();
//        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
//        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
//        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
//        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
        /**
         * 5
         * 2
         * 7
         * 8
         * 7 답이 안맞음
         */
    }
}