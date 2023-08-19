package problems.dfs_bfs

import problems.Problem

class TravelRouteKt : Problem() {
    private val routeList = mutableListOf<String>()
    private var visited: BooleanArray = booleanArrayOf()

    override fun run() {
        val tickets = arrayOf(
            arrayOf("ICN", "SFO"),
            arrayOf("ICN", "ATL"),
            arrayOf("SFO", "ATL"),
            arrayOf("ATL", "ICN"),
            arrayOf("ATL", "SFO"),
        )
        dfsSolution(tickets)

        val route: String = routeList.minOf { it }

        printAnswer(route)
        val answer = route.split(",")
        println("answer is ${answer == ANSWER}")
    }

    private fun dfsSolution(tickets: Array<Array<String>>) {
        visited = BooleanArray(tickets.size)

        tickets.forEachIndexed { index, ticket ->
            if (ticket[0] != "ICN") return@forEachIndexed

            dfs(
                routes = "ICN",
                index = index,
                count = 1,
                tickets = tickets
            )
        }
    }

    private fun dfs(
        routes: String,
        index: Int,
        count: Int,
        tickets: Array<Array<String>>
    ) {
        if (visited[index]) return

        val destination = tickets[index][1]

        if (count == tickets.size) {
            routeList.add("$routes,$destination")
            return
        }

        tickets.forEachIndexed { i, ticket ->
            val currDept = ticket[0]
            if (destination != currDept) return@forEachIndexed

            visited[index] = true
            dfs(
                routes = "$routes,$destination",
                index = i,
                count = count + 1,
                tickets = tickets
            )
            visited[index] = false
        }
    }

    companion object {
        private val ANSWER = listOf("ICN","ATL","ICN","SFO","ATL","SFO")
    }
}