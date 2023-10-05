package problems.etc

import problems.Problem

/**
 * 피보나치 수열에서 n번 위치에 해당하는 숫자를 구하는 함수 fibonacci(n)
 * */
class Fibonacci : Problem() {
    private lateinit var array: LongArray

    // 0, 1, 1, 2, 3, 5, 8, 13, 21...
    override fun run() {
        val startTime = System.currentTimeMillis()
        val n = 44
        array = LongArray(n + 1)

        val result = dpFib(n)
        printResult("result = $result")

        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        println("calculate duration = $duration")
    }

    /**
     * 일반적인 recursive 방식의 피보나치 수열 함수,
     * 40이 넘어가면 심각하게 속도 저하
     * 중복되는 연산이 기하급수적으로 많아지기 때문
     * */
    private fun fibo(n: Int): Long {
        if (n == 0 || n == 1) return 1L

        return fibo(n - 1) + fibo(n - 2)
    }

    /**
     * Dynamic Programming(동적계획법) 적용한 함수,
     * 높은 수를 적용해도 매우 빠름
     * memoization을 사용해 중복 연산을 제거
     * */
    private fun dpFib(n: Int): Long {
        if (n == 0 || n == 1) return 1L

        if (array[n] == 0L) {
            array[n] = dpFib(n - 1) + dpFib(n - 2)
        }

        return array[n]
    }
}