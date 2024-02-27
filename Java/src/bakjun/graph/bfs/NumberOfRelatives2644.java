package bakjun.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 틀린 답, 반례 https://www.acmicpc.net/board/view/136445

/**
10
7 6
9
1 2
1 3
1 4
9 1
9 10
3 5
3 6
2 7
2 8
 * expect : 4 but, answer : 5
 */
public class NumberOfRelatives2644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i=0; i<r; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            arr.get(p1).add(p2);
            arr.get(p2).add(p1);
        }

        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int current = q.poll();
            visited[current] = true;
            ArrayList<Integer> nexts = arr.get(current);
            for (int next : nexts) {
                if (next == b) {
                    System.out.println(count);
                    found = true;
                    break;
                }
                if (visited[next]) continue;
                q.offer(next);
            }
            count++;
        }
        if (!found) {
            System.out.println("-1");
        }
    }
}
