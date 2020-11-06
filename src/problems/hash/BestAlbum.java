package problems.hash;

import problems.Problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * <베스트 앨범/>
 * 문제 설명: 장르별로 가장 많이 재생된 노래를 두 개씩 모아 베스트앨범을 출시하려고 한다.
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return하도록 solution 함수를 완성하라.
 *
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * <노래 수록 기준/>
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유번호가 낮은 노래를 먼저 수록
 *
 * <제한사항/>
 * 1. genres[i]는 고유번호가 i인 노래장르
 * 2. plays[i]는 고유번호가 i인 노래가 재생된 횟수
 * 3. genres와 plays의 길이는 같으며, 1이상 10,000이하
 * 4. 장르 종류는 100개 미만
 * 5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택
 * 6. 모든 장르는 재생된 횟수가 다름
 * */
public class BestAlbum extends Problem {
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500}; // return {4, 1, 3, 0}

    @Override
    public void run() {
        System.out.println(printAnswerFormat + Arrays.toString(solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());

        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                treeMap.put(integer, s);
            }
        });

        System.out.println(treeMap);

        return answer;
    }
}
