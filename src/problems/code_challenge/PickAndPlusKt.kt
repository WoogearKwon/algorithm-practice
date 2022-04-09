package problems.code_challenge

import problems.Problem

class PickAndPlusKt : Problem() {

    override fun run() {
        val numbers = intArrayOf(5,0,2,7)
        val answer = intArrayOf(2,5,7,9,12)

        val result = solution(numbers)
        printAnswer(result.contentEquals(answer))
    }

    fun solution(numbers: IntArray): IntArray {
        val set = sortedSetOf<Int>()

        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                set.add(numbers[i] + numbers[j])
            }
        }

        return set.toIntArray()
    }
}