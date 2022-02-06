package generic.limitDataType

/**
 * 함수에서 형식 매개변수의 자료형 제한하기
 *
 * 함수를 선언하면서 형식 매개변수를 제한할 경우에는 클래스와 동일하게 형식 매개변수 옆에 콜론(:)을 사용해
 * 제한할 특정 자료형을 지정
 */

fun <T: Number> addLimit(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main() {
//    val result = addLimit("abc", "def") {a, b -> a + b} // 제한된 자료형으로 인해 오류 발생!
    val result = addLimit(3, 2) {a, b -> a + b} // 제한된 자료형으로 인해 오류 발생!
}