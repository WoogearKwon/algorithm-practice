package problems.dfs_bfs

import problems.Problem

class TargetNumberKt : Problem() {

    override fun run() {
        val numbers = intArrayOf(1, 1, 1, 1, 1)
        val target = 3 // 기대하는 결과값
        val answer = 5 // 정답 (5가지)

        val result = solution(numbers, target)
        printAnswer(result)
    }

    private fun solution(numbers: IntArray, target: Int): Int {
        return dfs(0, numbers, 0, target)
    }

    private fun dfs(n: Int, numbers: IntArray, sum: Int, target: Int): Int {
        if (n == numbers.size) {
            if (sum == target) return 1
            return 0
        }

        val result1 = dfs(n + 1, numbers, sum + numbers[n], target)
        val result2 = dfs(n + 1, numbers, sum - numbers[n], target)

        return result1 + result2
    }

    private fun solution2(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}