package bakjun.string;

import java.util.*;
import java.util.stream.Collectors;

public class B20920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> words = new HashMap();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (word.length() < m) continue;

            words.put(word, words.getOrDefault(words.get(word), 0)+1);
        }

        List<String> list = words.keySet().stream().collect(Collectors.toList());

        list.sort((o1, o2) -> {
           int c1 = words.get(o1); 
           int c2 = words.get(o2);
           
           if (c1 == c2) { // 빈도가 같은 경우
               if (o1.length() == o2.length()) {
                   return o1.compareTo(o2); // 사전순으로 앞에
               }
               return o2.length()-o1.length(); // 길이가 길면 앞에
           }

           return c2-c1; // 자주 나오는 단어면 앞에
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);


    }
}
