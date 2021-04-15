import problems.Problem;
import problems.brute_force.*;
import problems.code_challenge.*;
import problems.dfs_bfs.*;
import problems.hash.*;
import problems.heap.*;
import problems.kakao.*;
import problems.sort.*;
import problems.stack_queue.*;

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
        problems.put(11, new DevelopingFunction());
        problems.put(12, new PassingTrucks());
        problems.put(13, new Printer());
        problems.put(14, new MoreSpicy());
        problems.put(15, new DiskController());
        problems.put(16, new DoublePriorityQueue());
        problems.put(17, new PracticeExam());
        problems.put(18, new FindingPrime());
        problems.put(19, new Carpet());
        problems.put(20, new TargetNumber());
        problems.put(21, new Network());
        problems.put(22, new ConvertingWord());
        problems.put(23, new TravelRoute());

        // 가장 최근에 추가된 문제 실행
        problems.get(problems.size() - 1).run();
    }
}
