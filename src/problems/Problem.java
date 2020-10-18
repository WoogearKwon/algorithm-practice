package problems;

public abstract class Problem implements Testable {
    int number;

    public Problem(int number) {
        this.number = number;
    }
}
