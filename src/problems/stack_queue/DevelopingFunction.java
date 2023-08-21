package problems.stack_queue;

import problems.Problem;

import java.util.*;

/**
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * <p>
 * <기능 개발/>
 * 정수 배열 progresses는 개발중인 기능의 작업 진도
 * 정수 배열 speeds는 개발중인 기능의 작업 속도
 * 예) 93만큼 진행된 작업의 속도가 1이라면 완료되는데 7일이 걸림
 * 각 작업의 완료 일정이 담긴 배열이 {3, 10, 2} 라면, 배포 일정별 기능 수는 {1, 2}와 같다.
 */
public class DevelopingFunction extends Problem {
    @Override
    public void run() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5}; // return = {2,1}
//         int[] progresses = {95, 90, 99, 99, 80, 99};
//         int[] speeds = {1, 1, 1, 1, 1, 1}; // return = {1,3,3,1}

        printResult(solution(progresses, speeds));
    }

    /**
     * <내 풀이/>
     * 1. 배열을 순서대로 반복해 완료되는데 걸리는 시간(days)을 구한다.
     * 2. 구한 시간을 queue에 넣는다.
     * 3. 큐를 while문으로 값이 없을 때까지 반복한다.
     * 4. 큐에서 꺼낸 값들이 가장 앞에 있는 값보다 작으면 함께 배포한다.
     * 5. 새로 꺼낸 값이 가장 앞에 있는 값보다 크면 다음 배포 일정으로 넘어간다.
     * <p>
     * 첫 번째 시도: 27.3점
     * 두 번째 시도: 성공
     * 실수한 것: 매일 한 가지 기능씩 개발이 시작된다고 이해했다.
     * 예를 들어 10일 걸리는 일이 있고 그 다음 5일, 6일 걸리는 일이 있다면 6일 걸리는 일은 다음 일정에 배포해야한다고 생각했다.
     * 잘못 이해한 것이다. 5일, 6일 걸리는 일 모두 10일 이하이기 때문에 모두 함께 배포할 수 있다.
     * <p>
     * 사실 굳이 queue를 사용하지 않고 배열을 사용해도 되는 풀이과정이다.
     */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progressRemain = 100 - progresses[i];
            int days = progressRemain / speeds[i];
            if (progressRemain % speeds[i] != 0) days += 1;

            queue.add(days);
        }

        int deploySum = 0;
        int bigDays = 0;
        List<Integer> answers = new ArrayList<>();

        while (!queue.isEmpty()) {
            int days = queue.poll();

            // 새배포 일정 시작
            if (days > bigDays) {
                bigDays = days;

                // 이전에 계산된 일정을 답안에 추가
                if (deploySum != 0) answers.add(deploySum);
                deploySum = 1;

                // 마지막 값인 경우 답안에 추가
                if (queue.isEmpty()) {
                    answers.add(1);
                }
            } else {

                // 배포 개수 ++
                deploySum++;
                // 마지막 값인 경우 답안에 추가
                if (queue.isEmpty()) {
                    answers.add(deploySum);
                }
            }
        }

        return answers.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 다른 사람의 풀이
     * 내 코드와 비교해봐라.
     * 얼마나 간결한 코드인가.
     */
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }
}
