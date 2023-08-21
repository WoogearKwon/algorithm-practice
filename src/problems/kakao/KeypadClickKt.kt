package problems.kakao

import problems.Problem

class KeypadClickKt : Problem() {

    override fun run() {
        val numbers = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
        val hand = "right"
        val answer = "LRLLLRLLRRL"

        val result = solution(numbers, hand)
        printAnswer(result == answer)
    }

    /**
     * 규칙의 일관성을 위해 키패드 숫자가 아래와 같도록 수정한다.
     * (*, 0, #) 을 각각 (10, 11, 12)로 수정한 것이다.
     * 1  2  3
     * 4  5  6
     * 7  8  9
     * 10 11 12
     *
     * 숫자와 손가락 사이의 거리를 미리 계산한 함수 getDistance()를 만들어 놓는다.
     *
     * 맨 처음 왼손가락 위치는 10, 오른손가락의 위치는 12로 시작한다.
     * 0은 11로 바꾼다.
     * */
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        var leftFingerP = 10
        var rightFingerP = 12

        for (number in numbers) {
            when (number) {
                1, 4, 7 -> {
                    answer += "L"
                    leftFingerP = number
                }
                3, 6, 9 -> {
                    answer += "R"
                    rightFingerP = number
                }
                else -> {
                    val newNumb = if (number == 0) 11 else number
                    val leftHandDistance = getDistance(leftFingerP, newNumb)
                    val rightHandDistance = getDistance(rightFingerP, newNumb)

                    if (leftHandDistance < rightHandDistance) {
                        answer += "L"
                        leftFingerP = newNumb

                    } else if (leftHandDistance > rightHandDistance) {
                        answer += "R"
                        rightFingerP = newNumb

                    } else {
                        if (hand == "left") {
                            answer += "L"
                            leftFingerP = newNumb

                        } else {
                            answer += "R"
                            rightFingerP = newNumb
                        }
                    }
                }
            }
        }

        return answer
    }

    private fun getDistance(finger: Int, number: Int): Int {
        return when (finger - number) {
            0 -> 0 // 이걸 빼먹어서 실패한 케이스가 절반 정도였다.
            1, -1, 3, -3 -> 1
            2, -2, 4, -4, 6, -6 -> 2
            7, -7, 5, -5, 9, -9 -> 3
            else -> 4
        }
    }
}