package inflearn2.d_sorting;

import java.util.*;

public class D_7_MeetingRoom {
    public int solution(int[][] meetings) {
        int answer = 0;

        ArrayList<Integer> inList = new ArrayList<>();
        ArrayList<Integer> outList = new ArrayList<>();

        for (int i=0; i<meetings.length; i++) {
            inList.add(meetings[i][0]);
            outList.add(meetings[i][1]);
        }
        Collections.sort(inList);
        Collections.sort(outList);

        int n = meetings.length;
        int count = 0;
        int inIndex = 0;
        int outIndex = 0;
        for (int t=0; t<50000; t++) {
            while (outIndex < n && outList.get(outIndex) == t) {
                count--;
                outIndex++;
            }
            while (inIndex < n && inList.get(inIndex) == t) {
                count++;
                inIndex++;
            }
            answer = Math.max(answer, count);

            if (outIndex >= n && inIndex >= n) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        D_7_MeetingRoom T = new D_7_MeetingRoom();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        /**
         * 2
         * 5
         * 3
         * 3
         */
    }
}
