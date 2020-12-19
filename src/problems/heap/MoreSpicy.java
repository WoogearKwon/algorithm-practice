package problems.heap;

import problems.Problem;

import java.util.PriorityQueue;

/**
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * <더 맵게/>
 * 모든 음식의 스코빌 지수를 K이상으로 만들려고 한다.
 * 그러기 위해 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같은 방법으로 섞어 새로운 음식을 만든다.
 * 새로운 움식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 그 다음으로 맵지 않은 음식의 스코빌지수 * 2
 *
 * 모든 음식의 스코빌 지수가 K이상이 될 때까지 반복하여 섞는다.
 * 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를
 * K이상으로 만들기 위해 섞어야 하는 최소 횟수를 return하도록 solution함수를 작성하라.
 *
 * <제한 사항/>
 * scoville의 길이는 2 이상, 1,000,000 이하
 * K는 0이상 1,000,000,000 이하
 * scoville의 원소는 각각 0 이상, 1,000,000 이하
 * 모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우에는 -1을 리턴턴
  */
public class MoreSpicy extends Problem {
    @Override
    public void run() {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7; // answer = 2
        printAnswer(solution(scoville, k));
    }

    /**
     * <내 풀이/>
     * 1. scoville 값을 PriorityQueue queue에 넣는다.
     * 2. queue의 값에 k이하인 값이 있는지 확인한다.
     * 3. 있으면 가장 맵지 않은 두 값을 섞는다.
     * 4. 없으면 리턴한다.
     * 5. 없을때까지 2-3을 반복한다.
     * 6. queue에 값이 하나 남았고 k보다 작다면 -1을 리턴한다.
     * */
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) queue.offer(s);

        while (true) {
            boolean hasSmallerThanK = false;

            // k보다 작은수가 있는지 확인, 있으면 for문 종료
            for (int value : queue) {
                if (value < K) {
                    hasSmallerThanK = true;
                    break;
                }
            }

            if (hasSmallerThanK) {
                // queue에 남은 값이 2개 이상이면 섞기
                if (queue.size() >= 2) {
                    queue.offer(queue.poll() + (queue.poll() * 2));
                    answer++;

                // queue에 남은 값이 1개이고 k보다 작다면 -1 리턴
                } else {
                    return -1;
                }

            // queue에 남은 값중에 k보다 작은 값이 없다면 answer리턴
            } else {
                return answer;
            }
        }
    }

    /**
     * <다른 사람의 풀이 1/>
     * 방법은 내 풀이와 비슷하지만 더 간결하다.
     * */
    public int solution2(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }

    /**
     * <다른 사람의 풀이 2/>
     * 더 간결한 코드다.
     * */
    public int solution3(int[] scoville, int K) {
        PriorityQueue<Integer> pqScov = new PriorityQueue<>();
        for (int s: scoville) {
            pqScov.add(s);
        }

        int cnt = 0;
        while (pqScov.size() > 1 && pqScov.peek() < K) {
            pqScov.add(pqScov.remove() + pqScov.remove() * 2);
            cnt++;
        }

        return pqScov.peek() >= K ? cnt : -1;
    }
}
