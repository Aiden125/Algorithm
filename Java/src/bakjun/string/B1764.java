package bakjun.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i=0; i<m; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        ArrayList<String> answer = new ArrayList<>();
        for (String a : map.keySet()) {
            int b = map.get(a);
            if (b == 2) {
                answer.add(a);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }



    }
}
