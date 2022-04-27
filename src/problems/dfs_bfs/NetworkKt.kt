package problems.dfs_bfs

import problems.Problem

class NetworkKt : Problem() {

    override fun run() {
//        val n = 4
//        val computers = arrayOf(
//            intArrayOf(1, 1, 1, 1),
//            intArrayOf(1, 1, 0, 0),
//            intArrayOf(1, 0, 1, 0),
//            intArrayOf(1, 0, 0, 1),
//        )
        val n = 4
        val computers = arrayOf(
            intArrayOf(1,1,0,0),
            intArrayOf(1,1,0,0),
            intArrayOf(0,0,1,1),
            intArrayOf(0,0,1,1),
        )

        val answer = 2
        val result = solution(n, computers)
        println("result = $result")
        printAnswer(result == answer)
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        val check = HashSet<Int>()
        check.add(0)

        return dfs(0, check, computers, n)
    }

    private fun dfs(target: Int, check: HashSet<Int>, computers: Array<IntArray>, networks
    : Int): Int {
        var answer = networks
        val computer = computers[target]

        for (i in computer.indices) {
            if (check.contains(i)) continue

            if (computer[i] == 1) {
                println("woogear...!! con = $answer")
                check.add(i)
                answer = dfs(i, check, computers, answer - 1)
            }
        }

        return answer
    }
}