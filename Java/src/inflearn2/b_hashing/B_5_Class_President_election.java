package inflearn2.b_hashing;

import java.util.*;
public class B_5_Class_President_election {
    public String solution(String[] votes, int k){
        String answer = " ";

        HashMap<String, Integer> getVotes = new HashMap<>();
        HashMap<String, Integer> getPresent = new HashMap<>();
        int max = -1;

        // 1. 투표 집계
        for (String vote : votes) {
            String getted = vote.split(" ")[1];
            getVotes.put(getted, getVotes.getOrDefault(getted, 0) + 1);
        }

        // 2. 선물 집계
        for (String vote : votes) {
            String getted = vote.split(" ")[1];
            String give = vote.split(" ")[0];
            if (getVotes.getOrDefault(getted, 0) >= k) {
                int currentCount = getPresent.getOrDefault(give, 0) + 1;
                getPresent.put(give, currentCount);
                max = Math.max(max, currentCount);
            }
        }

        // 3. 최종 1등 가리기
        ArrayList<String> member = new ArrayList<>();
        Iterator<String> it = getPresent.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            int value = getPresent.get(key);
            if (value == max) {
                member.add(key);
            }
        }
        Collections.sort(member);
        answer = member.get(0);

        return answer;
    }

    public static void main(String[] args){
        B_5_Class_President_election T = new B_5_Class_President_election();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2)); // daniel
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2)); // john
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2)); // cody
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3)); // luis
    }
}
