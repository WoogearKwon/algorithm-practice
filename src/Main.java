import problems.hash.Marathon;
import problems.kakao.KakaoCranePick;
import problems.Problem;
import problems.code_challenge.PickAndPlus;
import problems.kakao.KeypadClick;
import problems.sort.BiggestNumber;
import problems.sort.HIndex;
import problems.sort.NumberInK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Problem> problems = new HashMap<>();
        problems.put(0, new KakaoCranePick());
        problems.put(1, new PickAndPlus());
        problems.put(2, new KeypadClick());
        problems.put(3, new NumberInK());
        problems.put(4, new BiggestNumber());
        problems.put(5, new HIndex());
        problems.put(6, new Marathon());

        problems.get(problems.size() - 1).run();
    }
}
