package collectionExtensionFunction.mapping

/**
 * 요소의 매핑
 *
 * 매핑에 사용하는 .map()은 주어진 컬렉션의 요소에 일괄적으로 .map()에 있는 식을 적용해
 * 새로운 컬렉션을 만들 수 있게 하는 메서드이다.
 * forEach()와 비슷해 보이나 컬렉션을 전혀 건드리지 않는다는 점에서 좀 더 안전하다.
 */

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listWithNull = listOf(1, null, 3, null, 5, 6)

    /**
     * 먼저 매핑 관련 3개의 메서드를 사용해 새로운 컬렉션을 반환해 보자.
     */
    // map: 컬렉션에 주어진 식을 적용해 새로운 컬렉션 반환
    println(list.map { it * 2 })

    // mapIndexed: 컬렉션에 인덱스를 포함하고 주어진 식을 적용해 새로운 컬렉션 반환
    val mapIndexed = list.mapIndexed { index, it -> index * it }
    println(mapIndexed)

    // mapNotNull: null을 제외하고 식을 적용해 새로운 컬렉션 반환
    println(listWithNull.mapNotNull { it?.times(2) })

    /**
     * flatMap은 각 요소에 식을 적용한 후 이것을 다시 하나로 합쳐 새로운 컬렉션을 반환한다.
     */
    // flatMap: 각 요소에 식을 적용한 후 다시 합쳐 새로운 컬렉션을 반환
    println(list.flatMap { listOf(it, 'A') })
    val result = listOf("abc", "12").flatMap { it.toList() }
    println(result)

    /**
     * groupBy는 주어진 식에 따라 요소를 그룹화하고 이것을 다시 Map으로 반환한다.
     */
    // groupBy: 주어진 함수의 결과에 따라 그룹화하여 map으로 반환
    val grpMap = list.groupBy { if (it % 2 == 0) "even" else "odd" }
    println(grpMap)
}