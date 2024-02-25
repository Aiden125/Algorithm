package nowon_study.week1;

import java.util.ArrayList;
import java.util.Arrays;

public class DonutAndBarGraph {
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] a1 = {{2, 3}, {4, 3},{1, 1}, {2, 1}};
        System.out.println(Arrays.toString(solution(a1))); // 2, 1, 1, 0
    }

    public static int[] solution(int[][] edges) {
        int[] answer = {};

        int[] rootTargets = new int[edges.length+1];
        for (int i=0; i<edges.length; i++) {
            int edgeIndex = edges[i][0];
            if (rootTargets[edgeIndex] == -999) {
                continue;
            }
            rootTargets[edges[i][1]] = -999;
            rootTargets[edgeIndex]++;
        }
        int root = 0;
        for (int i=0; i<edges.length; i++) {
            if (rootTargets[i] > 2) {
                root = i;
                break;
            }
        }

        ArrayList<Integer> startFromRoot = new ArrayList<>();
        for (int i=0; i<edges.length; i++) {
            if (edges[i][0] == root) {
                startFromRoot.add(edges[i][1]);
            }
        }

        for (int startNode : startFromRoot) {
            DFS(startNode, edges);
        }
        
        return answer;
    }

    // 케이스 별로 정의
    static void DFS(int startNode, int[][] edges) {

    }
}
