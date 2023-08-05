import problems.Problem;
import problems.brute_force.Carpet;
import problems.brute_force.FindingPrime;
import problems.brute_force.PracticeExam;
import problems.code_challenge.PickAndPlus;
import problems.code_challenge.PickAndPlusKt;
import problems.dfs_bfs.*;
import problems.do_it_algorithm_test.section_sum.NewAverageKt;
import problems.do_it_algorithm_test.section_sum.RemainingSumKt;
import problems.do_it_algorithm_test.two_pointer.SequenceNumberSumKt;
import problems.etc.Fibonacci;
import problems.hash.BestAlbum;
import problems.hash.Camouflage;
import problems.hash.Marathon;
import problems.hash.PhoneNumbers;
import problems.heap.DiskController;
import problems.heap.DoublePriorityQueue;
import problems.heap.MoreSpicy;
import problems.kakao.*;
import problems.sort.BiggestNumber;
import problems.sort.HIndex;
import problems.sort.NumberInK;
import problems.stack_queue.DevelopingFunction;
import problems.stack_queue.PassingTrucks;
import problems.stack_queue.Printer;
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
        problems.put(24, new KakaoCranePickKt());
        problems.put(25, new KeypadClickKt());
        problems.put(26, new PickAndPlusKt());
        problems.put(27, new ConvertingWordsKt());
        problems.put(28, new HouseOneKt());
        problems.put(29, new HouseTwoKt());
        problems.put(30, new NetworkKt());
        problems.put(31, new TargetNumberKt());
        problems.put(32, new Fibonacci());
        problems.put(33, new TravelRouteKt());
        problems.put(34, new NewAverageKt());
        problems.put(35, new RemainingSumKt());
        problems.put(36, new SequenceNumberSumKt());
        // 가장 최근에 추가된 문제 실행
        problems.get(problems.size() - 1).run();
    }
}
