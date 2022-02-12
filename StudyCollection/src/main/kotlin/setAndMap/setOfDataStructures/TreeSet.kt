package setAndMap.setOfDataStructures

import java.util.*

/**
 * sortedSetOf() 함수
 *
 * sortedSetOf() 함수는 자바의 TreeSet 컬렉션을 정렬된 상태로 반환한다.
 * TreeSet는 저장된 데이터의 값에 따라 정렬되는데,
 * 일존의 개선된 이진 탐색 트리(Binary-search Tree)인
 * 레드 블랙 트리(RB tree: Red-Black tree) 알고리즘을 사용해 자료구조를 구성한다.
 *
 * 기존의 이진 탐색 트리가 한쪽으로 치우친 트리 구조를 가지게 되는 경우 트리 높이만큼
 * 시간이 걸리게 되는 최악의 경우가 생긴다.
 * 레드 블랙 트리는 요소를 빨간색과 검은색으로 구분해 치우친 결과 없이
 * 트리의 요소를 배친한다.
 * 따라서 최악으로 요소 배치가 되어도 검색 등의 처리에서 일정한 시간을 보장하는 자료구조이다.
 * HashSet보다 성능이 좀 떨어지고 데이터를 추가하거나 삭제하는 데 시간이 걸리지만
 * 검색과 정렬이 뛰어나다는 장점이 있다.
 */

fun main() {
    // 자바의 java.util.TreeSet 선언
    val intsSortedSet: TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    println("intsSortedSet = $intsSortedSet")

    intsSortedSet.clear()   // 모든 요소 삭제
    println("intsSortedSet = $intsSortedSet")
}