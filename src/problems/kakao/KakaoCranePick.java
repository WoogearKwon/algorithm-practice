package problems.kakao;

import problems.Problem;

import java.util.*;

/**
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * */
public class KakaoCranePick extends Problem {
    private int number;

    public KakaoCranePick(int number) {
        super(number);
        this.number = number;
    }

    @Override
    public void run() {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    // My solution
    private int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> box = new Stack<>();

        for (int move : moves) {
            int x = move - 1;
            int y = getY(board, x);

            if (y != -1) {
                int target = board[y][x];

                if (target != 0) {
                    box.push(target);
                    board[y][x] = 0;

                    if (box.size() >= 2) {
                        int lp = box.size() - 1;

                        if (box.get(lp).equals(box.get(lp - 1))) {
                            box.pop();
                            box.pop();
                            answer += 2;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private int getY(int[][] board, int x) {
        int y = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][x] != 0) {
                y = i;
                break;
            }
        }
        return y;
    }

    // 추천수가 높은 다른 사람의 풀이(홍희표, 김재용)
    private int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
