package problems.hash;

import problems.Problem;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * */
public class Marathon extends Problem {

    public Marathon(int id) {
        super(id);
    }

    @Override
    public void run() {
        // 동명이인 없음
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"}; // answer = "leo"

        // 동명이인 2명
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"}; // answer = "mislev"

        // 동명이인 3명
        String[] participant = {"mislav", "stanko", "mislav", "ana", "mislav"};
        String[] completion = {"stanko", "ana", "mislav", "mislav"}; // answer = "mislev"

        System.out.println(printAnswerFormat + solution(participant, completion));
    }

    // 사람의 이름을 HashMap의 Key로 하면 동명이인 2명까지는 문제가 없지만 3명 이상 있을 경우 찾지 못함
    // 따라서 동명이인이 3명 이상 있을 경우에 대한 처리가 필요
    // 그러기 위해서는 사람의 숫자를 value로 넣어주면 된다.
    // map에 완주한 사람의 이름을 넣을 때 초기값을 1로 넣고, 동명이인이 나타날때마다 +1
    // 반대로 map에서 참가자의 이름을 대조할 때는 -1
    // 아예 넣은 적이 없는 사람을 만나면 null,
    // 동명이인이 있었으나 더이상 map에 없다면 0을 리턴
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String completed: completion) {
            if (map.containsKey(completed)) {
                map.put(completed, map.get(completed) + 1);
            } else {
                map.put(completed, 1);
            }
        }

        for (String participated : participant) {
            if (map.get(participated) == null || map.get(participated) == 0){
                answer = participated;
                break;
            }
            else map.put(participated, map.get(participated) - 1);
        }

        return answer;
    }

    // 다른 사람의 풀이
    // getOrDefault()라는 메서드가 있었다니..!
    // 이 메서드를 사용하면 복잡한 if-else 처리가 필요없어진다.
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
