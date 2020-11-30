package problems.brute_force;

import problems.Problem;

import java.util.HashSet;

/**
 * <문제 원본 링크/>
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * <소수 찾기/>
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇개인지 return 하도록 solution 함수를 완성하세요.
 *
 * <제한 사항/>
 * numbers는 길이 1 이상 7 이하인 문자열이다.
 * numbers는 0~9 까지 숫자만으로 이루어져있다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조가각이 흩어져있다는 의미이다.
 * */
public class FindingPrime extends Problem {
    HashSet<Integer> set = new HashSet<>();

    @Override
    public void run() {
//        String numbers = "17"; // return = 3
        String numbers = "011"; // return = 2

        System.out.println(printAnswerFormat + solution(numbers));
    }

    /**
     * <내 풀이/>
     * - HashSet을 이용해서 중복하지 않는 소수를 저장하는데 사용한다.
     * - 순열알고리즘을 사용하여 배열안에 든 모든 숫자를 조합한다.
     * - 조합한 숫자가 소수인지 확인하여 소수이면 set에 저장한다.
     * - set의 size를 리턴한다.
     * */
    public int solution(String numbers) {
        String[] numbs = numbers.split("");
        for (int i = 1; i <= numbers.length(); i++) {
            perm(numbs, 0, numbers.length(), i);
        }

        return set.size();
    }

    /**
     * <순열 알고리즘/>
     * 참고: https://gorakgarak.tistory.com/522
     *
     * arr: 데이터를 가지고 있으면서 순서를 교환하는 배열
     * depth: 현재 트리구조에서 어떤 깊이에서 교환작업을 하고있는지를 확인하는 변수
     * n: 총 배열안에 들어있는 숫자, 고정값
     * k: 선택할 숫자의 개수
     * */
    private void perm(String[] arr, int depth, int n, int k) {
        StringBuilder numb = new StringBuilder();
        if (depth == k) { // depth가 k에 도달하면 사이클이 한 번 끝.
            for (int i = 0; i < k; i++) {
                numb.append(arr[i]);
            }

            if (!set.contains(Integer.parseInt(numb.toString()))) {
                if (isPrimeNumber(Integer.parseInt(numb.toString()))) {
                    set.add(Integer.parseInt(numb.toString()));
                }
            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 소수인지 확인하는 함수
    private boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * <다른 사람의 풀이/>
     * */
    public int solution2(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if(a == 2) count++;
            if(a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }
}
