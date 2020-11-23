package problems.heap;

import problems.Problem;

import java.util.*;

/**
 * <디스크 컨트롤러/>
 * 문제 설명: [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
 * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
 * return하는 solution함수를 작성하라
 *
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 *
 * */
public class DiskController extends Problem {
    @Override
    public void run() {
        int[][] jobs = {{0,3}, {1,9}, {2,6}}; // return = 9
        System.out.println(printAnswerFormat + solution(jobs));
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int duration = 0; // 현재 처리중인 시간
        int jobPosition = 0;
        int count = 0; // 처리된 작업 수

        // 요청시간 기준으로 배열 오름차순 정렬
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));

        // 처리시간을 기준으로 오름차순으로 정렬하는 PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // while문이 한 번 반복 될 때마다 처리시간 1 증가
        while (count < jobs.length) {

            while (jobPosition < jobs.length && jobs[jobPosition][0] <= duration) {
                pq.offer(jobs[jobPosition++]);
            }

            if (pq.isEmpty()) {
                // 큐가 비어있다면 작업이 처리된 후에 새로운 요청이 들어옴
                // duration을 다음 작업의 시작시점으로 맞춤
                duration = jobs[jobPosition][0];

            } else {
                // 큐에 작업이 있다면 가장 수행시간이 짧은 요청부터 처리
                int[] temp = pq.poll();
                answer += temp[1] + duration - temp[0];
                duration += temp[1];
                count ++;
            }
        }

        return answer / jobs.length;
    }
}
