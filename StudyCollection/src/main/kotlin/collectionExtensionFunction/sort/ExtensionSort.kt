package collectionExtensionFunction.sort

/**
 * 순서와 정렬
 *
 * 컬렉션 목록을 뒤집거나 오름차순 혹은 내림차순으로 정렬할 수 있다.
 * reversed()는 요소의 순서를 거꾸로 해서 반환한다.
 * sorted()는 요소를 (숫자의 경우) 작은 수에서 큰 수로 반환하고,
 * (문자열의 경우) 알파벳순으로 정렬한 후 정렬된 후 정렬된 컬렉션을 반환한다.
 * sortedBy()는 특정한 비교식에 의해 정렬된 컬렉션을 반환한다.
 * 이와 반대로 sortedDescending과 sortedByDescending은 요소를 (숫자의 경우) 큰 수에서 작은 수로,
 * (문자열의 경우) z부터 a순서로 정렬해서 반환한다.
 */

fun main() {
    // reversed: 뒤집힌 순서로 컬렉션 반환
    val unsortedList = listOf(3, 2, 7, 5)
    println(unsortedList.reversed())

    // sorted: 요소를 정렬한 후 정렬된 컬렉션 반환
    println(unsortedList.sorted())

    // sortedDescending: 내림차순 정렬
    println(unsortedList.sortedDescending())

    // sortedBy: 특정 비교식에 의해 정렬된 컬렉션 반환
    println(unsortedList.sortedBy { it % 3 })
    println(unsortedList.sortedByDescending { it % 3 })
}