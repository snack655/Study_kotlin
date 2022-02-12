package setAndMap.createSet

/**
 * 불변형 setOf() 함수
 *
 * setOf() 함수는 읽기 전용인 불변형 Set<T> 자료형을 반환한다.
 */

fun main() {
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14, 'c')   // 자료형 혼합 초기화
    var intSet: Set<Int> = setOf<Int>(1, 5, 5)  // 정수형만 초기화

    println(mixedTypesSet)
    println(intSet)

    /**
     * setOf() 에서는 자료형을 혼합하거나 특정 자료형을 지정할 수 있다.
     * 중복 요소를 허용하지 않으므로 intSet에서는 중복된 요소인 5가 결과에서 하나만 나타난다.
     */
}