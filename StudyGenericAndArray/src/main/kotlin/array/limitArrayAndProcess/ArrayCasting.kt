package array.limitArrayAndProcess

/**
 * 다양한 자료형을 위한 Any로 선언된 자료형
 *
 * 일단 자료형이 지정된 배열은 다른 자료형으로 변환할 수 없다.
 * 단, Any 자료형으로 만들어진 배열은 기존 자료형을 다른 자료형을 지정할 수 있다.
 */

fun main() {
    val b = Array<Any>(10) { 0 }
    b[0] = "Hello World"
    b[1] = 1.1
    println(b[0])
    println(b[1])
    println(b[2])
}

/**
 * Any를 사용하면 한 번에 기본적인 초기화를 하고 나중에 원하는 자료형으로 요소를 초기화할 수 있으므로 편리하다.
 */