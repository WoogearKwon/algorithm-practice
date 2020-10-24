package problems;

public abstract class Problem implements Testable {
    protected int id;
    protected String printAnswerFormat = getClass().getSimpleName() + " 정답:\n";

    public Problem(int id) {
        this.id = id;
    }
}
