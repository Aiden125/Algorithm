package bakjun.dfsbfs;

import java.util.*;

public class chooseNumber2688 {
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }

        // 하나 입력받고 그 순서대로 넣기
        for (int i=1; i<=n; i++) {
            int node = sc.nextInt();
            arr.get(i).add(node);
            if (i==node) { // 본인이 본인 가지고 있으면 바로 정답에 넣기
                visited[i] = true;
                answer.add(i);
            }
        }

        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> currentNodes = new ArrayList<>();
                HashMap<Integer, Boolean> nextNodes = new HashMap<>();
                DFS(i, arr, currentNodes, nextNodes);
                boolean check = true;
                for (int node : currentNodes) {
                    if (!nextNodes.getOrDefault(node, false)) {
                        check = false;
                    }
                }
                if (check) {
                    answer.addAll(currentNodes);
                }
                visited[i] = true;
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        Iterator<Integer> it = answer.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    static void DFS(int currentNode, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> currentNodes, HashMap<Integer, Boolean> nextNodes) {
        visited[currentNode] = true;
        int nextNode = arr.get(currentNode).get(0);
        currentNodes.add(currentNode);
        nextNodes.put(nextNode, true);
        if (!visited[nextNode]) {
            DFS(nextNode, arr, currentNodes, nextNodes);
        }
        visited[currentNode] = false;
    }

}
