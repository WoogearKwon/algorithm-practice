package problems.hash

import problems.Problem

class BestAlbumKt : Problem() {

    override fun run() {
        val testCase = cases[0]
        val result = solution(testCase.genres, testCase.plays)
        val answer = testCase.answer

        printResult(result)
        println("Your answer is ${result.contentEquals(answer)}")
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = mutableMapOf<String, Int>()
        val musics = mutableListOf<Music>()

        for (i in genres.indices) {
            val playCount = map[genres[i]] ?: 0
            map[genres[i]] = playCount + plays[i]
            musics.add(Music(i, genres[i], plays[i]))
        }

        val sortedMap = map
            .toList()
            .sortedByDescending { (_, value) -> value }
            .toMap()

        val result = mutableListOf<Int>()
        sortedMap.keys.forEach { genre ->
            val filteredMusics = musics
                .filter { it.genre == genre }
                .sortedByDescending { it.id }
                .sortedBy { it.playCount }
                .reversed()

            result.add(filteredMusics.first().id)
            if (filteredMusics.size > 1) result.add(filteredMusics[1].id)
        }

        return result.toIntArray()
    }

    private fun sol(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }.toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map{ it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten().toList()
            .toIntArray()
    }

    private data class Music(
        val id: Int,
        val genre: String,
        val playCount: Int,
    )

    companion object {
        private val cases = listOf(
            Case(
                genres = arrayOf("classic", "pop", "classic", "classic", "pop"),
                plays = intArrayOf(500, 600, 150, 800, 2500),
                answer = intArrayOf(4, 1, 3, 0)
            ),
            Case(
                genres = arrayOf("classic", "pop", "classic", "classic", "pop"),
                plays = intArrayOf(500, 600, 500, 800, 2500),
                answer = intArrayOf(4, 1, 3, 0)
            )
        )
    }

    private class Case(
        val genres: Array<String>,
        val plays: IntArray,
        val answer: IntArray
    )
}