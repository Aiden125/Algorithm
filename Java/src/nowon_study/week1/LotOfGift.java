package nowon_study.week1;

import java.util.HashMap;

public class LotOfGift {
    public static void main(String[] args) {
//        String[] a1 = {"muzi", "ryan", "frodo", "neo"};
//        String[] b1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//        System.out.println(solution(a1, b1)); // expect: 2

        String[] a2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] b2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(a2, b2)); // expect: 4

//        String[] a3 = {"a", "b", "c"};
//        String[] b3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
//        System.out.println(solution(a3, b3)); // expect: 0

    }
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int fSize = friends.length;
        int[][] giftList = new int[fSize][fSize];
        int[] giftScore = new int[fSize];

        // 친구들 인덱스 잡아주기
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<fSize; i++) {
            map.put(friends[i], i);
        }

        // 선물 주고 받은 내역 정리
        for (int i=0; i<gifts.length; i++) {
            String[] gg = gifts[i].split(" ");
            String give = gg[0];
            String get = gg[1];

            int giveIndex = map.get(give);
            int getIndex = map.get(get);
            giftList[giveIndex][getIndex]++;
        }

        // 선물 지수 판단
        for (int i=0; i<fSize; i++) {
            for (int j=0; j<fSize; j++) {
                giftScore[i] += giftList[i][j] - giftList[j][i];
            }
        }

        int[] nextMonth = new int[fSize];
        // 다음 달 계산
        for (int i=0; i<fSize; i++) {
            for (int j=0; j<fSize; j++) {
                // 더 많이 준 경우
                if (giftList[i][j] > giftList[j][i]) {
                    nextMonth[i]++;
                } else if (giftList[i][j] == giftList[j][i] && i != j) {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++;
                    }
                }
            }
        }

        // 가장 많이 받는 갯수
        for (int i=0; i<fSize; i++) {
            answer = Math.max(answer, nextMonth[i]);
        }

        return answer;
    }
}
