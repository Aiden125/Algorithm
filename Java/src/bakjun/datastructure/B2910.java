package bakjun.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
            arr.add(a);
        }

        // 빈도수 기준으로 리스트 정렬
        Collections.sort(arr, (o1, o2) -> {
            // 빈도 수 같은 경우 원래 입력 순서 유지
           if (map.get(o1) == map.get(o2)) {
               return arr.indexOf(o1) - arr.indexOf(o2);
           } else { // 빈도수 다를 경우 빈도수 기준으로 내림차순
               return Integer.compare(map.get(o2), map.get(o1));
           }
        });

        for (int i=0; i<n; i++) {
            System.out.print(arr.get(i)+ " ");
        }
    }
}
