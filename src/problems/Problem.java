package problems;

import java.util.Arrays;

public abstract class Problem implements Testable {
    private final String printAnswerFormat = getClass().getSimpleName() + " 실행 결과:\n";

    protected void printResult(int result) {
        System.out.println(printAnswerFormat + result);
    }

    protected void printResult(int[] result) {
        System.out.println(printAnswerFormat + Arrays.toString(result));
    }

    protected void printResult(String result) {
        System.out.println(printAnswerFormat + result);
    }

    protected void printResult(String[] result) {
        System.out.println(printAnswerFormat + Arrays.toString(result));
    }

    protected void printResult(boolean result) {
        System.out.println(printAnswerFormat + result);
    }
}
