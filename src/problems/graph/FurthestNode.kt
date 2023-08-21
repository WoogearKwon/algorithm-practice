package problems.graph

import problems.Problem
import java.util.*
import kotlin.math.max

/**
 * <가장 먼 노드/>
 * 최단경로로 이동했을 때 1번에서 가장 멀리 떨어진 노드의 갯수를 구하기
 * n = 노드의 개수
 * edge = 간선에 대한 정보가 담긴 2차원 배열
 *
 * <링크/>
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 *
 * */
class FurthestNode : Problem() {
    private var graph: Array<MutableList<Int>?> = arrayOf()
    private var visit: BooleanArray = booleanArrayOf()
    private var dist: IntArray = intArrayOf()
    private var max = 0

    override fun run() {
        val case = CASES[0]

        initGraph(case.n, case.edge)
        bfs()

        val count = dist.count { it == max }

        printResult(count.toString())
        println("Your answer is ${case.answer == count}")
    }

    // 인접리스트 초기화
    private fun initGraph(n: Int, edge: Array<IntArray>) {
        graph = arrayOfNulls(n + 1)
        visit = BooleanArray(n + 1)
        dist = IntArray(n + 1)

        (1..n).forEach {
            graph[it] = mutableListOf()
        }

        edge.forEach {
            val x = it[0]
            val y = it[1]

            graph[x]?.add(y)
            graph[y]?.add(x)
        }
    }

    private fun bfs() {
        val queue = LinkedList<Int>()
        queue.offer(1)
        visit[1] = true
        dist[1] = 0

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            graph[node]?.forEach { nextNode ->
                if (visit[nextNode].not()) {
                    queue.offer(nextNode)
                    visit[nextNode] = true

                    dist[nextNode] = dist[node] + 1
                    max = max(max, dist[nextNode])
                }
            }
        }
    }

    companion object {
        private val CASES = listOf(
            Case(
                n = 6,
                edge = arrayOf(
                    intArrayOf(3, 6),
                    intArrayOf(4, 3),
                    intArrayOf(3, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 2),
                    intArrayOf(2, 4),
                    intArrayOf(5, 2),
                ),
                answer = 3
            )
        )
    }

    private data class Case(
        val n: Int,
        val edge: Array<IntArray>,
        val answer: Int
    )
}