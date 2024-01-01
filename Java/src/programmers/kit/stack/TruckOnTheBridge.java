package programmers.kit.stack;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(TruckOnTheBridge.solution(bridge_length, weight, truck_weights)); // 8
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTimes = 0;

        int currentWeight = 0;
        int times = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<truck_weights.length; i++) {
            int currentTruck = truck_weights[i];
            while (true) {
                // 트럭이 다리 끝에 도달했을 때
                if (!q.isEmpty() && q.size() == bridge_length) {
                    currentWeight -= q.poll();
                }

                // 현재 트럭을 싣을 수 있을 때
                if (currentWeight + currentTruck <= weight) {
                    q.offer(currentTruck);
                    currentWeight += currentTruck;
                    times++;
                    break;
                } else { // 트럭을 싣을 수 없을 때
                    q.offer(0);
                    times++;
                }
            }
        }

        totalTimes = times + bridge_length; // 걸린시간 + 마지막 트럭 건너는 시간 합쳐줌
        return totalTimes;
    }
}
