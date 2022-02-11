package array.limitArrayAndProcess

/**
 * 멤버 메서드를 통한 배열 순환하기
 *
 * 반복문을 사용한 배열의 순환 말고도 배열의 멤버 메서드인 forEach()와 forEachIndexed()를
 * 사용해 요소를 순환할 수 있다.
 * forEach()는 요소 개수만큼 지정한 구문을 반복 실행,
 * forEachIndexed()는 순환하며 인덱스까지 출력한다.
 */

fun main() {
    val arr = Array<Any>(10) { i -> i+1 }
    // forEach()에 의한 요소 순환
    arr.forEach { element -> print("$element ") }

    // forEachIndexed()에 의한 요소 순환
    arr.forEachIndexed { i, e -> println("arr[$i] = $e") }

    /**
     * 반복을 위한 요소를 처리하는 iterator()를 사용할 수도 있다.
     */

    // iterator()를 사용한 요소 순환
    val iter: Iterator<Any> = arr.iterator()
    while (iter.hasNext()) {
        val e = iter.next()
        print("$e ")
    }
}