package inflearn2.a_simulation;

import java.util.*;
public class A_8_RoomMeeting_x {
    public int[] solution(int[] enter, int[] exit){
        int[] answer = new int[enter.length];

        // 정답 배열
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for (int i=0; i<enter.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            arr.add(set);
        }

        ArrayList<Integer> room = new ArrayList<>();
        int enterIndex = 0;
        int exitIndex = 0;

        room.add(enter[enterIndex]);
        enterIndex++;

        while (enterIndex < enter.length || exitIndex < exit.length) {

            // 나간애를 아직 못찾았다면 찾을때까지 넣어주기
            while (!room.contains(enter[enterIndex]) || enterIndex < enter.length) {
                room.add(enter[enterIndex]);
            }

            // 찾았을 때는 answer에 넣고 room에서 빼주기
            while (room.contains(enter[enterIndex])) {
                // answer에 저장
                for (int i=0; i<room.size(); i++) {
                    for (int j=i+1; j<room.size(); j++) {
                        int left = room.get(i);
                        int right = room.get(j);
                        arr.get(i).add(right);
                        arr.get(j).add(left);
                    }
                }

                // room에서 제거, enterIndex증가
                room.remove(Integer.valueOf(enter[enterIndex]));
            }

            Stack<Integer> stack = new Stack<>();


            enterIndex++;

            while (stack.peek() != exit[exitIndex] && enterIndex < enter.length) {
                stack.add(enter[enterIndex]);
                enterIndex++;
            }

            while (exitIndex < exit.length && stack.peek() == exit[exitIndex]) {
                // arr배열에 붙여주기
                for (int i=0; i<stack.size(); i++) {
                    for (int j=i+1; j<stack.size(); j++) {
                        int left = stack.get(i);
                        int right = stack.get(j);
                        arr.get(i).add(right);
                        arr.get(j).add(left);
                    }
                }

                stack.pop();
                exitIndex++;
            }
        }

        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i).size();
        }

        return answer;
    }

    public static void main(String[] args){
        A_8_RoomMeeting_x T = new A_8_RoomMeeting_x();
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3}, new int[]{3,2,1})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
