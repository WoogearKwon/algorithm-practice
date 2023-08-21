package problems.stack_queue;

import problems.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * <p>
 * <다리를 지나는 트럭/>
 */
public class PassingTrucks extends Problem {

    private static class TruckTestCase {
        int bridge_length; // 다리 길이
        int bridge_weight; // 다리가 견디는 무게
        int[] truck_weights; // 다리를 건널 트럭들의 무게

        public TruckTestCase(int bridge_length, int bridge_weight, int[] truck_weights) {
            this.bridge_length = bridge_length;
            this.bridge_weight = bridge_weight;
            this.truck_weights = truck_weights;
        }
    }

    @Override
    public void run() {
        // 입출력 예시
        List<TruckTestCase> truckTestCases = new ArrayList<>();
        truckTestCases.add(new TruckTestCase(2, 10, new int[]{7, 4, 5, 6})); // return 8
        truckTestCases.add(new TruckTestCase(100, 100, new int[]{10})); // return 101
        truckTestCases.add(new TruckTestCase(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); // return 110
        TruckTestCase truckTestCase = truckTestCases.get(0);

        printResult(solution(truckTestCase.bridge_length, truckTestCase.bridge_weight, truckTestCase.truck_weights));
    }

    /**
     * <내 풀이/>
     * while 문이 한번 반복될 때 1초가 흐르고,
     * 다리 위의 트럭은 1만큼 앞으로 전진
     * 그래서 매 1초마다 아래의 항목들을 수행한다.
     * 1. answer + 1
     * 2. 다리위 트럭이 하나도 없으면 종료한다.
     * 3. 다리위 트럭들의 무게의 합을 구한다.
     * 4. 다리위 트럭의 위치 +1
     * 5. 다리의 무게에 여유가 있으면 새로운 트럭이 건너기 시작한다.
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> waitingTrucks = new LinkedList<>();
        Queue<Truck> passingTrucks = new LinkedList<>();

        for (int w : truck_weights) waitingTrucks.offer(w);

        while (true) {
            if (passingTrucks.isEmpty()) {
                // 모든 트럭이 건넜으면 반복문 종료
                if (waitingTrucks.isEmpty()) break;
                else passingTrucks.offer(new Truck(waitingTrucks.poll(), 0));

            } else {
                int totalWeight = 0;
                // 다리 위의 트럭을 1만큼 전진
                for (Truck truck : passingTrucks) {
                    truck.position++;
                    totalWeight += truck.weight;
                }

                // 모두 건넌 트럭은 제외
                if (passingTrucks.peek().position == bridge_length) {
                    totalWeight -= passingTrucks.peek().weight;
                    passingTrucks.poll();
                }

                // 대기중인 트럭이 아직 있고 다리 위 무게 여유가 있다면 건너기 시작
                if (!waitingTrucks.isEmpty() && waitingTrucks.peek() + totalWeight <= weight)
                    passingTrucks.offer(new Truck(waitingTrucks.poll(), 0));
            }

            answer++;
        }

        return answer;
    }

    private static class Truck {
        int weight;
        int position;

        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }
}
