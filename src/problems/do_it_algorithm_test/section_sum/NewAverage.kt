package problems.do_it_algorithm_test.section_sum

import problems.Problem

/**
* 세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집에 가져가기로 결심했다.
* 세준이는 이 점수들 최대값을 골랐다. 그런 다음 최댓값을 M이라 할 때,
* 모든 점수를 점수/M*100으로 고쳐야 한다.
* 예를 들어 최고점이 70점, 수학점수가 50점이라면 수학점수는 50/70*100이므로 71.43점이다.
* 세준이의 성적을 이 방법으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성하시오.
*
* @n: 주어진 시험 점수의 개수
* @input: 주어진 시험점수들
* */
class NewAverage : Problem() {
    private val n = 3
    private val input = "40 80 60"
    private val answer = 75.0f

    override fun run() {
        val numbers: List<Int> = input.split(" ").map { it.toInt() }
        val max = numbers.maxOrNull() ?: 0

        var sum = 0
        numbers.forEach { sum += it }

        val result: Float = (sum * 100f / max / n)

        printAnswer(result.toString())
        println("answer is ${result == answer}")
    }
}

