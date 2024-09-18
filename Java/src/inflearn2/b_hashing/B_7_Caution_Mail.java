package inflearn2.b_hashing;

import java.util.*;

public class B_7_Caution_Mail {
    int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return (H * 60) + M;
    }
    public String[] solution(String[] reports, int time) {
        String[] answer = {};

        HashMap<String, Integer> current = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        // 1. in, out 계산
        for (String x : reports) {
            String name = x.split(" ")[0];
            String times = x.split(" ")[1];
            String inOut = x.split(" ")[2];


            int curTime = getTime(times);
            if (inOut.equals("in")) {
                current.put(name, curTime);
            } else {
                int inTime = current.get(name);
                int timeDiff = curTime - inTime;
                total.put(name, total.getOrDefault(name, 0) + timeDiff);
//                current.remove(name); // 어차피 덮어지기에 굳이 안해줘도 됨
            }
        }

        // 2. 최종 답 적고 sort
        ArrayList<String> res = new ArrayList<>();
        for (String x : total.keySet()) {
            int value = total.get(x);
            if (value > time) {
                res.add(x);
            }
        }

//        Collections.sort(res);
        res.sort((a, b) -> a.compareTo(b));
        answer = new String[res.size()];
        for (int i=0; i<res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        B_7_Caution_Mail T = new B_7_Caution_Mail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
        // daniel, john
        // daniel, luis
        // bill, cody
        // daniel, emilly
    }
}
