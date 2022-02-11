package array.useArray

/**
 * 배열 요소 접근하기
 *
 * 배열에 사용하는 Array 클래스는 코틀린의 표준 라이브러리이며
 * 다음과 같이 선언되어 있다.
 *
 * // 코틀린의 표준 라이브러리 Array.kt
 * public class Array<T> {
 *      public inline constructor(size: Int, init: (Int) -> T)
 *      public operator fun get(index: Int): T
 *      public operator fun set(index: Int, value: T): Unit
 *      public val size: Int
 *      public operator fun iterator(): Iterator<T>
 * }
 *
 * Array 클래스는 get()과 set() 메서드를 가지고 있는데
 * 이것은 요소에 접근하기 위한 게터/세터이다.
 * 그리고 대괄호를 사용해도 접근할 수 있다.
 * 이것은 연산자 오버로딩으로 정의되어 있기 때문이다.
 *
 * arr.get(index) -> value = arr[index]
 * arr.set(index) -> arr[index] = value
 *
 */

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(arr.get(2)) // 게터를 통한 접근
    println(arr[2]) // 연산자 오버로딩으로 대괄호를 통한 접근

    /**
     * 다차원 배열일 경우에는 대괄호를 하나 더 사용한다.
     */

    val arr2d = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
    println(arr2d[2][1])    // 8을 출력

    /**
     * 반대로 배열 안에 값을 설정할 경우.
     * 세터인 set()에 의해 처리된다.
     * 요소 접근과 마찬가지로 대괄호 표기법으로도 설정할 수 있다.
     */

    arr.set(2, 7)   // 인덱스 2번 요소를 값 7로 교체
    arr[0] = 8  // 인덱스 0번 요소를 값 8로 교체
    arr2d[2][1] = 2 // 다차원 배열의 요소를 교체
    println("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    /**
     * 반복문과 대괄호 표기법을 통해 요소를 순환하면서 읽을 수도 있다.
     * 인덱스는 항상 0부터 시작하므로 배열 요소의 전체 개수(크기)인 size에서 1을 빼야 한다.
     */

    for (i in arr.indices) {
        println("arr[$i] = ${arr[i]}")
    }
}

