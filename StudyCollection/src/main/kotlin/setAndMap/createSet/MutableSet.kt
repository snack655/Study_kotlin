package setAndMap.createSet

/**
 * 가변성 mutableSetOf() 함수
 *
 * mutableSetOf() 함수로 요소의 추가 및 삭제가 가능한 집합을 만들 수 있다.
 * mutableSetOf()는 MutableSet 인터페이스 자료형을 반환하는데,
 * 내부적으로 자바의 LinkedHashSet를 만들어 낸다.
 */

fun main() {
    // 가변성 Set 정의하기
    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    // 요소의 추가
    animals.add("Dog")  // 요소 중 "Dog"가 이미 존재하므로 변화가 없음
    println(animals)

    // 요소의 삭제
    animals.remove("Python")
    println(animals)
}