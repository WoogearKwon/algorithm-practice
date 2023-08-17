package problems.dfs_bfs

import problems.Problem

class TravelRouteKt : Problem() {
    lateinit var answer: List<String>
    private var visit: BooleanArray = booleanArrayOf()

    override fun run() {
        val tickets = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
//        mapSolution(tickets)
        dfsSolution(tickets)


        println("answer is ${answer == ANSWER}")
    }

    private fun mapSolution(tickets: Array<Array<String>>) {
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

        answer = builder.toString().split(",")
        printAnswer(builder.toString())
    }

    private val route = mutableListOf<String>()

    private fun dfsSolution(tickets: Array<Array<String>>) {
        visit = BooleanArray(tickets.size)

        val ticket = tickets[0]
        val departure = ticket[0]
        route.add(departure)
        dfs(1, departure, tickets)

        answer = route
        printAnswer(route.joinToString(","))
    }

    private fun dfs(id: Int, destination: String, tickets: Array<Array<String>>) {
        if (visit[id]) return

        visit[id] = true

        tickets.forEachIndexed { i, ticket ->
            val dept = ticket[0]
            val dest = ticket[1]

            if (destination == dept) {
                route.add(dest)
                dfs(i, dest, tickets)
            }
        }
    }

    companion object {
        private val ANSWER = listOf("ICN", "JFK", "HND", "IAD")
    }
}