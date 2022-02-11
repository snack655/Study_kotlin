package stringHandling.stringBasicProcessing

/**
 * 문자열 추출하고 병합하기
 *
 * 문자열은 특수한 형태의 문자 배열이라고 했다.
 * 따라서 문자열의 각 문자는 특정 인덱스를 가진다.
 * 만일 문자열에서 특정 범위의 문자열을 추출하기 위해 substring()이나 subSequence()를
 * 사용해 특정 인덱스의 범위를 지정할 수 있다.
 *
 * String.substring(인덱스 범위 지정): String
 * CharSequence.subSequence(인덱스 범위 지정): CharSequence
 */

fun main() {
    var s = "abcdef"
    println(s.substring(0..2))  // 인덱스 0번~2번 범위의 abc 반환

    /**
     * 문자열은 메모리가 고정되어 있으므로 문자열의 특정 인덱스를 바꿔 할당할 수 없으나
     * 새로 할당할 때 바꾸면 가능하다.
     * 먼저 특정 문자를 바꾸고 + 연산자를 사용해 병합해 전체를 다시 할당하는 방법으로 바꿀 수 있다.
     */

    s = s.substring(0..1) + "x" + s.substring(3 until s.length)
    // ab를 추출하고 x를 덧붙이고 다시 def를 추출
    println(s)
}