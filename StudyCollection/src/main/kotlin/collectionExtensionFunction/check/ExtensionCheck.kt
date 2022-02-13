package collectionExtensionFunction.check

/**
 * 요소의 검사
 */

fun main() {
    val list = listOf(1,2 ,3 ,4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    /**
     * 요소의 일치 여부 검사하기
     *
     * all과 any는 모든 요소가 일치하거 최소한 하나 혹은 그 이상이 일치하는지 검사하는 연산이다.
     * all은 람다식에서 모든 요소가 일치할 때 true를 반환하며,
     * any는 최소한 하나 혹은 그 이상의 특정 요소가 일치하면 true를 반환한다.
     */

    // all: 모든 요소가 일치해야 true를 반환
    println(list.all { it < 10 })
    println(list.all { it % 2 == 0 })
    // any: 최소한 하나 혹은 그 이상의 특정 요소가 일치해야 true를 반환
    println(list.any { it % 2 == 0 })
    println(list.any { it > 10 })

    /**
     * 특정 요소의 포함 및 존재 여부 검사하기
     *
     * 컬렉션에 특정 요소가 포함되어 있는지 검사하기 위해 contains()를 사용할 수 있다.
     * 요소가 포함되어 있으면 true를 반환한다.
     * contains()는 범위 연산자 in을 사용해서 요소의 포함 여부를 확인할 수도 있다.
     * 모든 요소가 포함되어 있는지 검사하려면 containsAll()을 사용한다.
     */

    // contains: 요소가 포함되어 있으면 true를 반환
    println("contains: " + list.contains(2))
    println(2 in list)
    println(map.contains(11))
    println(11 in map)

    // containsAll: 모든 요소가 포함되어 있으면 true를 반환
    println("containsAll: " + list.containsAll(listOf(1, 2, 3)))

    /**
     * 컬렉션에 요소가 존재하는지 여부를 검사하려면 none(), isEmpty(), isNotEmpty()를 사용!
     * none()은 검사했을 때 요소가 없으면 true를,
     * 있으면 false를 반환한다.
     * isEmpty()와 isNotEmpty()는 컬렉션이 비어 있는지 아닌지에 따라 true를 반환!
     */

    // none: 요소가 없으면 true, 있으면 false를 반환
    println("none: " + list.none())
    println("none: " + list.none { it > 6 })    // 6은 이상이 없으므로 true를 반환

    // isEmpty/isNotEmpty: 컬렉션이 비어 있는지 아닌지 검사
    println(list.isEmpty())
    println(list.isNotEmpty())
}