package collectionExtensionFunction.splitMerge

/**
 * 컬렉션의 분리와 병합
 *
 * union()은 두 List 컬렉션을 병합하고 중복된 요소 값은 하나만 유지한다.
 * plus()나 + 연산자를 사용하면 중복 요소를 포함해 합치게 된다.
 */

fun main() {
    val list1 = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf(2, 2, 3, 4, 5, 5, 6, 7)

    // union: 두 List를 합침(중복 요소는 하나만)
    println(list1.union(list2)) // Set 컬렉션을 반환

    // plus: 두 List를 합침(중복 요소 포함), + 연산자와 같음
    println(list1.plus(list2))  // list 컬렉션을 반환

    /**
     * partition은 주어진 조건식의 결과(true와 false)에 따라 List 컬렉션을
     * 2개로 분리한다. 이때 조건식에서 true에 해당하는 값은 첫 번째 위치에 반환하고,
     * false에 해당하는 값은 두 번째 위치에 반환한다.
     * 분리된 2개의 List 컬렉션은 Pair로 반환된다.
     */
    // partition: 주어진 식에 따라 2개의 컬렉션으로 분리해 Pair로 반환
    val part = list1.partition { it % 2 == 0 }
    println(part)

    /**
     * zip()은 2개의 컬렉션에서 동일한 인덱스끼리 Pair를 만들어 반환한다.
     * 이때 요소의 개수가 가장 적은 컬렉션에 맞춰 Pair가 구성된다.
     */
    // zip: 동일 인덱스끼지 Pair를 만들어 반환
    val zip = list1.zip(listOf(7, 8))
    println(zip)
}