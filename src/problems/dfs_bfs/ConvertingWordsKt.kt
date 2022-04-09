package problems.dfs_bfs

import problems.Problem
import kotlin.math.min

class ConvertingWordsKt : Problem() {

    override fun run() {
        val begin = "hit"
        val target = "cog"
        val words = arrayOf("hot", "dot", "dog", "lot", "log", "cog")
        val answer = 4

        val result = solution(begin, target, words)
        printAnswer(answer == result)
    }

    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (words.contains(target).not()) {
            return 0
        }

        val checkList = BooleanArray(words.size)
        return dfs(begin, target, words, 0, checkList, words.size)
    }

    private fun dfs(
        currentWord: String,
        target: String,
        words: Array<String>,
        count: Int,
        checkList: BooleanArray,
        answer: Int
    ): Int {
        if (currentWord == target) {
            return min(count, answer)
        }

        var newAnswer = 0
        for (i in words.indices) {
            if (checkList[i].not() && isOneWordOnlyDiff(currentWord, words[i])) {
                checkList[i] = true
                newAnswer = dfs(words[i], target, words, count + 1, checkList, answer)
                checkList[i] = false
            }
        }

        return newAnswer
    }

    private fun isOneWordOnlyDiff(currentWord: String, nextWord: String): Boolean {
        var count = 0

        for (i in currentWord.indices) {
            if (currentWord[i] != nextWord[i]) {
                count++
            }

            if (count >= 2) break
        }

        return count == 1
    }
}