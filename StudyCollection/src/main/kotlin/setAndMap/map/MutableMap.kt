package setAndMap.map

/**
 * 가변형 mutableMapOf() 함수
 *
 * mutableMapOf() 함수는 추가, 삭제가 가능한 가변형 Map을 정의한다.
 * 이 함수는 MutableMap(K, V) 인터페이스 자료형을 반환한다.
 */

fun main() {
    // 가변형 Map의 선언 및 초기화
    val capitalCityMap: MutableMap<String, String>  // 선언할 때 키와 값의 자료형을 명시할 수 있음
            = mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap.values)  // 값만 출력
    println(capitalCityMap.keys)    // 키만 출력

    capitalCityMap.put("UK", "London")  // 요소의 추가
    capitalCityMap.remove("China")  // 요소의 삭제
    println(capitalCityMap)

    /**
     * MutableMap은 MutableCollection의 내용을 상속받지 않고 Map에서 확장되었다.
     * 따라서 Map으로부터 다음과 같은 메서드를 사용할 수 있다.
     *
     * MutableMap에서 사용하는 멤버 메서드
     *              멤버              |                       설명
     * put(key: K, value: V)         |  키와 값의 쌍을 Map에 추가한다.
     * remove(key: K)                |  키에 해당하는 요소를 Map에서 제가한다.
     * putAll(from: Map<out K, V>)   |  인자로 주어진 Map 데이터를 갱신하거나 추가한다.
     * clear()                       |  모든 요소를 지운다.
     *
     * putAll()을 사용하면 Map 객체를 통합할 수 있다.
     */

    val addData = mutableMapOf("USA" to "Washington")
    capitalCityMap.putAll(addData)
    println(capitalCityMap)
}