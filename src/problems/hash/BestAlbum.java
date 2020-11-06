package problems.hash;

import problems.Problem;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * <베스트 앨범/>
 * 문제 설명: 장르별로 가장 많이 재생된 노래를 두 개씩 모아 베스트앨범을 출시하려고 한다.
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return하도록 solution 함수를 완성하라.
 *
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
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

    // 첫번째 시도 : 성공률 20% (실수: treeMap이 아닌 playSums로 for문 실행)
    // 두번째 시도 : 모두 성공, 그러나 소요시간이 어림잡아 평균 7ms. 괜찮은가?
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playSums = new HashMap<>(); // 장르별 총 재생수
        HashMap<String, Integer> musicNumbers = new HashMap<>(); // 장르별 총 음악수
        HashMap<Integer, Integer> playIndexes = new HashMap<>(); // index를 key로 하는 재생수

        for (int i = 0; i < genres.length; i++) {
            playSums.put(genres[i], playSums.getOrDefault(genres[i], 0) + plays[i]);
            musicNumbers.put(genres[i], musicNumbers.getOrDefault(genres[i], 0) + 1);
            playIndexes.put(i, plays[i]);
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());

        // TreeMap에 저장하면 자동으로 key 기준으로 정렬, reverseOrder 내림차순 정렬
        playSums.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                treeMap.put(integer, s);
            }
        });

        List<Integer> indexList = new ArrayList<>();

        for (String genre : treeMap.values()) { // 재생수 많은 장르별로 반복

            int bestNumbers = musicNumbers.get(genre) > 1 ? 2 : 1; // 베스트앨범에 들어갈 장르별 음악수
            for (int i = 0; i < bestNumbers; i++) {

                int index = 0;
                int biggestPlays = 0;
                for (int j = 0; j < genres.length; j++) {
                    if (playIndexes.containsKey(j) && genres[j].equals(genre) && plays[j] > biggestPlays) {
                        index = j;
                        biggestPlays = plays[j];
                    }
                }
                playIndexes.remove(index); //
                indexList.add(index);
            }
        }

        return indexList.stream().mapToInt(i -> i).toArray();
    }
}
