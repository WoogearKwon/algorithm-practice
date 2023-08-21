package problems.sort;

import problems.Problem;

import java.util.Arrays;

/**
 * H-Index
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex extends Problem {
    @Override
    public void run() {
        int[] citations = {3, 0, 6, 1, 5};

        printAnswer(solution(citations));
    }

    // 발표한 논문 n편 중 h번 이상 인용된 논문이 h편 이상이고,
    // 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
    // 따라서 h값을 찾으면 됨
    // 1. h는 전체 논문수인 citation.length보다 작거나 같음
    // 2. h가 전체 논문수에서 1씩 감소하면서 비교하기
    // 3. h보다 인용된 횟수가 작다면 성립할 수 없음
    // 4. 따라서 h보다 인용된 횟수가 크거나 같아야 함.
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
