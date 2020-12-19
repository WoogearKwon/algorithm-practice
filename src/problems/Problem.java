package problems;

import java.util.Arrays;

public abstract class Problem implements Testable {
    protected String printAnswerFormat = getClass().getSimpleName() + " 정답:\n";

    protected void printAnswer (int result) {
        System.out.println(printAnswerFormat + result);
    }

    protected void printAnswer (int[] result) {
        System.out.println(printAnswerFormat + Arrays.toString(result));
    }

    protected void printAnswer (String result) {
        System.out.println(printAnswerFormat + result);
    }

    protected void printAnswer (String[] result) {
        System.out.println(printAnswerFormat + Arrays.toString(result));
    }
}
