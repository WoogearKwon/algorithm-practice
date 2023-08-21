package problems.dfs_bfs;

import problems.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [게임 맵 최단거리]
 * Programmers link: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java"/>
 * */

public class GameMapShortestDistance extends Problem {
    private int[][] maps;
    private List<Integer> counts = new ArrayList<>();
    private boolean[][] visited;


    @Override
    public void run() {
        Case testCase = cases.get(0);

        int y = testCase.maps.length;
        int x = testCase.maps[0].length;
        visited = new boolean[x][y];
        maps = testCase.maps;

        int result = solution(testCase.maps);
        int answer = testCase.answer;

        printAnswer(result);
        System.out.println("answer is " + answer);
    }

    public int solution(int[][] maps) {
        visited[0][0] = true;
        dfs(1, 0, 0, maps[0].length - 1, maps.length - 1);

        if (counts.isEmpty()) return -1;

        Collections.sort(counts);

        return counts.get(0);
    }

    private void dfs(int count, int x, int y, int mX, int mY) {
        if (x < 0 || y < 0 || x > mX || y > mY) {
            return;
        }

        if (maps[x][y] == 0) return;
        if (visited[x][y]) return;

        if (x == mX && y == mY) {
            counts.add(count);
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

    private final List<Case> cases = Collections.singletonList(
            new Case(
                    new int[][]{
                            {1, 0, 1, 1, 1},
                            {1, 0, 1, 0, 1},
                            {1, 0, 1, 1, 1},
                            {1, 1, 1, 0, 1},
                            {0, 0, 0, 0, 1}
                    },
                    1
            )
    );
}
