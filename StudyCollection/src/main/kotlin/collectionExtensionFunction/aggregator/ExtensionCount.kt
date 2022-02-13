package collectionExtensionFunction.aggregator

/**
 * 요소의 처리와 집계
 *
 * 요소를 집계하는 확장 함수로는
 * forEach, forEachIndexed, onEach, count, max, min, maxBy, minBy, fold, reduce, sumBy() 등이 있다.
 */

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    /**
     * 요소의 순환
     *
     * 먼저 forEach와 forEachIndexed를 살펴보자.
     */

    // forEach: 각 요소를 람다식으로 처리
    list.forEach { print("$it\t") }
    println()
    list.forEachIndexed { index, value -> println("index[$index]: $value") }    // 인덱스 포함

    /**
     * forEach는 각 요소를 람다식으로 처리한 후 컬렉션을 반환하지 않는다.
     * onEach를 사용하면 각 요소를 람다식으로 처리하고 각 컬렉션을 반환 받을 수 있다.
     */

    // onEach: 각 요소를 람다식으로 처리 후 컬렉션으로 반환
    val returnedList = list.onEach { print(it) }
    println()
    val returnedMap = map.onEach { println("key: ${it.key}, value: ${it.value}") }
    println("returnedList = $returnedList")
    println("returnedMap = $returnedMap")

    /**
     * 요소의 개수 반환하기
     *
     * 특정 조건에 일치하는 요소의 개수를 반환하는 count를 사용해보자.
     */

    // count: 조건에 맞는 요소 개수 반환
    println(list.count { it % 2 == 0 })

    /**
     * 최댓값과 최솟값의 요소 반환하기
     *
     * 최댓값과 최솟값을 반환하는 max, min과 maxBy, minBy를 사용해 보자.
     */

    // max/min: 최댓값 요소와 최솟값 요소의 반환
    println(list.maxOrNull())   // 6
    println(list.minOrNull())   // 1

    // maxBy/minBy: 최댓값과 최솟값으로 나온 요소 it에 대한 식의 결과
    println("maxBy: " + map.maxByOrNull { it.key })   // 키를 기준으로 최댓값
    println("minBy: " + map.minByOrNull { it.key })   // 키를 기준으로 최솟값

    /**
     * maxBy 및 minBy는 람다식에 의해 컬렉션의 요소를 처리하며,
     * 이 소스 코드에서는 키를 기준으로 최댓값과 최솟값인 요소를 반환한다.
     *
     *
     * 각 요소에 정해진 식 적용하기
     *
     * 초깃값과 정해진 식에 따라 요소에 치리하기 위해 fold와 reduce를 사용한다.
     * fold는 초깃값과 정해진 식에 따라 처음 요소부터 끝 요소에 적용해 값을 반환하며,
     * reduce는 fold와 동일 하지만 초깃값을 사용하지 않는다.
     */

    // fold: 초깃값과 정해진 식에 따라 처음 요소부터 끝 요소에 적용하며 값을 생성
    println(list.fold(4) { total, next -> total + next })    // 4 + 1 + ... + 6 = 25
    println(list.fold(1) { total, next -> total * next })    // 1 * 1 * 2 * ... * 6 = 720

    // foldRight: fold와 같고 마지막 요소에서 처음 요소로 반대로 적용
    println(list.foldRight(4) { total, next -> total + next })
    println(list.foldRight(1) { total, next -> total * next })

    // reduce: fold와 동일하지만 초깃값을 사용하지 않음
    println(list.reduce { total, next -> total + next })
    println(list.reduceRight { total, next -> total + next })

    // index로 같이 처리
    println(list.foldIndexed(4) { idx, total, next -> idx+total+next })

    /**
     * 모든 요소 함산하기
     *
     * 식에서 도출된 모든 요소를 함한 결과를 반환하려면 sumBy를 사용한다.
     */

    // sumBy: 식에 의해 도출된 모든 요소를 합산
    println(listPair.sumOf { it.second })
}