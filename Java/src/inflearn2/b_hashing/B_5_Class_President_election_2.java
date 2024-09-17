package inflearn2.b_hashing;

import java.util.*;
public class B_5_Class_President_election_2 {
    public String solution(String[] votes, int k) {
        String answer = " ";

        HashMap<String, HashSet<String>> voteHash = new HashMap<>(); // 투표자, 투표한 리스트
        HashMap<String, Integer> candidate = new HashMap<>(); // 출마자, 득표
        HashMap<String, Integer> present = new HashMap<>(); // 받은 선물 갯수

        // 1. 투표 목록 정리
        for (String vote : votes) {
            String a = vote.split(" ")[0];
            String b = vote.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }

        // 2. 득표수 넘는 사람 있으면 투표자 선물 갯수 표기
        int max = 0;
        for (String a : voteHash.keySet()) {
            int cnt = 0;
            HashSet<String> voteHashValues = voteHash.get(a);
            for (String b : voteHashValues) {
                if (candidate.getOrDefault(b, 0) >= k) {
                    cnt++;
                }
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        // 3. 최대 득표자 정리
        ArrayList<String> arr = new ArrayList<>();
        for (String a : present.keySet()) {
            if (present.getOrDefault(a, 0) == max) {
                arr.add(a);
            }
        }

        Collections.sort(arr);
        answer = arr.get(0);

        return answer;
    }

    public static void main(String[] args) {
        B_5_Class_President_election_2 T = new B_5_Class_President_election_2();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
        // daniel
        // john
        // cody
        // luis
    }
}
