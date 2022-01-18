package VarietyFunction

/**
 확장 함수(Extension Function)
 기존 멤버 메서드는 아니지만 기존의 클래스에 내가 원하는 함수를 하나 더 포함시켜 확장하고 싶을 때?
 코틀린에서는 클래서처럼 필요로 하는 대상에 함수를 더 추가할 수 있는 확장 함수(Extension Function)라는 개념을 제공!

 클래스와 같은 확장 대상에 확장 함수를 사용하기 위해 다음과 같이 정의할 수 있다.

 fun 확장 대상.함수 이름(매개변수, ...): 반환값 {
    ...
    return 값
}

코틀린의 모든 클래스에 내가 만들어 놓은 확장 함수를 추가하는 방법?
최상위 클래스인 Any에 확장 함수를 구현!
 */

fun main() {
    // String 클래스에 나만의 확장 함수 추가하기
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

// String 클래스를 확장해 getLongString() 함수 추가
fun String.getLongString(target: String): String =
    if (this.length > target.length) this else target