package problems.do_it_algorithm_test.two_pointer

import problems.Problem

/**
 * [연속된 자연수의 합 구하기]
 * 어떠한 자연수 N(0~10,000,000)은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
 * 당신은 어떤 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
 * 이때 사용하는 자연수는 N이어야 한다.
 * 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5 이다.
 * N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
 *
 * 제한시간 2초
 * 이런 상황에서 O(nlogn)의 시간복잡도 알고리즘을 사용하면 시간 초과이므로 O(n) 시간복잡도 알고리즘을 사용해야 함
 *
 * pseudo code
 * N 변수 저장
 * 사용 변수 초기화(count = 1, startIndex = 1, endIndex = 1, sum = 1)
 * while (endIndex != N) {
 *  if (sum == N) count++, endIndex++, sum 변경
 *  else if (sum > N) sum 변경, startIndex++
 *  else endIndx++, sum 변경
 * }
 * */
class SequenceNumberSum : Problem() {
    private val N = 15

    private var count = 1 // 숫자 15를 뽑는 경우의 수를 미리 넣고 초기화
    private var startIndex = 1
    private var endIndex = 1
    private var sum = 1

    override fun run() {

        while (endIndex != N) {
            if (sum == N) {
                count++
                endIndex++
                sum += endIndex

            } else if (sum > N) {
                sum -= startIndex
                startIndex++

            } else {
                endIndex++
                sum += endIndex
            }
        }
//
        printAnswer(count.toString())
        println("answer is ${ANSWER == count}")
    }

    companion object {
        private const val ANSWER = 4
    }
}