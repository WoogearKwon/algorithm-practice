package problems.dfs_bfs;

import problems.Problem;

import java.util.Arrays;
import java.util.Stack;

/**
 * <타켓넘버/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43165
 * 난이도: Level2
 *
 * <문제설명/>
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * <제한사항/>
 * - 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * - 각 숫자는 1 이상 50 이하인 자연수입니다.
 * - 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 * */
public class TargetNumber extends Problem {
    int answer = 0;

    @Override
    public void run() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        printAnswer(solution2(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;

//        return dfs2(0, 0, numbers, target);

//        answer = dfs3(numbers, 0, 0, target);
//        return answer;
    }

    /**
     * <내 풀이/>
     * stack을 사용해서 풀어보기
     * */
    private int solution2(int[] numbers, int target) {
        int answer = 0;

        Stack<Integer> nodes = new Stack<>();
        Stack<int[]> stack = new Stack<>();

        nodes.push(0);
        stack.push(numbers);

        while (!nodes.isEmpty()) {
            int node = nodes.pop();
            int[] array = stack.pop();

            if (node == numbers.length) {
                int sum = 0;
                for (int n : array) sum += n;
                if (sum == target) answer++;

            } else {
                nodes.push(node + 1);
                stack.push(Arrays.copyOf(array, array.length));

                nodes.push(node + 1);
                array[node] *= -1;
                stack.push(array);
            }
        }

        return answer;
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
