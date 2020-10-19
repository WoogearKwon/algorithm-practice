package problems.kakao;

import problems.Problem;

/**
 * 키패드 누르기
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * */
public class KeypadClick extends Problem {

    public KeypadClick(int id) {
        super(id);
    }

    @Override
    public void run() {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";  // reuslt = "LRLLLRLLRRL"
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left"; // result = "LRLLRRLLLRR"
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right"; // result = "LLRLLRLLRL"

        System.out.println(solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        boolean isRightHanded = hand.equals("right");

        int leftPositionX = 0;
        int leftPositionY = 3;

        int rightPositionX = 2;
        int rightPositionY = 3;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftPositionX = 0;
                leftPositionY = getY(number);
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightPositionX = 2;
                rightPositionY = getY(number);
            } else {
                int y = getY(number);

                int distanceLeft = (1 - leftPositionX) + (getDiffer(y, leftPositionY));
                int distanceRight = (rightPositionX - 1) + (getDiffer(y, rightPositionY));

                if (distanceLeft > distanceRight) {
                    answer.append("R");
                    rightPositionX = 1;
                    rightPositionY = y;
                } else if (distanceLeft < distanceRight) {
                    answer.append("L");
                    leftPositionX = 1;
                    leftPositionY = y;
                } else {
                    if (isRightHanded) {
                        answer.append("R");
                        rightPositionX = 1;
                        rightPositionY = y;
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

    private int getDiffer(int a, int b) {
        return (a >= b) ? a - b : b - a;
    }

    private int getY(int number) {
        if (number == 0) return 3;
        if (number < 4) return 0;
        if (number < 7) return 1;
        return 2;
    }
}
