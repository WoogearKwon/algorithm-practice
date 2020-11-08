package problems.stack;

import problems.Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 *
 * <주식 가격/>
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성
 *
 * <제한 사항/>
 * prices의 각 가격은 1 이상 10,000이하의 자연수
 * prices의 길이는 2 이상, 100,000 이하하
 * * */
public class StockPrice extends Problem {
    @Override
    public void run() {
        int[] prices = {1, 2, 3, 2, 3}; // return = [4,3,1,1,0]

        System.out.println(printAnswerFormat + Arrays.toString(solution(prices)));
    }

    /**
     * 1. 큐에 모든 배열의 수를 차례로 저장
     * 2. 큐의 값이 없을 때까지 반복문 while 실행
     * 2. 큐의 값을 하나씩 빼서 배열의 다음 칸 수를 차례로 비교
     * 3. 비교한 값보다 큐에서 나온 값이 크면 for문 종료
     * 4. 그렇지 않다면 answer +1
     * */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) queue.add(price);

        while (!queue.isEmpty()) {
            int price = queue.poll();
            for (int i = prices.length - queue.size(); i < prices.length; i++) {
                answer[prices.length - queue.size() - 1] ++;
                if (price > prices[i]) break;
            }
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이
     * - 내 풀이와 완전히 같은 방식이지만 Queue를 사용하지 않고 간단하게 구현이 가능하다.
     * */
    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
