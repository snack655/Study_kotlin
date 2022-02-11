package array.arrayFlatten

/**
 * 배열 평탄화하기
 *
 * 보통 다차원 배열을 단일 배열로 만드는 것을 '배열을 평탄화(flatten)한다'라고 말한다.
 * 코틀린에서는 Array에 flatten() 메서드를 통해 평탄화 기능을 지원한다.
 */

fun main() {
    val numbers = arrayOf(1, 2, 3)
    val strs = arrayOf("one", "two", "three")
    val simpleArray = arrayOf(numbers, strs)    // 2차원 배열
    simpleArray.forEach { println(it.contentToString()) }

    val flattenSimpleArray = simpleArray.flatten()  // 단일 배열로 변환하기
    println(flattenSimpleArray)
}