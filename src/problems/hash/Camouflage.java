package problems.hash;

import problems.Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * <위장/>
 * 문제 설명: 종류별로 옷을 입을 수 있는 경우의 수 구하기
 * <p>
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * <p>
 * <제한사항/>
 * 1. clothes의 각 행: {의상의 이름, 의상의 종류}
 * 2. 스파이가 가진 의상 수는 1개 이상 30개 이하
 * 3. 같은 이름을 가진 의상은 없음
 * 4. 스파이는 하루에 최소 한 개의 의상을 입음
 */
public class Camouflage extends Problem {

    @Override
    public void run() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; // return 5
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; // return 3

        printAnswer(solution2(clothes));
    }

    /**
     * <내 풀이/>
     * 각 의상의 종류별로 hashMap에 저장하여 count해야 함 HashMap<String, Integer>
     * 똑같은 이름을 가진 의상은 없음
     * <p>
     * 경우의 수:
     * 1. 의상을 하나씩만 착용했을 경우 = clothes.length()
     * 2. 각 의상을 서로 조합한 경우의 수
     * <p>
     * 결과: 오답
     * 원인: 문제를 잘못 해석했다. 옷 종류의 개수가 최대 4개라고 생각하고 너무 단순한 방법을 사용한 것이다....;;
     * 아래 다른 사람의 풀이를 보자.
     */
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<Object, Integer> map = new HashMap<>();
        for (String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);

        Object[] categories = map.keySet().toArray();
        answer += clothes.length;

        if (map.size() >= 2) {
            for (int i = 0; i < map.size() - 1; i++) {
                for (int j = i + 1; j < map.size(); j++) {
                    answer += (map.get(categories[i]) * map.get(categories[j]));
                }
            }
        }

        if (map.size() >= 3) {
            for (int i = 0; i < map.size() - 2; i++) {
                for (int j = i + 1; j < map.size() - 1; j++) {
                    for (int k = j + 1; k < map.size(); k++) {
                        answer += (map.get(categories[i]) * map.get(categories[j]) * map.get(categories[k]));
                    }
                }
            }
        }

        if (map.size() >= 4) {
            for (int i = 0; i < map.size() - 3; i++) {
                for (int j = i + 1; j < map.size() - 2; j++) {
                    for (int k = j + 1; k < map.size() - 1; k++) {
                        for (int l = k + 1; l < map.size(); l++) {
                            answer += (map.get(categories[i]) * map.get(categories[j]) * map.get(categories[k]) * map.get(categories[l]));
                        }
                    }
                }
            }
        }

        return answer;
    }

    /**
     * <다른 사람의 풀이 1/>
     * 링크: https://sas-study.tistory.com/215
     * 매우 깔끔하다. 풀이 방법을 정확히 이해했어야 한다.
     * 내가 고려하지 못한 것은 입지 않는 경우이다.
     * 소요 시간은 평균 0.10ms 미만이다.
     */
    public int solution2(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet)
            answer *= map.get(key) + 1; // 해당 종류의 옷을 안입는 경우를 고려 (이것이 핵심이다.)

        return answer - 1; // 아무것도 안 입은 경우를 제거
    }

    /**
     * <다른 사람의 풀이 2/>
     * stream을 이용했다.
     * 코드상으로는 상당히 단순하지만, 두 번째 풀이에 비해 계산하는데 많은 시간이 걸린다.
     * 소요 시간은 평균 10ms
     * 메모리 사용이 큰 것으로 보인다.
     */
    public int solution3(String[][] clothes) {
        return Arrays.stream(clothes)
            .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
            .values()
            .stream()
            .reduce(1L, (x, y) -> x * (y + 1))
            .intValue() - 1;
    }
}
