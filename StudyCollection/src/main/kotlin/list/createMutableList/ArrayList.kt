package list.createMutableList

/**
 * 가변형 arrayListOf() 함수
 *
 * 가변형 헬퍼 함수를 사용하면 요소를 손쉽게 추가하거나 삭제할 수 있는 List를 생성할 수 있다.
 * arrayListOf()는 가변형 List를 생성하지만 이것의 반환 자료형은 자바의 ArrayList이다.
 * 헬퍼 함수의 원형은 다음과 같다.
 *
 * public fun <T> arrayListOf(vararg elements: T): ArrayList<T>
 */

fun main() {
    // 가변형 List를 생성하고 자바의 ArrayList로 반환
    val stringList: ArrayList<String> = arrayListOf<String>("Hello", "Kotlin", "Wow")
    stringList.add("Java")  // 추가
    stringList.remove("Hello")  // 삭제
    println(stringList)
}