package programmers.kit.dfsbfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] a1 = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(Network.solution(n1, a1)); // 2

        int n2 = 3;
        int[][] a2 = {{1,1,0}, {1,1,1}, {0,1,1}};
        System.out.println(Network.solution(n2, a2)); // 1
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        // 리스트로 서로 연결해주기
        for (int i=0; i<computers.length; i++) {
            arr.add(new ArrayList<>());
            for (int j=0; j<computers.length; j++) {
                if (i==j) continue;

                if (computers[i][j] == 1) {
                    arr.get(i).add(j);
                }
            }
        }

        // 하나씩 진행
        for (int i=0; i<computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int index = q.poll();
                if (visited[index]) continue;
                visited[index] = true;
                Iterator<Integer> it = arr.get(index).iterator();
                while (it.hasNext()) {
                    int nextIndex = it.next();
                    q.add(nextIndex);
                }
            }
            visited[i] = true;
            answer++;
        }
        return answer;
    }
}
