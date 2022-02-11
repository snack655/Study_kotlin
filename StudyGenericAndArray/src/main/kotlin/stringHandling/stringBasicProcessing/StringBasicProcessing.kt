package stringHandling.stringBasicProcessing

/**
 * 문자열의 기본 처리
 *
 * 문자열은 연속된 배열과 같다.
 * 또한 문자열은 불변(immutable) 값으로 생성되기 때문에 참조되고 있는 메모리가 변경될 수 없다.
 * 새로운 값을 할당하려고 한다면 기존 메모리 이외에 새로운 문자열을 위한 메모리를 만들어 할당해야 한다.
 */

fun main() {
    val hello: String = "Hello World"
    println(hello[0])   // H

    /**
     * 하지만 var나 val에서 다음과 같이 하나의 요소에 새 값을 할당할 수 없다.
     * 다만 var로 선언하는 경우 전체 문자열을 내부적으로 새로 생성해 할당되고 기존
     * 사용하던 공간은 GC(Garbage Collector)에 의해 제거된다.
     */

    // hello[0] = 'K'  // 오류!
    var s = "abcdef"
    s = "xyz"   // 새로운 메모리 공간이 생성
}