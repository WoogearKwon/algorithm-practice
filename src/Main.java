import problems.hash.Marathon;
import problems.kakao.KakaoCranePick;
import problems.Problem;
import problems.code_challenge.PickAndPlus;
import problems.kakao.KeypadClick;
import problems.sort.BiggestNumber;
import problems.sort.HIndex;
import problems.sort.NumberInK;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Problem> problems = new ArrayList<>();
        problems.add(new KakaoCranePick(0));
        problems.add(new PickAndPlus(1));
        problems.add(new KeypadClick(2));
        problems.add(new NumberInK(3));
        problems.add(new BiggestNumber(4));
        problems.add(new HIndex(5));
        problems.add(new Marathon(6));

        problems.get(problems.size() - 1).run();
    }
}
