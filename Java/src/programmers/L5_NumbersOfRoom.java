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
        
        
        // equals, hasCode 수완님꺼 보고 참고해서 override 하기
        // equals는 객체 비교할 때, 같은 값을 가지는 객체로 인식시켜주기 위해서는 반드시 구현해줘야한다.
        // 객체끼리 비교할 때는 equals를 써야하고 equals를 구현할 때 hasCode도 같이 써야한다

        // 예외로 dto같은 '값 객체'의 경우는 같은 값이 날라오더라도 다른 값으로
        // 인식을 해야되기 때문에 값 객체에서는 equals, hasCode를 사용하지 않아도 된다.

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
