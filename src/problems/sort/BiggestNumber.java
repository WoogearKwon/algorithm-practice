package problems.sort;

import problems.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 큰수
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 * */
public class BiggestNumber extends Problem {
    @Override
    public void run() {
        int[] numbers = {6, 10, 2}; // answer = "6210"
//        int[] numbers = {3, 30, 34, 5, 9}; // answer = "9534330

        printAnswer(solution(numbers));
    }

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        // ex) 6102와 6210을 비교해서 lexicographically(사전적)으로 더 큰 문자열이 되도록 정렬
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 입력값이 {0,0,0,0,}일 경우 0000이 아닌 0으로 리턴
        if(arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        return sb.toString();
    }

    // 다른 사람의 풀이
    public String solution2(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();

        for (int number : numbers) list.add(number);

        list.sort((a, b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);

            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();

        for(Integer i : list) sb.append(i);

        answer = sb.toString();

        if(answer.charAt(0) == '0') return "0";
        else return answer;
    }
}
