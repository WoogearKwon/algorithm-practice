package problems.dfs_bfs;

import problems.Problem;

import java.util.Arrays;
import java.util.List;

/**
 * [게임 맵 최단거리]
 * Programmers link: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java"/>
 */

public class GameMapShortestDistance extends Problem {
    private int distance = 0;
    private int[][] maps;
    private boolean[][] visited;

    @Override
    public void run() {
        Case testCase = cases.get(1);

        int result = solution1(testCase.maps);
        int answer = testCase.answer;

        printResult(result);
        System.out.println("answer is " + answer);
    }

    /**
     * 아래의 방법으로 문제 풀이는 가능하나 효율성 테스트에서 4개 모두 시간초과로 실패
     * */
    public int solution1(int[][] maps) {
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length];

        dfs1(1, 0, 0, maps.length - 1, maps[0].length - 1);

        if (distance == 0) {
            return -1;
        } else {
            return distance;
        }
    }

    private void dfs1(int count, int x, int y, int mX, int mY) {
        if (x < 0 || y < 0 || x > mX || y > mY) return;
        if (maps[x][y] == 0) return;
        if (visited[x][y]) return;

        System.out.println("dfs,,count = " + count + "..." + x + "," + y);

        if (x == mX && y == mY) {
            distance = (distance == 0) ? count : Math.min(distance, count);
            return;
        }

        visited[x][y] = true;
        dfs1(count + 1, x - 1, y, mX, mY);
        dfs1(count + 1, x + 1, y, mX, mY);
        dfs1(count + 1, x, y - 1, mX, mY);
        dfs1(count + 1, x, y + 1, mX, mY);
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
