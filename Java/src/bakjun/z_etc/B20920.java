package bakjun.z_etc;

import java.util.*;

public class B20920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = sc.next();
            if (s.length()>= M) {
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
//        Collections.sort(map);
    }
}
