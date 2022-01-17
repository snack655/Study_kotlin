package VarietyFunction

/**
 인라인 함수(Inline Function)
 이 함수가 호출되는 곳에 함수 본문의 내용을 모두 복사해 넣어 함수의 분기 없이 처리되기 때문에
 코드의 성능을 높일 수 있다.

 인라인 함수는 람다식 매개변수를 가지고 있는 함수에서 동작한다.
 인라인 함수는 내용이 복사되어 main() 함수의 블록 코드에 들어가므로 분기 없이 흐름에 방행하지 코드가 수행된다.
 즉, 일반 함수의 호출처럼 매번 분기하지 않아도 된다.
 **/

fun main() {
    // 인라인 함수 shortFunc()의 내용이 복사되어 shortFunc으로 들어감
    shortFunc(3) { println("First call: $it") }
    shortFunc(5) { println("Second call: $it") }

    // --------------------------------------------------------------------------------------------------------
    // 인라인 함수 제한하기
    // noinline 키워드 사용하기
    // ex
    // inline fun sub(out1: () -> Unit, noinline out2: () -> Unit) {

    shortFunc(3) { println("First call : $it") }

    // --------------------------------------------------------------------------------------------------------
    // 인라인 함수와 비지역 반환
    // 인라인 함수에서 사용한 람다식을 빠져나오려면?
    // 인라인 함수에서 사용한 람다식에서는 return을 사용할 수 있다.

    shortFunc(3) {
        println("First call: $it")
        return
    }

    // out(a)는 인라인되어 대체되기 때문에 return문까지 포함된다.
    // println("After calling out()") 문장은 실행되지 않는다.
    // 이러한 반환을 비지역 반환(Non-local Return)이라고 부른다.

    // 비지역 반환을 금지하는 방법
    // crossinline을 붙인다.
}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}