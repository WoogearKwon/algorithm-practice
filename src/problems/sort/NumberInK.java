package problems.sort;

import problems.Problem;

import java.util.Arrays;

public class NumberInK extends Problem {

    /**
     * K번째수
     * Refer to link below
     * https://programmers.co.kr/learn/courses/30/lessons/42748
     * */
    public NumberInK(int id) {
        super(id);
    }

    @Override
    public void run() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; // 정답 = {5, 6, 3}


        System.out.println(NumberInK.class.getSimpleName() + " 정답" +
                "" + Arrays.toString(solution(array, commands)));
    }

    // 나의 풀이
    // 버블정렬을 사용했으나 코드가 복잡하고 불필요하게 길다.
    // 아래 다른 사람의 코드를 보자. 자바의 유용한 인터페이스를 알면 훨씬 간단하게 코드를 작성할 수 있다.
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            // 잘라낼 배열의 크기 구하기
            int newArraySize = commands[i][1] - commands[i][0] + 1;
            int[] newArray = new int[newArraySize];

            int p = commands[i][0] - 1;

            // 잘라낸 배열 값 넣기
            for (int j = 0; j < newArraySize; j++) {
                newArray[j] = array[p];
                p++;
            }

            bubbleSort(newArray);

            // 정답
            answer[i] = newArray[commands[i][2] - 1];
        }

        return answer;
    }

    private void bubbleSort(int[] array) {
        int k = 0;
        int n = array.length;

        while (k < n - 1) {
            int last = n - 1;

            for (int i = n - 1; i > k ; i--) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    last = i;
                }
            }

            k = last;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t= arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // 다른 사람의 풀이
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
