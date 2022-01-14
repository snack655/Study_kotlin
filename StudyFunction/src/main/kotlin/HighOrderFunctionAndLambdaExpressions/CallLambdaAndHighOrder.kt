package HighOrderFunctionAndLambdaExpressions

// 기본형 변수로 할당된 값은 스택에 있고 다른 함수에 인자로 전달하는 경우에는 해당 값이 복사되어 전달된다.
// 참조형 변수로 할당된 객체는 참조 주소가 스택에 있고 객체는 힙에 있다.
// 참조형 객체는 함수에 전달할 때는 참조된 주소가 복사되어 전달된다.

// JVM에서 실행되는 자바나 코틀린 함수를 호출할 때 인자의 값만 복사하는 '값의 의한 호출(Call by Value)'이 일반적
// 주소 자체를 사용해 호출하는 '참조에 의한 호출(Call by Reference)'은 자바나 코틀린에서 사용되지 않는다.

// 자바는 객체가 전달될 때 주소 자체를 전달하는 것이 아닌 값을 복사하는데 이것은 참조에 의한 호출처럼 보이지만 그 값이 주소일 뿐..
// 코틀린은 람다식을 사용하면서 몇 가지 확장된 호출 방법을 사용할 수 있다.

fun main() {
    // 값에 의한 호출(Call By Value)
    // 코틀린에서 값에 의한 호출은 함수가 또 다른 함수의 인자로 전달될 경우 람다식 함수는 값으로 처리되어 그 즉시 함수가 수행된 후 값을 전달
    val result = callByValue(lambda()) // 람다식 함수를 호출
    println(result)

    // --------------------------------------------------------------------------------------------------------
    // 이름에 의한 람다식 호출
    // 람다식의 이름이 인자로 전달될 때 실행되지 않고 실제로 호출할 때 실행되도록 하면?
    val result2 = callByName(otherLambda)   // 람다식 이름으로 호출
    println(result2)
    // 람다식의 이름을 callByName() 함수에서 호출하는 점이 다르다.

    // --------------------------------------------------------------------------------------------------------
    // 다른 함수의 참조에 의한 일반 함수 호출
    // 람다식이 아닌 일반 한수를 또 다른 함수의 인자에서 호출하는 고차함수의 경우
    fun sum(x: Int, y: Int) = x + y
    // funcParam(3, 2, sum) 오류! sum은 람다식이 아님!

    // sum()과 funcParam()의 매개변수 c의 선언부 구조를 보면 인자 수와 자료형의 개수가 동일하다.
    // 이때는 다음과 같이 2개의 콜론(::) 기호를 함수 이름 앞에 사용해 소괄호와 인자를 생략하고 사용할 수 있다.
    funcParam(3, 2, ::sum)

    // 최종 예제
    // 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    // 인자가 없는 함수
    hello(::text)   // 반환값이 없음

    // 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    println(likeLambda(6, 6))

    // 콜론 2개(::)를 이용한 표기법 정리
    hello(::text) // 함수 참조 기호
    hello({ a, b -> text(a, b) })   // 람다식 표현(동일한 결과)
    hello { a, b -> text(a, b) }    // 소괄호 생략(동일한 결과)
    // 매개변수와 인자 구조가 동일한 경우 람다식 표현법이 간략화된 함수 참조 기호인 ::을 사용하면 좀 더 편리하게 작성할 수 있다.
}

fun callByValue(b: Boolean): Boolean {  // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {   // 람다 표현식이 2줄
    println("lambda function")
    true    // 마지막 표현식 문장의 결과가 반환
}

fun callByName(b: () -> Boolean): Boolean {     // 람다식 자료형으로 선언된 매개변수
    println("callByName Function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun text(a: String, b: String) = "Hi! $a $b"

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}