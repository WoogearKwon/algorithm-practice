package problems.heap;

import problems.Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <디스크 컨트롤러/>
 * 문제 설명: 작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
 * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
 * return하는 solution함수를 작성해주세요.
 * (단, 소수점 이하의 수는 버린다.)
 * <p>
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * <p>
 * <제한 사항/>
 * - jobs의 길이는 1 이상 500 이하
 * - jobs의 길이는 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간]이다.
 * - 각 작업에 대해 작업이 요청되는 시간은 0 이상, 1,000이하
 * - 각 작업에 대해 작업의 소요시간은 1 이상, 1,000이하
 * - 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리
 */
public class DiskController extends Problem {
    @Override
    public void run() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; // return = 9
        printResult(solution(jobs));
    }

    /**
     * 첫 풀이 시도는 실패
     * 레벨3은 아직 어려운가보다.
     * 대략 방법은 알겠으나 코드로 옮기질 못했다.
     * 문제의 정확한 이해와 집중력이 부족했다.
     * 아래의 링크를 참고해 약간 수정했다.
     * https://codevang.tistory.com/316
     * <p>
     * 1. 요청시간부터 종료까지 가장 짧게 배치하기 위해서는 수행시간이 짧은 작업부터 처리해야 한다.
     * 2. 그러나 무작정 요청시간이 짧은 작업을 먼저 처리하는 것이 아니라, 하나의 작업이 끝나는 시점까지
     * 들어온 요청 중 가장 짧은 작업을 선택해야 한다. 즉 우선순위를 계산해야 한다.
     */
    public int solution(int[][] jobs) {
        int answer = 0; // 처리되는데 걸린 누적 시간
        int duration = 0; // 현재까지 소요 시간
        int jobIndex = 0; // jobs배열의 인덱스
        int count = 0; // 처리된 작업 수

        // 요청시간 기준으로 원본 배열을 오름차순 정렬
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));

        // 처리시간을 기준으로 오름차순으로 정렬하는 PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (count < jobs.length) {

            while (jobIndex < jobs.length && jobs[jobIndex][0] <= duration) {
                pq.offer(jobs[jobIndex++]);
            }

            if (pq.isEmpty()) {
                // 큐가 비어있다면 작업이 처리된 후에 새로운 요청이 들어옴
                // duration을 다음 작업의 시작시점으로 맞춤
                duration = jobs[jobIndex][0];

            } else {
                // 큐에 작업이 있다면 가장 수행시간이 짧은 요청부터 처리
                int[] temp = pq.poll();
                answer += temp[1] + duration - temp[0];
                duration += temp[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
}
