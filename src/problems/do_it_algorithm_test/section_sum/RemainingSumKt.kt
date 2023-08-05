package problems.do_it_algorithm_test.section_sum

import problems.Problem

/**
 * 나머지 합 구하기
 * N개의 개수가 주어졌을 때 연속된 부분의 합이 D로
 * 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * 즉 구간의 합이 D으로 나누어 떨어지는 (i,j) 쌍의 개수를 구하시오.
 * */
class RemainingSumKt : Problem() {
    private val N = 5
    private val D = 3
    private val numbers = arrayOf(1, 2, 3, 1, 2)

    private val sumArray = numbers
    private val counter = IntArray(N)

    private var answer = 0

    override fun run() {


        numbers.forEachIndexed { i, number ->
            if (i == 0) return@forEachIndexed
            sumArray[i] = sumArray[i - 1] + number
        }

        sumArray.forEachIndexed { i, number ->
            val remainder = number % D
            if (remainder == 0) answer++

            counter[remainder]++
        }

        (0 until D).forEach {
            if (counter[it] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 구하기
                answer += (counter[it] * (counter[it] - 1) / 2)
            }
        }

        printAnswer(answer.toString())
        println("answer is ${ANSWER == answer}")
    }

    companion object {
        private const val ANSWER = 7
    }
}
