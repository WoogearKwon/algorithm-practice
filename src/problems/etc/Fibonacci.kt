package problems.etc

import problems.Problem

/**
 * 피보나치 수열에서 n번 위치에 해당하는 숫자를 구하는 함수 fibonacci(n)
 * */
class Fibonacci : Problem() {

    override fun run() {
        val result = fibonacci(3)
        println("result = $result")
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21...
    private fun fibonacci(n: Int): Int {
        if (n == 0 || n == 1) return n

        return fibonacci(n - 1) + fibonacci(n - 2)
    }
}