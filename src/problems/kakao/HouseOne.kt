package problems.kakao

import problems.Problem

class HouseOne : Problem() {

    override fun run() {
        val path = "EEESEEEEEENNNN"
        val result = solution(path)
        val answer = arrayOf(
            "Time 0: Go straight 300m and turn right",
            "Time 3: Go straight 100m and turn left",
            "Time 5: Go straight 500m and turn left"
        )

        printAnswer(result.contentEquals(answer))
    }

    fun solution(path: String): Array<String> {
        val answer = mutableListOf<String>()
        var count = 0

        for (i in path.indices) {
            val currentPath = path[i]
            if (i != 0 && currentPath != path[i - 1]) {
                val time = if (count >= 5) i - 5 else i - count
                val distance = if (count >= 5) "500" else (count * 100).toString()
                val direction = getDirection("${path[i - 1]}$currentPath")
                answer.add(String.format("Time %s: Go straight %sm and turn %s", time, distance, direction))
                count = 0
            }
            count++
        }

        return answer.toTypedArray()
    }

    private fun getDirection(path: String): String {
        return when (path) {
            "EN", "NW", "WS", "SE" -> "left"
            else -> "right"
        }
    }
}