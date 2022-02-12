package setAndMap.setOfDataStructures

/**
 * linkedListSetOf() 함수
 *
 * linkedSetOf() 함수는 자바의 LinkedHashSet 자료형을 반환하는 헬퍼 함수이다.
 * 이름에서 알 수 있듯이 자료구조 중 하나인 링크드 리스트(Linked list)를 사용해 구현된 해시 테이블에
 * 요소를 저장한다. 저장된 순서에 따라 값이 정렬되며 HashSet, TreeSet보다 느리다.
 * 다만 자료구조상 다음 데이터를 가리키는 포인터 연결을 통해 메모리 저장 공간을 좀 더 효율적으로 사용할 수 있다.
 */

fun main() {
    // Linked list를 이용한 HashSet
    val intsLinkedHashSet: LinkedHashSet<Int> = linkedSetOf(35, 21, 76, 26, 75)
    intsLinkedHashSet.add(4)
    intsLinkedHashSet.remove(21)

    println(intsLinkedHashSet)
    intsLinkedHashSet.clear()
    println(intsLinkedHashSet)
}