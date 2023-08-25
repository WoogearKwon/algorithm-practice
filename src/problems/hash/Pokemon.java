package problems.hash;

import problems.Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pokemon extends Problem {

    @Override
    public void run() {
        Case testCase = cases.get(0);

        int result = solution(testCase.nums);
        int answer = testCase.answer;

        printResult(result);
        System.out.println("Your answer is " + answer);
    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int size = nums.length / 2;

        return Math.min(set.size(), size);
    }

    private class Case {
        int[] nums;
        int answer;

        public Case(int[] nums, int answer) {
            this.nums = nums;
            this.answer = answer;
        }
    }

    private final List<Case> cases = Arrays.asList(
        new Case(
            new int[]{3, 1, 2, 3},
            2
        ),
        new Case(
            new int[]{3, 3, 3, 2, 2, 4},
            3
        ),
        new Case(
            new int[]{3, 3, 3, 2, 2, 2},
            2
        )
    );
}
