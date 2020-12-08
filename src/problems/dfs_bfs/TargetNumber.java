package problems.dfs_bfs;

import problems.Problem;

/**
 * <타켓넘버/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43165
 * */
public class TargetNumber extends Problem {
    int answer = 0;

    @Override
    public void run() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(printAnswerFormat + solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;

//        return dfs2(0, 0, numbers, target);

//        answer = dfs3(numbers, 0, 0, target);
//        return answer;
    }

    /**
     * 깊이우선탐색 방법1 (재귀함수 사용)
     * 참고: https://jjjayyy.tistory.com/87
     * 재귀함수가 호출될때마다 합계를 구하기 때문에 배열이 길수록 계산시간은 많이 걸리지만 가장 이해하기 쉬운 코드
     * */
    private void dfs(int[] numbers, int target, int node) {
        if (node == numbers.length) {
            int sum = 0;
            for (int num : numbers) sum += num;
            if (sum == target) answer++;

        } else {
            numbers[node] *= 1;
            dfs(numbers, target, node + 1);

            numbers[node] *= -1;
            dfs(numbers, target, node + 1);
        }
    }


    /**
     * 깊이우선 탐색 방법1 (재귀함수 사용)
     * 참고: https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4
     * */
    private int dfs2(int prev, int index, int[] numbers, int target) {
        if (index >= numbers.length) {
            if (target == prev) {
                return 1;
            }
            return 0;
        }

        int cur1 = prev + numbers[index];
        int cur2 = prev - numbers[index];

        return dfs2(cur1, index + 1, numbers, target) +
                dfs2(cur2, index + 1, numbers, target);
    }

    /**
     * 프로그래머스에서 가장 추천이 많은 풀이
     * 마찬가지로 깊이우선 탐색을 사용했고 위와 같은 방식이다.
     * 하지만 더욱 간결하게 작성했다.
     * */
    private int dfs3(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs3(numbers, n + 1, sum + numbers[n], target)
                + dfs3(numbers, n + 1, sum - numbers[n], target);
    }
}
