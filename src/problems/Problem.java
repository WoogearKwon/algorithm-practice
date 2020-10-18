package problems;

public abstract class Problem implements Testable {
    int id;

    public Problem(int id) {
        this.id = id;
    }
}
