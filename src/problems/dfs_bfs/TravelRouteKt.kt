package problems.dfs_bfs

import problems.Problem

class TravelRouteKt : Problem() {
    override fun run() {
        val tickets = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
        val answer = arrayOf("ICN", "JFK", "HND", "IAD")

        val map = mutableMapOf<String, String>()
        tickets.forEach {
            map[it[0]] = it[1]
        }

        val builder = StringBuilder()
        builder.append("ICN")
        var lastDest = map.remove("ICN")
        builder.append(",$lastDest")

        while (map.isNotEmpty()) {
            lastDest = map.remove(lastDest)
            builder.append(",$lastDest")
        }

        val result = builder.toString().split(",")
        printAnswer(builder.toString())
        println("answer is ${result == answer}")
    }
}