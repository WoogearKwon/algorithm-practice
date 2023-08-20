package problems.dfs_bfs

import problems.Problem

class TargetNumberKt : Problem() {

    override fun run() {
        val numbers = intArrayOf(1, 1, 1, 1, 1)
        val target = 3

        val result = dfs(0, numbers, 0, target)
        printAnswer(result)
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

    companion object {
        private const val ANSWER = 5
        // -1+1+1+1+1 = 3
        // +1-1+1+1+1 = 3
        // +1+1-1+1+1 = 3
        // +1+1+1-1+1 = 3
        // +1+1+1+1-1 = 3
    }
}