package problems.brute_force;

import problems.Problem;

import java.util.Arrays;

/**
 * <카펫/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/42842
 * */
public class Carpet extends Problem {
    @Override
    public void run() {
//        int brown = 10; int yellow = 2; // return [4,3];
//        int brown = 8; int yellow = 1; // return [3,3];
        int brown = 24; int yellow = 24; // return [8,6];

        printAnswer(solution(brown, yellow));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        // frame = (2 x horizontal) + (2 x vertical)
        int frame = brown - 4; // 네 모서리의 한 칸씩을 뺀 나머지

        for (int vertical = 1; vertical <= frame / 4; vertical++) {
            if (yellow % vertical == 0) {
                int horizontal = yellow / vertical;

                int check = (2 * horizontal) + (2 * vertical);
                if (frame == check) {
                    answer[0] = 2 + horizontal;
                    answer[1] = 2 + vertical;
                    break;
                }
            }
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이
     * for문 없이 문제를 풀었다.
     * */
    public int[] solution2(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = yellow + 2 * a - 4;

        double sqrt = Math.sqrt(a * a - 4 * b);
        int x = (int)(a + sqrt) / 2;
        int y = (int)(a - sqrt) / 2;

        return new int[]{x, y};
    }
}
