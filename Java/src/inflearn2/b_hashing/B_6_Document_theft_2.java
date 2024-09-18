package inflearn2.b_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Info implements Comparable<Info>{
    String name;
    int time;

    Info(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(Info ob) {
        return this.time - ob.time; // 순서를 바꿀지 묻는 return
    }
}
public class B_6_Document_theft_2 {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return (H*60) + M;
    }

    public String[] solution(String[] reports, String times) {
        String[] answer = {};
        ArrayList<Info> tmp = new ArrayList<>();
        for (String x : reports) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp); // Comparable 구현해줘야만 사용 가능

        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);

        ArrayList<String> res = new ArrayList<>();
        for (Info ob : tmp) {
            if (ob.time >= s && ob.time <= e) {
                res.add(ob.name);
            }
            if (ob.time > e) break;
        }

        answer = new String[res.size()];
        for (int i=0; i<res.size(); i++) {
            answer[i] = res.get(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        B_6_Document_theft_2 T = new B_6_Document_theft_2();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
        // luis daniel
        // john bill bob
        // cody daniel tom
    }


}
