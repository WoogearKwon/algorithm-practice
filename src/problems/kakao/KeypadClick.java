package problems.kakao;

import problems.Problem;

/**
 * 키패드 누르기
 * Refer to link below
 * [https://programmers.co.kr/learn/courses/30/lessons/67256]
 */
public class KeypadClick extends Problem {
    @Override
    public void run() {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";  // reuslt = "LRLLLRLLRRL"
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left"; // result = "LRLLRRLLLRR"
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right"; // result = "LLRLLRLLRL"

        printAnswer(solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        boolean isRightHanded = hand.equals("right");

        int leftPositionX = 0;
        int leftPositionY = 3;

        int rightPositionX = 2;
        int rightPositionY = 3;

        for (int number : numbers) {
            // 왼쪽 1열 중 하나를 누르는 경우
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftPositionX = 0;
                leftPositionY = getY(number);

                // 오른쪽 1열 중에 하나를 누르는 경우
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightPositionX = 2;
                rightPositionY = getY(number);

                // 가운데 열 중에 하나를 누르는 경우
            } else {
                int y = getY(number);

                int distanceLeft = (1 - leftPositionX) + getDistanceY(y, leftPositionY);
                int distanceRight = (rightPositionX - 1) + getDistanceY(y, rightPositionY);

                // 오른쪽이 가까운 경우
                if (distanceLeft > distanceRight) {
                    answer.append("R");
                    rightPositionX = 1;
                    rightPositionY = y;

                    // 왼쪽이 가까운 경우
                } else if (distanceLeft < distanceRight) {
                    answer.append("L");
                    leftPositionX = 1;
                    leftPositionY = y;

                    // 타겟으로부터 왼손 오른손 거리가 같은 경우
                } else {

                    // 오른손잡이
                    if (isRightHanded) {
                        answer.append("R");
                        rightPositionX = 1;
                        rightPositionY = y;
                        // 왼손잡이
                    } else {
                        answer.append("L");
                        leftPositionX = 1;
                        leftPositionY = y;
                    }
                }
            }
        }

        return answer.toString();
    }

    private int getDistanceY(int a, int b) {
        return (a >= b) ? a - b : b - a;
    }

    private int getY(int number) {
        if (number == 0) return 3;
        if (number < 4) return 0;
        if (number < 7) return 1;
        return 2;
    }
}
