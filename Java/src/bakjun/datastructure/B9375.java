package bakjun.datastructure;

import java.util.HashMap;
import java.util.Scanner;

public class B9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int j=0; j<t; j++) {
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                String item = sc.next();
                String position = sc.next();
                map.put(position, map.getOrDefault(position, 0) + 1);
            }

            int caseCountTotal = 1;
            for (String s : map.keySet()) {
                int caseCount = map.get(s);
                caseCountTotal = caseCountTotal * (caseCount+1);
            }
            System.out.println(caseCountTotal-1);
        }

    }
}
