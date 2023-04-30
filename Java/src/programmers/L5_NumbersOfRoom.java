package programmers;

import java.util.*;

public class L5_NumbersOfRoom {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static int solution(int[] arrows) {

        int cnt = 0;

        Pair location = new Pair(0, 0);
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        HashMap<Pair, ArrayList<Pair>> visited = new HashMap<>();

        for(int arrow : arrows) {
            for(int i=0; i<=1; i++) {
                Pair newLocation = new Pair(location.x + dx[arrow], location.y + dy[arrow]);

                // 처음 방문하는 경우
                if (!visited.containsKey(newLocation)) {
                    // 리스트에 연결점 추가
                    visited.put(newLocation, makeEdgeList(location));

                    // 직전 방문지점 추가해주기
                    if (visited.get(location) == null) { // 직전 간선이 없다면
                        visited.put(newLocation, makeEdgeList(location));
                    } else {
                        visited.get(location).add(newLocation);
                    }
                } else if (visited.containsKey(newLocation) && visited.get(newLocation).contains(location)){ // 방문한 경우
                    visited.get(newLocation).add(location);
                    visited.get(location).add(newLocation);
                    cnt++;
                }

                // 이동 완료
                location = newLocation;
            }

        }


        return cnt;
    }

    public static ArrayList<Pair> makeEdgeList(Pair location) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(location);
        return edge;
    }

    // 1. 좌표 움직이기
    // 2. 겹치는 경우 영역 생성
    // 3. 이전에 방문했던 곳과 같은 곳 방문시는 영역 생성 x

}
