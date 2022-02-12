package list.createImmutableList

/**
 * listOfNotNull() 함수
 *
 * listOfNotNull()로 초기화하면 null을 제외한 요소만 반환해 List를 구성할 수 있다.
 * 다음 코드에서는 null이 아닌 요소만 골라 컬렉션을 초기화한다.
 */

fun main() {
    val nonNullsList: List<Int> = listOfNotNull(2, 45, 2, null, 5, null)
    println(nonNullsList)
}
