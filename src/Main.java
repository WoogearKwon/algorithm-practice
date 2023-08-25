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
import problems.hash.*;
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

        problems.put(11, new BestAlbumKt());
        problems.put(12, new StockPrice());
        problems.put(13, new DevelopingFunction());
        problems.put(14, new PassingTrucks());
        problems.put(15, new Printer());
        problems.put(16, new MoreSpicy());
        problems.put(17, new DiskController());
        problems.put(18, new DoublePriorityQueue());
        problems.put(19, new PracticeExam());
        problems.put(20, new FindingPrime());

        problems.put(21, new Carpet());
        problems.put(22, new TargetNumber());
        problems.put(23, new TargetNumberKt());
        problems.put(24, new ConvertingWordsKt());
        problems.put(25, new Network());
        problems.put(26, new ConvertingWord());
        problems.put(27, new TravelRoute());
        problems.put(28, new TravelRouteKt());
        problems.put(29, new KeypadClickKt());
        problems.put(30, new PickAndPlusKt());

        problems.put(31, new HouseOneKt());
        problems.put(32, new HouseTwoKt());
        problems.put(33, new NetworkKt());
        problems.put(34, new Fibonacci());
        problems.put(35, new NewAverageKt());
        problems.put(36, new RemainingSumKt());
        problems.put(37, new SequenceNumberSumKt());
        problems.put(38, new FurthestNode());
        problems.put(39, new ConnectedComponents());
        problems.put(40, new GameMapShortestDistance());

        problems.put(41, new BoxerRank());
        problems.put(42, new Pokemon());
        // 가장 최근에 추가된 문제 실행
        problems.get(problems.size() - 1).run();
    }
}
