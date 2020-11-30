package problems.brute_force;

import problems.Problem;

import java.util.*;

/**
 * <문제 원본 링크/>
 *  https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 *
 * <모의고사/>
 * 수포자는 수학을 포기한 사람의 준말이다.
 * 수포자 삼인방은 모의고사 수학 문제를 전부 찍으려고 한다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍는다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지 정답이 순서대로 담긴 배열 answers 가 주어질 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성하라.
 *
 * <제한조건/>
 * - 시험은 최대 10,000 문제로 구성되어있다.
 * - 문제의 정답은 1,2,3,4,5, 중 하나이다.
 * - 가장 높은 점수를 받은 사람이 여럿일 경우, return 하는 값을 오름차순 정렬해야한다.
 * */
public class PracticeExam extends Problem {
    @Override
    public void run() {
//        int[] answers = {1,2,3,4,5}; // return = {1};
        int[] answers = {1,3,2,4,2}; // return = {1,2,3}
//        int[] answers = {3,1,5,1,3,5,2,1,5,3,4,2}; // return = {3}

        System.out.println(printAnswerFormat + Arrays.toString(solution(answers)));
    }

    /**
     * <내 풀이/>
     *
     * 시도1: 28.6점 (4/14 통과)
     * 시도2: 35.7점 (5/14 통과) 원인: 수포자3의 답안 비교 로직 수정
     * 시도3: 50.0점 (7/14 통과) 원인: 수포자2의 패턴을 잘못 입력함 발견
     * 시도4: 57.1점 (8/14 통과) 원인: 수포자3의 답안 비교 로직 수정
     * 시도5: 78.6점 (11/14 통과) 원인: 수포자3의 답안 비교 로직 수정, 어떤 케이스가 빠진걸까.
     * 시도6: 100점 (모두 통과) 원인: 수포자3의 답안 비교 로직에서 answersOfStudents[bestStudents.get(0) - 1])의  -1을 빠트
     * */
    public int[] solution(int[] answers) {
        int[] one =   {1, 2, 3, 4, 5,}; // 수포자1 찍기 패턴, size = 5
        int[] two =   {2, 1, 2, 3, 2, 4, 2, 5}; // 수포자2 찍기 패턴, size = 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 수포자3 찍기 패턴, size = 10
        int[] answersOfStudents = {0, 0, 0}; // 수포자들(1,2,3)이 정답을 맞힌 개수
        List<Integer> bestStudents = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) answersOfStudents[0]++;
            if (answers[i] == two[i % two.length]) answersOfStudents[1]++;
            if (answers[i] == three[i % three.length]) answersOfStudents[2]++;
        }

        if (answersOfStudents[0] > 0) bestStudents.add(1);

        if (answersOfStudents[1] >= answersOfStudents[0]) {
            if (answersOfStudents[1] > answersOfStudents[0]) bestStudents.clear();
            bestStudents.add(2);
        }

        if (answersOfStudents[2] >= answersOfStudents[0] && answersOfStudents[2] >= answersOfStudents[1]) {
            if (!bestStudents.isEmpty() && answersOfStudents[2] > answersOfStudents[bestStudents.get(0) - 1])
                bestStudents.clear();
            bestStudents.add(3);
        }

        return bestStudents.stream().mapToInt(i -> i).toArray();
    }

    /**
     * <다른 사람의 풀이/>
     * max함수를 사용해서 훨씬 나보다 간단하게 구현을 했다.
     * */
    public int[] solution2(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == a[i%a.length]) {score[0]++;}
            if(answers[i] == b[i%b.length]) {score[1]++;}
            if(answers[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i-> i).toArray();
    }
}
