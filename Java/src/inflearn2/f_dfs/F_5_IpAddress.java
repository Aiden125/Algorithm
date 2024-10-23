package inflearn2.f_dfs;

import java.util.*;
public class F_5_IpAddress {
    ArrayList<String> room;
    ArrayList<String> arr;
    public String[] solution(String s){
        String[] answer = {};

        room = new ArrayList<>();
        arr = new ArrayList<>();

        DFS(0, s);

        answer = new String[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    void DFS(int startIndex, String s) {
        if (startIndex > s.length() && room.size() == 4) {
            String xs = String.join(".", room);
            arr.add(xs);
        }

        for (int end=startIndex; end<s.length(); end++) {
            String targetS = s.substring(startIndex, end);
            if (targetS.length() > 3 || targetS.length() == 0) continue;
            if (targetS.length() > 1 && targetS.charAt(0) == '0') continue;

            int x = Integer.parseInt(targetS);
            if (x < 0 || x > 255) continue;

            room.add(String.valueOf(x));
            DFS(end + 1, s);
            room.remove(room.size()-1);
        }
    }

    public static void main(String[] args){
        F_5_IpAddress T = new F_5_IpAddress();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
        /**
         * 20.25.50.5, 20.255.0.5, 202.5.50.5, 202.55.0.5
         * 0.0.0.0
         * 25.50.0.3, 255.0.0.3
         * []
         * 4개의 정답
         * 9개의 정답
         */
    }
}