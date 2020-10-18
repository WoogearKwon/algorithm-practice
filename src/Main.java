import problems.kakao.KakaoCranePick;
import problems.Problem;
import problems.code_challenge.PickAndPlus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Problem> problems = new ArrayList<>();
        problems.add(new KakaoCranePick(0));
        problems.add(new PickAndPlus(1));

        problems.get(1).run();
    }
}
