package problems;

public abstract class Problem implements Testable {
    protected String printAnswerFormat = getClass().getSimpleName() + " 정답:\n";
}
