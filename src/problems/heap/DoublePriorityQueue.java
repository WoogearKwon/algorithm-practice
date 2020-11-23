package problems.heap;

import problems.Problem;

import java.util.*;

/**
 * <이중우선순위큐/>
 * 문제 설명: 이중우선순위큐는 다음 연산을 할 수 있는 자료구조를 말한다.
 * I 숫자: 큐에 주어진 숫자를 삽압
 * D 1: 큐에서 최댓값을 삭제
 * D -1: 큐에서 최솟값을 삭제
 *
 * 이중우선순위큐가 수행할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0]
 * 비어있지 않으면 [최닷값, 최솟값]을 리턴하도록 solution함수를 구현하세요.
 *
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 *
 * <제한사항/>
 * - operations는 길이가 1 이상 1,000,000 이하인 문자열 배열
 * - operations의 원소는 큐가 수행할 연산을 나타냄
 * - 원소는 "명령어 데이터 형식으로 주어짐
 * - 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제한다.
 * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우 해당 연산은 무시
 *
 * */
public class DoublePriorityQueue extends Problem {
    @Override
    public void run() {
//        String[] operations = {"I 16", "D 1"}; // return = [0,0]
//        String[] operations = {"I 7","I 5","I -5","D -1"}; // return = [7,5]
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // return = [653,97]

        System.out.println(printAnswerFormat + Arrays.toString(solution(operations)));
    }

    /**
     * <내 풀이/>
     * 이 문제는 상당히 쉬웠다.
     * 1. 내림차순으로 저장할 큐와 오름차순으로 저장할 큐를 따로따로 생성한다.
     * 2. operations의 요소를 분석한다.
     * 3. I이면 값을 두 개의 큐에 삽입한다.
     * 4. D이면 음수인지 양수인지 구분해서 음수이면 최솟값을 삭제, 양수이면 최댓값을 삭제한다.
     * -- 최솟값은 queue에서, 최댓값은 reverseQueue에서 삭제한다.
     * 5. 큐가 비었으면 [0,0]을 리턴하고 아니면 각 큐의 값을 하나씩 poll하여 리턴한다.
     * */
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String e : operations) {
            String[] operation = e.split(" ");
            String type = operation[0];
            int number = Integer.parseInt(operation[1]);

            if (type.equals("I")) {
                queue.offer(number);
                reverseQueue.offer(number);
            } else {
                if (number > 0) {
                    queue.remove(reverseQueue.poll());
                } else {
                    reverseQueue.remove(queue.poll());
                }
            }
        }

        return queue.isEmpty() ? new int[]{0, 0} : new int[]{reverseQueue.poll(), queue.poll()};
    }
}
