package problems.kakao

import problems.Problem

class HouseTwoKt : Problem() {

    override fun run() {
        val template = "{a} {b} {c} {d} {i}"
//        val template = "this is {template} {template} is {state}"
        val variables = arrayOf(
//            arrayOf("template", "{state}"),
//            arrayOf("state", "{templates}"),
            arrayOf("b", "{c}"),
            arrayOf("a", "{b}"),
            arrayOf("e", "{f}"),
            arrayOf("h", "i"),
            arrayOf("d", "{e}"),
            arrayOf("f", "{d}"),
            arrayOf("c", "d")
        )
        val answer = "d d d {d} {i}"
//        val answer = "this is {templates} {templates} is {templates}"

        val result = solution(template, variables)
        println("result = $result")
        printResult(answer == result)
    }

    fun solution(tstring: String, variables: Array<Array<String>>): String {
        var answer = ""

        val variableMap = HashMap<String, String>() // 변수 key와 수정될 변수를 담는다.
        for (variable in variables) {
            variableMap[variable[0]] = variable[1]
        }

        val resultMap = HashMap(variableMap) // 변수를 적용했을 때 최종적으로 바뀔 값을 넣을 map을 varialbeMap을 복사해서 만든다.
        for (i in variables.indices) {
            for (result in resultMap) {
                if (result.value.startsWith("{")) {
                    val key = getKey(result.value)
                    resultMap[result.key] =
                        variableMap.getOrDefault(key, result.value) // variableMap 안에 key에 해당하는  값이 없다면 그냥 value를 넣는다.
                }
            }
        }

        for (template in tstring.split(" ")) {
            if (answer.isNotEmpty()) answer += " "

            val word = resultMap.getOrDefault(getKey(template), template)
            if (word.startsWith("{") && variableMap.containsKey(getKey(word))) { // 무한반복인 경우 초기값을 넣어준다.
                answer += template
                continue
            }

            answer += word // 나머지의 경우에는 최종 변수를 넣어준다.
        }

        return answer
    }

    private fun getKey(str: String): String { // 예: {xxx}라면 괄호 안의 xxx만 리턴한다.
        return str.substring(1, str.lastIndex)
    }
}