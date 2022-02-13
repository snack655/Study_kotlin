package collectionExtensionFunction.collectionOperator

/**
 * 컬렉션의 연산
 *
 * 연산자를 사용하면 컬렉션에 대해 더하거나 빼는 등의 기능을 수행할 수 있다.
 */

fun main() {
    val list1: List<String> = listOf("one", "two", "three")
    val list2: List<Int> = listOf(1, 3, 4)
    val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)

    println(list1 + "four") // + 연산자를 사용한 문자열 요소 추가
    println(list2 + 1)  // + 연산자를 사용한 정수형 요소 추가
    println(list2 + listOf(5, 6, 7))    // 두 List의 병합
    println(list2 - 1)  // 요소의 제거
    println(list2 - listOf(3, 4, 5))    // 일치하는 요소의 제거
    println(map1 + Pair("Bye", 4))  // Pair()를 사용한 Map의 요소 추가
    println(map1 - "hello") // 일치하는 값의 제거
    println(map1 + mapOf("Apple" to 4, "Orange" to 5))  // 두 Map의 병합
    println(map1 - listOf("hi", "hello"))   // List에 일치하는 값을 Map에서 제거

    /**
     * 일반적인 연산자인 +와 -를 사용해 컬렉션 요소를 하나씩 더하거나 뺄 수 있고 컬렋녀
     * 자체를 더하거나 뺄 수 있다. 이때 listOf(), Pair(), mapOf() 등을 더하거나
     * 빼는 방법으로 요소를 병합하거나 제거할 수 있다.
     */
}