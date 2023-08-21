package problems.dfs_bfs;

import problems.Problem;

import java.util.*;

/**
 * <네트워크/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43162
 * 난이도: Level 3
 */
public class Network extends Problem {
    @Override
    public void run() {
//        int n = 3; int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}}; // return = 2
//        int n = 3; int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}}; // return = 1
//        int n = 4; int[][] computers = {{1,1,0,0}, {1,1,0,0}, {0,0,1,1}, {0,0,1,1}}; // return = 2
//        int n = 4; int[][] computers = {{1,1,1,1}, {1,1,0,0}, {1,0,1,0}, {1,0,0,1}}; // return = 1
        int n = 5;
        int[][] computers = {{1, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {0, 0, 1, 1, 0}, {1, 1, 1, 1, 0}, {0, 1, 0, 0, 1}}; // return = 1
        printAnswer(solution(n, computers));
    }

    /**
     * <내 풀이/>
     * 처음에 완전히 잘못된 방법을 사용했다.
     * 아래는 stack을 사용한 DFS 방식의 풀이이다.
     * 풀이 과정을 완전히 설명할 수 없다면 구현할 수도 없다. 명심하자.
     * <p>
     * - 네트워크의 개수는 0부터 시작한다.
     * - 각 컴퓨터의 검사여부 확인을 위해 boolean[] 배열을 n개 만큼 생성한다.
     * - 현재 검사중인 컴퓨터와 연결된 컴퓨터가 나오면 stack에 추가한다.
     * - stack에 연결된 컴퓨터를 저장하고 끝까지 타고 들어가며 검사한다.
     * - 마지막 지점까지 도달했다면 하나의 네트워크를 탐색한 것이기 떄문에 네트워크의 개수를 추가한다.
     * - 이미 검사한 컴퓨터는 다시 검사하지 않는다.
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // 검사 여부를 확인할 목적으로 사용
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!check[i]) { // 검사 안한 항목만 진행
                check[i] = true;
                stack.push(i);

                while (!stack.isEmpty()) {
                    int target = stack.pop();
                    for (int j = 0; j < n; j++) {
                        if (i != j && computers[target][j] == 1 && !check[j]) {
                            stack.push(j);
                            check[j] = true;
                        }
                    }
                }

                answer++; // 끝까지 탐색했으면 네트워크 개수 추가
            }
        }

        return answer;
    }

    /**
     * <다른 사람의 풀이/>
     * 재귀함수를 이용한 풀이 방식이다.
     * 스택을 사용한 코드에 비해 간결한 장점이 있다.
     */
    public int solution2(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}
