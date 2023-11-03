package bakjun.z_etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=a; i++) {
            q.offer(i);
        }

        int c = 0;
        while(!q.isEmpty()) {
            c = q.poll();
            if(!q.isEmpty()) {
                int b = q.poll();
                q.offer(b);
            }
        }

        System.out.println(c);
    }
}
