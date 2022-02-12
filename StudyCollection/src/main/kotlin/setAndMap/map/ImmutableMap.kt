package setAndMap.map

/**
 * 불변형 mapOf() 함수
 *
 * mapOf() 함수는 불변형 Map 컬렉션을 만들 수 있다.
 * 키와 값의 쌍으로 이루어진 목록을 만들기 위해서 다음과 같이 사용할 수 있다.
 *
 * val map: Map<키 자료형, 값 자료형> = mapOf(키 to 값[, ...])
 */

fun main() {
    // 불변형 Map의 선언 및 초기화
    val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
    for ((key, value) in langMap) { // 키와 값의 쌍의 출력
        println("key=$key, value=$value")
    }

    println("langMap[22] = ${langMap[22]}") // 키 22에 대한 값 출력
    println("langMap.get(22) = ${langMap.get(22)}") // 위와 동일한 표현
    println("langMap.keys = ${langMap.keys}")   // 맵의 모든 키 출력
}

/**
 * Map에서 사용하는 멤버 프로퍼티와 메서드
 *              멤버              |                       설명
 * size                          |  Map 컬렉션의 크기를 반환한다.
 * keys                          |  Set의 모든 키를 반환한다.
 * values                        |  Set의 모든 값을 반환한다.
 * isEmpty()                     |  Map이 비어 있는지 확인하고 비어 있으면 true를, 아니면 false를 반환한다.
 * containsKey(key: K)           |  인자에 해당하는 키가 있다면 true를, 없으면 false를 반환한다.
 * containsValue(value: V)       |  인자에 해당하는 값이 있다면 true를, 없으면 false를 반환한다.
 * get(key: K)                   |  키를 해당하는 값을 반환하며, 없으면 null을 반환한다.
 */