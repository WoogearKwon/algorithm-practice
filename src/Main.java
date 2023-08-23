import problems.Problem;
import problems.brute_force.Carpet;
import problems.brute_force.FindingPrime;
import problems.brute_force.PracticeExam;
import problems.code_challenge.PickAndPlus;
import problems.code_challenge.PickAndPlusKt;
import problems.dfs_bfs.*;
import problems.do_it_algorithm_test.search.ConnectedComponents;
import problems.do_it_algorithm_test.section_sum.NewAverageKt;
import problems.do_it_algorithm_test.section_sum.RemainingSumKt;
import problems.do_it_algorithm_test.two_pointer.SequenceNumberSumKt;
import problems.etc.Fibonacci;
import problems.graph.BoxerRank;
import problems.graph.FurthestNode;
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
        problems.put(1, new KakaoCranePickKt());
        problems.put(2, new PickAndPlus());
        problems.put(3, new KeypadClick());
        problems.put(4, new NumberInK());
        problems.put(5, new BiggestNumber());
        problems.put(6, new HIndex());
        problems.put(7, new Marathon());
        problems.put(8, new PhoneNumbers());
        problems.put(9, new Camouflage());

        problems.put(10, new BestAlbum());
        problems.put(11, new StockPrice());
        problems.put(12, new DevelopingFunction());
        problems.put(13, new PassingTrucks());
        problems.put(14, new Printer());
        problems.put(15, new MoreSpicy());
        problems.put(16, new DiskController());
        problems.put(17, new DoublePriorityQueue());
        problems.put(18, new PracticeExam());
        problems.put(19, new FindingPrime());

        problems.put(20, new Carpet());
        problems.put(21, new TargetNumber());
        problems.put(22, new TargetNumberKt());
        problems.put(23, new ConvertingWordsKt());
        problems.put(24, new Network());
        problems.put(25, new ConvertingWord());
        problems.put(26, new TravelRoute());
        problems.put(27, new TravelRouteKt());
        problems.put(28, new KeypadClickKt());
        problems.put(29, new PickAndPlusKt());

        problems.put(30, new HouseOneKt());
        problems.put(31, new HouseTwoKt());
        problems.put(32, new NetworkKt());
        problems.put(33, new Fibonacci());
        problems.put(34, new NewAverageKt());
        problems.put(35, new RemainingSumKt());
        problems.put(36, new SequenceNumberSumKt());
        problems.put(37, new FurthestNode());
        problems.put(38, new ConnectedComponents());
        problems.put(39, new GameMapShortestDistance());
        problems.put(40, new BoxerRank());
        // 가장 최근에 추가된 문제 실행
        problems.get(problems.size() - 1).run();
    }
}
