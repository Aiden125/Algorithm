package programmers;

import java.util.HashMap;

public class L1_RunningGame {
    public static void main(String[] args) {

    }

    public String[] solution(String[] players, String[] callings) {
        // 플레이어 = mumu, soe, poe, kai
        HashMap<String, Integer> pl = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            pl.put(players[i], i);
        }

        for(int i=0; i<callings.length; i++) {
            String callPl = callings[i]; // 앞서갈 선수
            int callIndex = pl.get(callPl); // 불린 선수 원래 등수
            String outPl = players[callIndex-1]; // 밀린 선수 이름

            players[callIndex] = outPl;
            players[callIndex-1]= callPl;

            pl.put(callPl, pl.get(callPl)-1);
            pl.put(outPl, pl.get(outPl)+1);
        }
        return players;
    }
}
