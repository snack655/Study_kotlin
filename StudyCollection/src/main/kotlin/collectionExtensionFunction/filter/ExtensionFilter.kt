package collectionExtensionFunction.filter

/**
 * 요소의 필터와 추출
 */

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    /**
     * 특정 요소 골라내기
     *
     * 필터에 관련된 연산은 종류가 많은데 특정 식에 따라 요소를 골라내거나,
     * 인덱스와 함께 추출하거나, 추출 후 가변형 컬렉션으로 변환하거나,
     * Map에서 키 혹은 값으로 추출, 요소의 자료형에 따라 추출할 수 있다.
     */

    // filter: 식에 따라 요소를 골라내기
    println(list.filter { it % 2 == 0 })    // 짝수만 골라내기
    println(list.filterNot { it % 2 == 0 }) // 식 이외에 요소 골라내기
    println(listWithNull.filterNotNull())   // null을 제외

    /**
     * 특정 인덱스만 함께 추출하도록 메서드 이름에 Indexed가 붙은 메서드를 사용해 보자.
     */
    // filterIndexed: 인덱스와 함께 추출
    println("filterIndexed: " + list.filterIndexed { idx, value -> idx != 1 && value % 2 == 0 })

    // filterIndexedTo: 추출 후 가변형 컬렉션으로 변환
    val mutList = list.filterIndexedTo(mutableListOf()) { idx, value -> idx != 1 && value % 2 == 0 }
    println("filterIndexedTo: $mutList")

    /**
     * Map에서 키와 값에 대한 필터를 추가해 보자.
     */
    // filterKeys/filterValues: Map의 키, 값에 따라 추출
    println("filterKeys: " + map.filterKeys { it != 11 })   // 키 11을 제외한 요소
    println("filterValues: " + map.filterValues { it == "Java" })   // 값이 "Java"인 요소

    /**
     * 여러 자료형 중 원하는 자료형을 골라낼 수 있는 filterIsInstance<T>()를 사용해 보자.
     * 아래 코드에서는 여러 가지 자료형이 포함된 listMixed에서 String형만 골라내 출력한다.
     */
    // filterIsInstance: 여러 자료형의 요소 중 원하는 자료형을 골라냄
    println("filterIsInstance: " + listMixed.filterIsInstance<String>())

    /**
     * 특정 범위를 잘라내거나 반한하기
     *
     * slice()는 특정 범위의 인덱스를 가진 List를 인자로 사용해 기존 List에서 요소들을 잘라낼 수 있다.
     */
    // slice: 특정 인덱스의 요소들을 잘라서 반환하기
    println("slice: " + list.slice(listOf(0, 1, 2)))

    /**
     * take 관련 연산을 사용하면 n개의 요소를 가진 List를 반환한다.
     * 이때 마지막 요소부터 반환하거나 조건식에 따라 반환할 수 있다.
     */
    // take: n개의 요소를 반환
    println(list.take(2))   // 앞 두 요소 반환
    println(list.takeLast(2))   // 마지막 두 요소 반환
    println(list.takeWhile { it < 3 })  // 조건식에 따른 반환

    /**
     * 특정 요소 제외하기
     *
     * drop은 take와는 정반대로 처음부터 n개의 요소를 제외하고 List를 반환한다.
     */
    // drop: 처음부터 n개의 요소를 제외한 List 반환
    println(list.drop(3))   // 앞의 요소 3개 제외하고 반환
    println(list.dropWhile { it < 3 })  // 3 미만을 제외하고 반환
    println(list.dropLastWhile { it > 3 })  // 3 초과를 제외하고 반환

    /**
     * 각 요소의 반환
     *
     * 각 요소는 componentN()과 대응하기 때문에 이것을 사용해 요소를 반환할 수 있다.
     * N은 인덱스 번호가 아닌 1부터 시작하는 요소의 순서 번호이다.
     * 따라서 요소가 5개라면 1부터 5까지 가진다.
     */
    println("component1(): " + list.component1())   // 첫 번째 요소의 1 반환

    /**
     * 합집합과 교집합
     *
     * distinct()는 여러 중복 요소가 있는 경우 1개로 취급해 다시 컬렉션 List로 반환한다.
     * 합집합과 같은 원리이다.
     * 반면 intersect()는 교집합의 원리로, 겹치는 요소만 골라내 List를 반환한다.
    */
    // distinct: 중복 요소는 하나로 취급해 List 반환
    println("distinct: " + listRepeated.distinct())

    // intersect: 교집합 요소만 골라냄
    println("intersect: " + list.intersect(listOf(5, 6, 7, 8)))
}