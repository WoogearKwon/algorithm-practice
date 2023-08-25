package problems.graph

import problems.Problem
import java.util.*

/**
 * [순위, 그래프]
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * 순위를 알 수 잇는 선수의 수를 리턴
 * */
class BoxerRank : Problem() {
    override fun run() {
        val case = CASES[0]

        val result = solution(case.n, case.results)
        printResult(result)
        println("Your answer is ${case.answer == result}")
    }

    /**
     * 10개 중 6개 성공, 4개 시간초과
     * */

    private val graph: MutableList<MutableSet<Int>> = mutableListOf()

    fun solution(n: Int, results: Array<IntArray>): Int {
        val winnerGraph: MutableList<MutableSet<Int>> = mutableListOf()
        val loserGraph: MutableList<MutableSet<Int>> = mutableListOf()
        val visited = BooleanArray(n + 1)

        var answer = 0

        for (i in 0 .. n) {
            winnerGraph.add(mutableSetOf())
            loserGraph.add(mutableSetOf())
            graph.add(mutableSetOf())
        }

        results.forEach { match ->
            val winner = match[0]
            val loser = match[1]

            winnerGraph[winner].add(loser)
        }

        for (i in 1 .. n) {
            dfs(i, winnerGraph, visited)
        }

        graph.forEachIndexed { i, set ->
            set.forEach {
                loserGraph[it].add(i)
            }
        }

        graph.forEachIndexed { index, set ->
            if (set.size + loserGraph[index].size == n - 1) answer += 1
        }

        return answer
    }

    private fun dfs(
        index: Int,
        set: List<Set<Int>>,
        visited: BooleanArray
    ) {
        visited[index] = true

        val stack = Stack<Int>()
        stack.add(index)

        while (stack.isNotEmpty()) {
            val i = stack.pop()
            val players = set[i]
            graph[index].addAll(players)

            players.forEach { player ->
                if (visited[player]) {
                    graph[index].addAll(graph[player])
                } else {
                    stack.add(player)
                }
            }
        }
    }

    companion object {
        private val CASES = listOf(
            TestCase(
                n = 5, // 선수의 수
                results = arrayOf(
                    // 경기 결과 (4, 3) 은 4번 선수가 3번 선수를 이겼음을 의미
                    intArrayOf(4, 3),
                    intArrayOf(4, 2),
                    intArrayOf(3, 2),
                    intArrayOf(1, 2),
                    intArrayOf(2, 5),
                ),
                answer = 2, // 5번이 5등, 2번이 4등
            ),
            TestCase(
                n = 5,
                results = arrayOf(
                    intArrayOf(4, 3),
                    intArrayOf(4, 2),
                    intArrayOf(2, 5),
                    intArrayOf(5, 1),
                ),
                answer = 1, // 4번 선수가 1등
            )
        )
    }

    private class TestCase(
        val n: Int,
        val results: Array<IntArray>,
        val answer: Int,
    )
}