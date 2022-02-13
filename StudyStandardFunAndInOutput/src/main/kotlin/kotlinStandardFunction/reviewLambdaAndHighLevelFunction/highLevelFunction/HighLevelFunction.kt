package kotlinStandardFunction.reviewLambdaAndHighLevelFunction.highLevelFunction

/**
 * 고차 함수
 *
 * 고차 함수는 함수의 매개변수로 함수를 받거나 함수 자체를 반환할 수 있는 함수이다.
 */

fun inc(x: Int): Int {
    return x + 1
}

fun high(name: String, body: (Int) -> Int): Int {
    println("name: $name")
    val x = 0
    return body(x)
}

/**
 * high의 두 번째 매개변수 body는 람다식 함수를 받을 수 있다.
 * 이것을 다시 함수 본문에서 함수로 반환하고 있다.
 * 다양한 고차 함수 표현법을 살펴보자.
 */

fun main() {
    val result = high("Sean", { x -> inc(x + 3)})   // 함수를 이용한 람다식
    val result2 = high("Sean") { inc(it + 3) }   // 소괄호 바깥으로 빼내고 생략
    val result3 = high("Kim", ::inc)    // 매개변수 없이 함수의 이름만 사용할 때
    val result4 = high("Sean") { x -> x + 3 } // 람다식 자체를 넘겨준 형태
    val result5 = high("Sean") { it + 3 }   // 매개변수가 1개인 경우 생략

    /**
     * 람다식이 하나인 경우 소괄호 바깥으로 뺴낼 수 있다.
     * 기본값을 사용하는 경우에는 ::함수 이름 형태로 사용할 수 있다.
     * 또한 람다식을 매개변수로 넣을 수 있다.
     */
}