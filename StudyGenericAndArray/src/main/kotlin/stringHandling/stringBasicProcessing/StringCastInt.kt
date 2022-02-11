package stringHandling.stringBasicProcessing

import java.lang.NumberFormatException

/**
 * 문자열을 정수로 변환하기
 *
 * 보통 입력받은 문자열이 숫자로만 이루어진 경우 코드상에서 처리하기 위해
 * 정수형으로 변환하는 경우가 많다.
 * 이때 toInt() 메서드를 통해 정수로 변환할 수 있다.
 * toInt() 메서드는 자바의 Integer.parseInt를 사용하고 있다.
 */

fun main() {
    val number: Int = "123".toInt()

    /**
     * 문자열 "123"을 정수값으로 변환 후 number 변수에 할당하고 있다.
     * 숫자가 아닌 경우
     * NumberFormatException 오류를 발생하기 때문에 try~catch 블록으로 처리해 주어야 한다.
     */

    try {
        "12w".toInt()   // 숫자가 아닌 문자 w가 포함되어 예외 발생
    } catch (e: NumberFormatException) {
        println(e.printStackTrace())
    }

    /**
     * 만일 숫자가 아닌 문자가 포함되었을 때 null을 반환 받고자 한다면 toInt() 대신에
     * toIntOrNull()을 사용해 프로그램이 중단되는 것을 방지할 수 있다.
     */
}