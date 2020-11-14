package problems.stack_queue;

import problems.Problem;

import java.util.*;

/**
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 * <프린터/>
 * 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했다.
 * 이 프린터는 아래와 같은 방식으로 인쇄 작업을 수행한다.
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대깁목록에서 꺼낸다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록 가장 뒤로 이동한다.
 * 3. 그렇지 않으면 J를 인쇄한다.
 *
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶다.
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를
 * 알려누는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성하라.
 *
 * <제한사항/>
 * - 현재 대기목록에는 1개 이상 100개 이하의 문서가 있다.
 * - 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻이다.
 * - location은 0이상 (현재 대기목록에 있는 작업수 -1) 이하의 갑승ㄹ 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현한다.
 * */
public class Printer extends Problem {
    private static class PrintingListCase {
        int[] priorities; // 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열
        int location; // 내가 안쇄를 요청한 문서의 현재 대기목록 위치 (0부터 시작)

        public PrintingListCase(int[] priorities, int location) {
            this.priorities = priorities;
            this.location = location;
        }
    }

    @Override
    public void run() {
        List<PrintingListCase> testCases = new ArrayList<>();
        testCases.add(new PrintingListCase(new int[]{2, 1, 3, 2}, 2)); // return 1
        testCases.add(new PrintingListCase(new int[]{1, 1, 9, 1, 1, 1}, 0)); // return 5
        PrintingListCase myCase = testCases.get(1);

        System.out.println(printAnswerFormat + solution(myCase.priorities, myCase.location));
    }

    /**
     * <내 풀이/>
     * 1. priorities의 값을 뒤로 이동하기 편하도록 Queue에 넣는다.
     * 2. 우선순위가 높은 문서들을 먼저 처리하기 위해서 우선순위 높은 순서대로 정렬하여 Tree에 담는다.
     * 3. Tree의 값이 없을 때까지 while문으로 반복하면서 우선순위가 높은 문서는 인쇄하고 낮은 문서는 뒤로 보낸다.
     * 4. 내 문서보다 우선순위가 높은 문서가 없다면 이제는 내 문서의 위치가 0일 때 문서를 인쇄하고 반복문을 종료한다.
     * */
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> printOrder = new LinkedList<>(); // Queue에 우선순위 순서 저장
        Map<Integer, Integer> countMap = new HashMap<>(); // Map<우선순위, 개수>

        for (int p : priorities) {
            printOrder.offer(p);
            if (p >= priorities[location]) countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }

        TreeMap<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());
        countMap.forEach(tree::put); // countMap을 오름차순으로 정렬하기 위해 tree에 삽입

        while (!tree.isEmpty()) {
            int firstKey = tree.firstEntry().getKey();

            if (!printOrder.element().equals(firstKey)) {
                printOrder.offer(printOrder.poll());
            } else {
                answer++;
                printOrder.poll();
                tree.put(firstKey, tree.get(firstKey) - 1);

                if (tree.get(firstKey) <= 0) tree.remove(firstKey);
                if (location == 0) break;
            }

            location = location == 0 ? printOrder.size() - 1 : location - 1;
        }

        return answer;
    }

    /**
     * <다른 사람의 풀이/>
     * 나는 정렬을 위해 Tree구조를 사용했는데, 굳이 그럴 필요가 없었다.
     * 배열을 그냥 정렬해서 비슷한 방식으로 풀 수 있었다.
     * */
    public int solution2(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities) que.add(i);

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while (!que.isEmpty()) {
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                location--;

                if(location < 0) break;
            } else {
                que.add(i);
                location--;

                if(location < 0) location = que.size()-1;
            }
        }

        return answer;
    }
}
