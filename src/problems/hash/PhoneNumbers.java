package problems.hash;

import problems.Problem;

import java.util.Arrays;

/**
 * 전화번호 목록
 * Refer to link below
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 * */
public class PhoneNumbers extends Problem {

    @Override
    public void run() {

//        String[] phoneBook = {"119", "97674223", "1195524421"}; // answer = false
        String[] phoneBook = {"123","456","789"}; // answer = true
//        String[] phoneBook = {"12","123","1235","567","88"}; // answer = false

        System.out.println(printAnswerFormat + solution2(phoneBook));
    }

    /**
     * 내 풀이:
     * 해시맵을 만들고 전화번호의 앞 두 자리가 key가 되도록 한다. value는 별 의미가 없다.
     * 전화번호의 최소 길이가 1이기 때문에, 길이가 2 이상인 경우에만 map안에 넣어준다.
     * map에 넣으려는 값이 이미 있는지 검사하고, 있다면 for문을 종료하고 false를 리턴한다.
     *
     * But, 이렇게 하면 테스트케이스 11개 중 2개를 실패한다. 무엇을 빼먹은걸까.
     *
     * 이런, 문제를 잘못 이해했다. 위의 방법이 잘못되었다.
     * 한 번호의 앞 두 글자 이상만 일치하면 되는 것이 아니라, 하나의 번호 전체가 다른 번호의 접두사가 되는 경우를 찾아야 한다.
     *
     * 풀이1. 해시를 사용하지 않고 풀 수 있다.
     * 단순하게 이중 for문을 돌려 두 개의 수를 서로 체크하는 방법
     * 그러나 해시 문제였기 때문에, 해시를 이용해 풀어야 하는 것이 맞다고 생각한다.
     * */
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
                if (phone_book[i].startsWith(phone_book[j])) return false;
            }
        }
        return true;
    }

    /**
     * 풀이2. 다른 사람의 풀이 (해시 사용)
     * 문자열을 하나의 해시코드 숫자로 만든 뒤 두 숫자를 비교
     * */
    public boolean solution2(String[] phone_book) {
        for (int i = 0; i < phone_book.length - 1; i++) {
            int hashPhone = phone_book[i].hashCode();
            int length = phone_book[i].length();

            for (int j = i + 1; j < phone_book.length; j++) {

                if (phone_book[j].length() >= length) {
                    if (hashPhone == (phone_book[j].substring(0, length).hashCode())) return false;

                } else {
                    if (phone_book[i].substring(0, phone_book[j].length())
                            .hashCode() == phone_book[j].hashCode()) return false;
                }
            }
        }

        return true;
    }

    /**
     * 풀이3. 다른 사람의 풀이 (문자열 배열 정렬 후 비교)
     * */
    public boolean solution3(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
