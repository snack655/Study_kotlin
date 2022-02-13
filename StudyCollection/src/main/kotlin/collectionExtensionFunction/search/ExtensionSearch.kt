package collectionExtensionFunction.search

/**
 * 요소의 처리와 검색
 *
 * element 관련 연산은 보통 인덱스와 함께 해당 요소의 값을 반환한다.
 * 식에 따라 처리하거나 인덱스를 벗어나면 null을 반환하도록 지정할 수 있다.
 * 주어진 인덱스에 해당하는 요소를 반환하는 elementAt()을 사용할 때 인덱스 범위를 벗어나면
 * IndexOutOfBoundsException 오류가 발생한다.
 * elementAtOrElse()는 인덱스 범위를 벗어나도 식에 따라 결과를 반환하며,
 * elementAtOrNull()은 인덱스 범위를 벗어나는 경우 null을 반환한다.
 */

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100), Pair("D", 200))
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

    // elementAt: 인덱스에 해당하는 요소 반환
    println("elementAt: " + list.elementAt(1))

    // elementAtOrElse: 인덱스를 벗어나는 경우 식에 따라 결과 반환
    println("elementAtOrElse: " + list.elementAtOrElse(10) { 2 * it })

    // elementAtOrNull: 인덱스를 벗어나는 경우 null 반환
    println("elementAtOrNull: " + list.elementAtOrNull(10))

    /**
     * 다음은 각 식과 일치하는 첫 번째(first)나 마지막(last) 요소 값을 반환하거나
     * 식에 일치되는 값이 없는 경우에는 firstOrNull이나 lastOrNull을 이용해 null을 반환하는
     * 메서드를 사용한 소스 코드이다.
     */
    // first: 식에 일치하는 첫 요소 반환
    println("first: " + listPair.first { it.second == 200 })

    // last: 식에 일치하는 마지막 요소 반환
    println("last: " + listPair.last { it.second == 200 })

    // firstOrNull: 식에 일치하지 않는 경우 null 반환
    println("firstOrNull: " + listPair.firstOrNull { it.first == "E" })

    // lastOrNull: 식에 일치하지 않는 경우 null 반환
    println("lastOrNull: " + listPair.lastOrNull { it.first == "E" })

    /**
     * 반대로 주어진 요소에 해당하는 인덱스를 반환하는 방법을 알아보자.
     * 동일한 요소가 여러 개 있을 수 있으므로 일치하는 첫 요소나 마지막 요소의 인덱스를 반환한다.
     * indexOf()는 인자에 지정된 요소에 대한 첫 인덱스를 반환하고,
     * indexOfFirst()는 람다식에 일치하는 해당 요소 중 첫 번째 인덱스를 반환하며,
     * 만약 해당하는 데이터가 없으면 -1을 반환한다.
     * lastIndexOf()는 인자에 지정된 요소에 대한 마지막 인덱스를 반환하고,
     * indexOfLast()는 람다식에 일치하는 해당 요소 중 마지막 인덱스의 값을 반환하며,
     * 마찬가지로 해당하는 데이터가 없으면 -1을 반환한다.
     */
    // indexOf: 주어진 요소에 일치하는 첫 인덱스 반환
    println("indexOf: " + list.indexOf(4))

    // indexOfFirst: 람다식에 일치하는 첫 요소의 인덱스 반환, 없으면 -1
    println("indexOfFirst: " + list.indexOfFirst { it % 2 == 0 })

    // lastIndexOf: 주어진 요소에 일치하는 가장 마지막 인덱스 반환
    println("lastIndexOf: " + listRepeated.lastIndexOf(5))

    // indexOfLast: 람다식에 일치하는 마지막 요소의 인덱스 반환, 없으면 -1
    println("indexOfLast: " + list.indexOfLast { it % 2 == 0 })

    /**
     * single은 해당 조건식에 일치하는 요소를 하나 반환한다.
     */
    // single: 람다식에 일치하는 요소 하나 반환
    println("single: " + listPair.single { it.second == 100 })
    println("singleOrNull: " + listPair.singleOrNull { it.second == 500 })

    /**
     * 검색을 위한 2개의 메서드를 사용해 보자.
     * binarySearch()는 인자로 주어진 요소에 대해 이진 탐색 후 요소를 반환한다.
     * find는 조건식을 만족하는 첫 번째 검색된 요소를 반환하고,
     * 없으면 null을 반환한다.
     * 다만 binarySearch는 중복된 요소가 있는 경우에 해당 요소가 원하는 순서에 있는 요소인지는 보장하지 않는다.
     */
    // binarySearch: 요소에 대해 이진 탐색 후 인덱스 반환
    println("binarySearch: " + list.binarySearch(3))

    // find: 조건식을 만족하는 첫 번째 검색된 요소 반환, 없으면 null
    println("find: " + list.find { it > 3 })
}