package problems.kakao

import problems.Problem
import java.util.*

class KakaoCranePickKt : Problem() {
    override fun run() {
        val board = arrayOf(
            intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1),
        )

        val sequence = intArrayOf(1,5,3,5,1,2,1,4) // answer = 4

        val answer = solution2(board, sequence)
        printAnswer(answer)
    }

    private fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        for (column in moves) {

            for (row in board.indices) {
                val rowArray = board[row]
                val number = rowArray[column - 1]

                if (number != 0) {

                    if (stack.isEmpty()) {
                        stack.push(number)
                        rowArray[column - 1] = 0
                        break
                    }

                    if (number == stack.peek()) {
                        stack.pop()
                        rowArray[column - 1] = 0
                        answer += 2
                        break
                    }

                    stack.push(number)
                    rowArray[column - 1] = 0
                    break
                }
            }
        }

        return answer
    }

    private fun solution2(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()
        var answer = 0

        for (column in moves) {

            for (row in board.indices) {
                val rowArray = board[row]
                val number = rowArray[column - 1]

                if (number != 0) {

                    if (stack.isNotEmpty() && number == stack.peek()) {
                        answer += 2
                        stack.pop()
                    } else {
                        stack.push(number)
                    }

                    rowArray[column - 1] = 0
                    break
                }
            }
        }

        return answer
    }
}