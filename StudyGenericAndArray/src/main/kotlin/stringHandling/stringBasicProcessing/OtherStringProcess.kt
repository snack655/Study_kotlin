package stringHandling.stringBasicProcessing

/**
 * 기타 문자열 처리
 *
 * 그 밖에 기본 String의 문자열 처리 메서드로 소문자/대문자 변경(lowerCase,upperCase),
 * 특정 문자 단위로 잘라내기(split), 앞뒤 공백 제거(trim) 등의 메서드를 사용할 수 있다.
 * 특정 문자(여기서는 빈 칸)를 단위로 문자열을 잘라내는 예를 보자.
 */

fun main() {
    var deli = "Welcome to Kotlin"
    val sp = deli.split(" ")
    println(sp)

    /**
     * split()를 통해 공백 문자를 기준으로 문자열을 잘라내 sp에 할당하고 있다.
     * 이때 sp는 컬렉션 List<String>으로 추론되어 할당된다.
     * 결과는
     * [Welcome, to, Kotlin]
     *
     * 만일 하나 이상의 분리 문자를 지정하려면 split() 인수에 다음과 같이 지정할 수 있다.
     * str.split("=", "-")
     */
}