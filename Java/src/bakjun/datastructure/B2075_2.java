package bakjun.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2075_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(sc.nextInt());
            }
        }

        for (int i = 1; i < n; i++) {
            q.poll();
        }
        System.out.println(q.peek());

    }
}
