import problems.kakao.KakaoCranePick;
import problems.Problem;
import problems.code_challenge.PickAndPlus;
import problems.kakao.KeypadClick;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Problem> problems = new ArrayList<>();
        problems.add(new KakaoCranePick(0));
        problems.add(new PickAndPlus(1));
        problems.add(new KeypadClick(2));

        problems.get(2).run();
    }
}
