package list.createImmutableList

/**
 * List는 Collection 인터페이스의 메서드를 오버리이딩해 구현하고 있다.
 * List는 추가로 다음과 같은 메서드를 가지고 있다.
 *
 * List의 주요 멤버 메서드
 *              멤버 메서드                  |                   설명
 * get(index: Int)                        | 특정 인덱스를 인자로 받아 해당 요소를 반환한다.
 * indexOf(element: E)                    | 인자로 받은 요소가 첫 번째로 나타나는 인덱스를 반환하며, 없으면 -1을 반환한다.
 * lastIndexOf(element: E)                | 인자로 받은 요소가 마지막으로 나타나는 인덱스를 반환하고, 없으면 -1을 반환한다.
 * listIterator()                         | 목록에 있는 iterator를 반환한다.
 * subList(fromIndex: Int, toIndex: Int)  | 특정 인덱스의 from과 to 범위에 있는 요소 목록을 반환한다.
 */

fun main() {
    val names: List<String> = listOf("one", "two", "three")

    println(names.size) // List 크기
    println(names.get(0))   // 해당 인덱스의 요소 가져오기
    println(names.indexOf("three")) // 해당 요소의 인덱스 가져오기
    println(names.contains("two"))  // 포함 여부 확인 후 포함되어 있으면 true 반환
}