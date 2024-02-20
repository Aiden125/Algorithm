package bakjun.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class TumnProject9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            arr.add(new ArrayList<>()); // 0번 인덱스는 편의성을 위해서 넣어주기

            int teamCount = 0;
            // 학생들 연결된 형태로 넣어주기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i=1; i<=n; i++) {
                arr.add(new ArrayList<>());
                int nextStudent = Integer.parseInt(st.nextToken());
                arr.get(i).add(nextStudent);
                // 본인 스스로 팀을 원하는 경우 미리 처리
                if (i == nextStudent) {
                    visited[i] = true;
                    teamCount++;
                }
            }

            for (int i=1; i<=n; i++) {
                if (!visited[i]) {
                    HashMap<Integer, Boolean> curSt = new HashMap<>();
                    ArrayList<Integer> nextSt = new ArrayList<>();
                    DFS(i, arr, visited, curSt, nextSt);

                    boolean check = true;
                    for (int a : nextSt) {
                        if (!curSt.getOrDefault(a, false)) {
                            check = false;
                            break;
                        } else {
                            curSt.put(a, false);
                        }
                    }
                    if (check) {
                        teamCount += curSt.size();
                    } else {
                        for (int key : curSt.keySet()) {
                            visited[key] = true;
                        }
                    }
                }
                visited[i] = true;

            }

            System.out.println(n - teamCount);
        }

    }

    static void DFS(int currentStudent, ArrayList<ArrayList<Integer>> arr, boolean[] visited, HashMap<Integer, Boolean> curSt, ArrayList<Integer> nextSt) {
        visited[currentStudent] = true;
        curSt.put(currentStudent, true);

        int nextStu = arr.get(currentStudent).get(0);
        nextSt.add(nextStu);
        if (!visited[nextStu]) {
            DFS(nextStu, arr, visited, curSt, nextSt);
            visited[nextStu] = false;
        }

    }
}
