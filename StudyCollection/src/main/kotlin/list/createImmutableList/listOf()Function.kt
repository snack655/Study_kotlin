package list.createImmutableList

/**
 * listOf() 함수
 *
 * 먼저 불변형 List를 만들 수 있는 헬퍼 함수 listOf()의 원형을 살펴보자.
 * public fun <T> listOf(vararg elements: T): List<T>
 *
 * vararg는 가변 인자를 받을 수 있기 때문에 원하는 만큼 요소를 지정할 수 있다.
 * 값을 반환할 때는 List<T>를 사용한다.
 * 형식 매개변수<T>는 원하는 자료형을 지정해 선언할 수 있다.
 * 사용하지 않으면 <Any>가 기본값이며 어떤 자료형이든 혼합할 수 있다.
 */

fun main() {
    // 불변형 List의 사용
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    var names: List<String> = listOf("one", "two", "three")

    for (name in names) {
        println(name)
    }
    for (num in numbers) print(num) // 한 줄에서 처리하기
    println()   // 내용이 없을 때는 한 줄 내리는 개행

    /**
     * 또한 다음과 같이 서로 다른 자료형을 가진 요소를 함쳐서 선언할 수도 있다.
     * 이때 mixedTypes는 형식 매개변수가 <Any>를 가진다.
     */

    var mixedTypes = listOf("Hello", 1, 2.445, 's')
}