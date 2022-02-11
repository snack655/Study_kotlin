package stringHandling.stringBasicProcessing

/**
 * 문자열 비교하기
 *
 * 문자열을 비교하려면 s1.compareTo(s2)를 사용할 수 있다.
 * s1과 s2가 같다면 0을 반환하고, s1이 s2보다 작으면 양수,
 * 그렇지 않으면 음수를 반환한다.
 */

fun main() {
    var s1 = "Hello Kotlin"
    var s2 = "Hello KOTLIN"

    // 같으면 0, s1<s2 이면 양수, 반대면 음수를 반환
    println(s1.compareTo(s2))
    println(s1.compareTo(s2, true)) // 대소문자 무시
}