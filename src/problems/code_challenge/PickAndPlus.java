package problems.code_challenge;

import problems.Problem;
import problems.sort.NumberInK;

import java.util.*;

/**
 * 두 개 뽑아서 더하기
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * */
public class PickAndPlus extends Problem {
    private int id;

    public PickAndPlus(int id) {
        super(id);
        this.id = id;
    }

    @Override
    public void run() {
        int[] numbers = {12,44,3,2,99,7,34,57,43,100,11,53,24,2,1,3,4,1};
//        int[] numbers = {2,1,3,4,1}; // result = [2,3,4,5,6,7]
//        int[] numbers = {5,0,2,7}; // result = [2,5,7,9,12]
        System.out.println(printAnswerFormat + Arrays.toString(solution(numbers)));
    }

    // My solution
    // 해시맵을 사용하면 중복에 대해 고민하지 않아도 된다.
    // 다만 정렬은 해줘야 한다.
    public int[] solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int number = numbers[i] + numbers[j];
                map.put(number, number);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 아래는 다른 사람의 풀이
    // 아래는 HashSet을 사용했다.
    // 나는 HashMap을 사용해서 <key-value>로 저장을 해주었지만,
    // HashSet은 단순히 객체를 넣어주면 된다. 마찬가지로 중복은 허용하지 않는다.
    public int[] solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
