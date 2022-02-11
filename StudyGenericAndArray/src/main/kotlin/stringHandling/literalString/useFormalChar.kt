package stringHandling.literalString

/**
 * 형식 문자 사용하기
 *
 * 형식 문자를 사용하면 코드의 결괏값을 문자열의 원하는 형태로 나타낼 수 있다.
 * 코틀린에서 형식 문자를 사용하기 위해 String에 format()을 사용할 수 있다.
 *
 * inline fun String.format(vararg args:Any?): String (source)
 *
 * Any에 대한 매개변수를 가변적으로 받아들일 수 있는 vararg로 선언되어 있기 때문에
 * 필요한 만큼 형식 문자를 사용할 수 있다.
 *
 * 형식 문자의 종류
 * 종류
 * %b 참과 거짓의 Boolean 유형     %o 8진 정수        %g 10진 혹은 E 표기법의 실수
 * %d 부호 있는 정수               %t 날짜나 시간      %n 줄 구분
 * %f 10진 실수                  %c 문자            %s 문자열
 * %h 해시코드                   %e E 표기법의 실수   %x 16진 정수
 */

fun main() {
    val pi = 3.1415926
    val dec = 10
    val s = "hello"
    println("pi = %.2f, %3d, %s".format(pi, dec, s))
}