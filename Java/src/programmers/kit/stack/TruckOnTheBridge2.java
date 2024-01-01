package programmers.kit.stack;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge2 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(TruckOnTheBridge2.solution(bridge_length, weight, truck_weights)); // 8
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTimes = 0;
        Queue<Integer> bridge = new LinkedList<>();

        // 다리 길이 만큼의 q 만들기
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }

        int truckIndex = 0;
        int trucksWeight = 0;
        while(truckIndex < truck_weights.length) {
            // 다리 지나는 트럭은 빼주기
            trucksWeight -= bridge.poll();
            
            int currentTruckWeight = truck_weights[truckIndex];
            // 더 싣을 수 있는 경우
            if (trucksWeight + currentTruckWeight <= weight) {
                bridge.add(currentTruckWeight);
                trucksWeight += currentTruckWeight;
                truckIndex++;
            }
            // 더 못 싣는 경우
            else {
                bridge.add(0); // 트럭이 1초씩 지나가는 모습
            }

            // 시간 증가
            totalTimes++;
        }

        // 위 코드까지 진행 시 마지막 트럭이 타는 순간 대상이 다음 트럭이 되는데
        // 다음 트럭이 없어서 index를 잡는 순간 while문이 종료되어
        // 마지막 트럭이 건너는 시간을 더해줘야함
        totalTimes += bridge_length;
        return totalTimes;
    }
}
