package problems.dfs_bfs;

import problems.Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [게임 맵 최단거리]
 * Programmers link: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java"/>
 */

public class GameMapShortestDistance extends Problem {
    @Override
    public void run() {
        Case testCase = cases.get(1);

        int result = solution2(testCase.maps);
        int answer = testCase.answer;

        printResult(result);
        System.out.println("answer is " + answer);
    }

    /**
     * BFS 풀이방식
     */
    public int solution2(int[][] maps) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        int[][] distances = new int[maps[0].length][maps.length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        distances[0][0] = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > maps[0].length - 1 || ny > maps.length - 1) {
                    continue;
                }

                if (distances[nx][ny] == 0 && maps[ny][nx] == 1) {
                    distances[nx][ny] = distances[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int distance = distances[maps[0].length - 1][maps.length - 1];

        return distance == 0 ? -1 : distance;
    }

    /**
     * 아래의 방법(DFS)으로 문제 풀이는 통과했으나 효율성 테스트에서 4개 모두 시간초과로 실패
     * 최단거리를 구하는 문제이므로 DFS 보다 BFS가 적절
     */
    private int distance = 0;
    private int[][] maps;
    private boolean[][] visited;

    public int solution1(int[][] maps) {
        this.maps = maps;

        visited = new boolean[maps.length][maps[0].length];

        dfs(1, 0, 0, maps.length - 1, maps[0].length - 1);

        if (distance == 0) {
            return -1;
        } else {
            return distance;
        }
    }

    private void dfs(int count, int x, int y, int mX, int mY) {
        if (x < 0 || y < 0 || x > mX || y > mY) return;
        if (maps[x][y] == 0) return;
        if (visited[x][y]) return;

        if (x == mX && y == mY) {
            distance = (distance == 0) ? count : Math.min(distance, count);
            return;
        }

        visited[x][y] = true;
        dfs(count + 1, x - 1, y, mX, mY);
        dfs(count + 1, x + 1, y, mX, mY);
        dfs(count + 1, x, y - 1, mX, mY);
        dfs(count + 1, x, y + 1, mX, mY);
        visited[x][y] = false;
    }

    private class Case {
        int[][] maps;
        int answer;

        public Case(int[][] maps, int answer) {
            this.maps = maps;
            this.answer = answer;
        }
    }

    private final List<Case> cases = Arrays.asList(
        new Case(
            new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
            },
            11
        ),
        new Case(
            new int[][]{
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1}
            },
            12
        )
    );
}
