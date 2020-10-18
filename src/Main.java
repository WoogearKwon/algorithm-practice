import problems.KakaoCranePick;
import problems.Problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Problem> problems = new ArrayList<>();
        problems.add(new KakaoCranePick(0));

        problems.get(0).run();
    }
}
