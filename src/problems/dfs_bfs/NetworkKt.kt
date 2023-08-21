package problems.dfs_bfs

import problems.Problem

class NetworkKt : Problem() {
    private var visited = booleanArrayOf()
    private var result = 0

    override fun run() {
        val case = CASES[0]

        sol(case)
        println("result = $result")
        printResult(result == case.answer)
    }

    private fun sol(case: Case) {
        visited = BooleanArray(case.n)

        for (index in case.computers.indices) {
            if (visited[index]) continue

            visited[index] = true
            result++
            dfs(index, case.computers)
        }
    }

    private fun dfs(index: Int, computers: Array<IntArray>) {
        val computer = computers[index]

        computer.forEachIndexed { i, network ->
            if (index == i) return@forEachIndexed
            if (visited[i]) return@forEachIndexed

            if (network == 1) {
                visited[i] = true
                dfs(i, computers)
            }
        }
    }

    companion object {
        private val CASES = listOf(
            Case(
                n = 3,
                computers = arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 1),
                ),
                answer = 2
            ),
            Case(
                n = 4,
                computers = arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(0, 0, 1, 1),
                ),
                answer = 2
            ),
            Case(
                n = 4,
                computers = arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 0, 0, 1),
                ),
                answer = 1
            )
        )
    }

    private data class Case(
            val n: Int,
            val computers: Array<IntArray>,
            val answer: Int,
    )
}
