import problems.Problem;
import problems.code_challenge.PickAndPlus;
import problems.hash.BestAlbum;
import problems.hash.Camouflage;
import problems.hash.Marathon;
import problems.hash.PhoneNumbers;
import problems.kakao.KakaoCranePick;
import problems.kakao.KeypadClick;
import problems.sort.BiggestNumber;
import problems.sort.HIndex;
import problems.sort.NumberInK;
import problems.stack_queue.StockPrice;

import java.util.HashMap;

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
        problems.put(7, new PhoneNumbers());
        problems.put(8, new Camouflage());
        problems.put(9, new BestAlbum());
        problems.put(10, new StockPrice());

        problems.get(problems.size() - 1).run();
    }
}
