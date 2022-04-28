package problems.dfs_bfs

import problems.Problem

class NetworkKt : Problem() {

    override fun run() {
//        val n = 4; val answer = 1
//        val computers = arrayOf(
//            intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 1, 0), intArrayOf(1, 0, 0, 1),
//        )

        val n = 4; val answer = 2
        val computers = arrayOf(
            intArrayOf(1, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 1, 1),
        )

        val result = solution(n, computers)
        println("result = $result")
        printAnswer(result == answer)
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = n
        val checked = HashSet<Int>()

        for (i in computers.indices) {
            answer = dfs(i, checked, computers, answer)
        }
        return answer
    }

    private fun dfs(targetPosition: Int, checked: HashSet<Int>, computers: Array<IntArray>, networks: Int): Int {
        checked.add(targetPosition)
        var answer = networks
        val computer = computers[targetPosition]

        for (i in computer.indices) {
            if (computer[i] == 1 && checked.contains(i).not()) {
                answer = dfs(i, checked, computers, answer - 1)
            }
        }

        return answer
    }

    fun solution2(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val checked = HashSet<Int>()
        for (i in 0 until n) {
            if (checked.contains(i).not()) {
                dfs(computers, checked, i)
                answer++
            }
        }

        return answer
    }

    private fun dfs(computers: Array<IntArray>, checked: HashSet<Int>, position: Int) {
        checked.add(position)

        for (i in computers.indices) {
            if (computers[position][i] == 1 && checked.contains(i).not()) {
                dfs(computers, checked, i)
            }
        }
    }
}