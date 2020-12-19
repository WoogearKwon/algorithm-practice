package problems.dfs_bfs;

import problems.Problem;

/**
 * <단어 변환/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 * 난이: Level 3
 * */
public class ConvertingWord extends Problem {

    @Override
    public void run() {
        String begin = "hit"; String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // return = 3

        printAnswer(solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        return answer;
    }
}
