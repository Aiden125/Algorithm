package programmers.kit.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * ArrayList<String>을 정렬시 사전순대로 0, 1, 2 등 요소가 정렬될뿐
 * 안에 string 요소는 정렬되는게 아니다.
 */
public class TripPath {
    static ArrayList<String> preAnswerSet = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
//        String[][] a1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        System.out.println(Arrays.toString(TripPath.solution(a1))); // ["ICN", "JFK", "HND", "IAD"]

        String[][] a2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(TripPath.solution(a2))); // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        DFS(0, "", "", tickets);

        Collections.sort(preAnswerSet);
        answer = preAnswerSet.get(0).split(" ");
        return answer;
    }

    static void DFS(int depth, String currentAir, String path, String[][] tickets) {
        if (depth == 0) {
            path = "ICN";
        }
        if (depth == tickets.length) {
            preAnswerSet.add(path);
        }
        for (int i=0; i<tickets.length; i++) {
            String currentTarget = tickets[i][0];
            if (currentAir.equals(currentTarget) || (depth == 0 && currentTarget.equals("ICN"))) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                DFS(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
