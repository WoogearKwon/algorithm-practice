package problems.dfs_bfs;

import problems.Problem;

/**
 * <단어 변환/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 * 난이: Level 3
 *
 * <문제 설명/>
 * 두 개의 단어 begin, target 과 단어의 집합 words 가 있다.
 * 아래와 같은 규칙을 이용해 begin 에서 target 으로 변환하는 가장 짧은 변환 과정을 찾으라.
 * - 한 번에 한 개의 알파벳만 바꿀 수 있다.
 * - words 에 있는 단어로만 변환할 수 있다.
 * */
public class ConvertingWord extends Problem {

    @Override
    public void run() {
        String begin = "hit"; String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // return = 4

        printAnswer(solution(begin, target, words));
    }

    private int answer = 51; // 최대 단어수 = 50

    /**
     * <내 풀이/>
     * target이 항상 맨 뒤에 있지 않을 수 있다.
     * 내 의도대로 문제가 풀리지 않아 다른 사람의 풀이를 참고했다.
     * checkList 배열을 사용해서 현재까지 진행한 위치의 단어는 확인하지 않게 한다.
     * */
    public int solution(String begin, String target, String[] words) {
        boolean[] checkList = new boolean[words.length];
        dfs(begin, target, words, 0, checkList);
        return answer == 51 ? 0 : answer;
    }

    private void dfs(String currentWord, String target, String[] words, int count, boolean[] checkList) {
        if (currentWord.equals(target)) {
            answer = Math.min(answer, count);
            System.out.println("count=" + count);
        } else {
            for (int i = 0; i < words.length; i++) {
                if (!checkList[i] && isOneWordDifferent(currentWord, words[i])) {
                    checkList[i] = true;
                    dfs(words[i], target, words, count + 1, checkList);
                    System.out.println("i=" + i + "  count=" + count + " cw=" + currentWord + "  next=" + words[i]);
                    checkList[i] = false;
                }
            }
        }
    }

    private boolean isOneWordDifferent(String word, String next) {
        int differentWords = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != next.charAt(i)) {
                differentWords ++;
                if (differentWords >= 2) break;
            }
        }
        return differentWords == 1;
    }
}
