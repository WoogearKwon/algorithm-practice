package problems.do_it_algorithm_test.search

import problems.Problem

/**
 * [05-023. 연결 요소의 개수 구하기]
 *
 * 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오
 * */
class ConnectedComponents : Problem() {
    private val n = 6 // node의 개수
    private val m = 5 // edge의 개수
    private val edges = arrayOf(
        arrayOf(1, 2),
        arrayOf(2, 5),
        arrayOf(5, 1),
        arrayOf(3, 4),
        arrayOf(4, 6),
    )

    private var graph: Array<MutableList<Int>?> = arrayOf()
    private var visit: BooleanArray = booleanArrayOf()
    private var count = 0

    override fun run() {
        initGraph()

        (1..n).forEach {
            if (visit[it].not()) {
                count++
                dfs(it)
            }
        }

        printResult(count.toString())
        println("Your answer is ${ANSWER == count}")
    }

    private fun dfs(v: Int) {
        if (visit[v]) return

        visit[v] = true

        graph[v]?.forEach {
            if (visit[it].not()) {
                dfs(it)
            }
        }
    }

    private fun initGraph() {
        graph = arrayOfNulls(n + 1)
        visit = BooleanArray(n + 1)

        (1..n).forEach {
            graph[it] = mutableListOf()
        }

        (0..edges.lastIndex).forEach {
            val x = edges[it][0]
            val y = edges[it][1]

            graph[x]?.add(y)
            graph[y]?.add(x)
        }
    }

    companion object {
        private const val ANSWER = 2
    }
}