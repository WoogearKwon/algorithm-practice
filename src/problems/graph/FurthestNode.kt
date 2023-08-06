package problems.graph

import problems.Problem
import java.util.*
import kotlin.math.max

/**
 * <가장 먼 노드/>
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
        val n = 6
        val edge = arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2),
        )

        initGraph(n, edge)
        bfs()

        var count = 0
        dist.forEach {
            if (it == max) count++
        }

        printAnswer(count.toString())
        println("Your answer is ${ANSWER == count}")
    }

    // 인접리스트 초기화
    private fun initGraph(n: Int, edge: Array<IntArray>) {
        graph = arrayOfNulls(n + 1)
        visit = BooleanArray(n + 1)
        dist = IntArray(n + 1)

        (1..n).forEach {
            graph[it] = mutableListOf()
        }

        (0..edge.lastIndex).forEach {
            val x = edge[it][0]
            val y = edge[it][1]

            graph[x]?.add(y)
            graph[y]?.add(x)
        }
    }

    private fun bfs() {
        val q: Queue<Int> = LinkedList()
        q.offer(1)
        visit[1] = true
        dist[1] = 0

        while (q.isNotEmpty()) {
            val k = q.poll()

            graph[k]?.forEach { x ->
                if (visit[x].not()) {
                    q.offer(x)
                    visit[x] = true

                    dist[x] = dist[k] + 1
                    max = max(max, dist[x])
                }
            }
        }
    }

    companion object {
        private val ANSWER = 3
    }
}