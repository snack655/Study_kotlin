package HighOrderFunctionAndLambdaExpressions

// 매개변수 개수에 따라 람다식을 구성하는 방법

fun main() {
    // 람다식에 매개변수가 없는 경우
    noParam({ "Hello World!" })
    noParam { "Hello World!" }  // 위와 동일 결과, 소괄호 생략 가능
    // 매개변수는 람다식 1개를 가지고 있는데 함수 사용 시 소괄호를 생략할 수 있다.

    // --------------------------------------------------------------------------------------------------------
    // 람다식의 매개변수가 1개인 경우
    // 이 경우에는 람다식에 화살표(->) 기호 왼쪽에 필요한 변수를 써줘야 한다.
    oneParam({ a -> "Hello World! &a" })
    oneParam { a -> "Hello World! $a" } // 위와 동일한 결과, 소괄호 생략 가능
    oneParam { "Hello World! $it" }     // 위와 동일한 결과, it으로 대체 가능

    // --------------------------------------------------------------------------------------------------------
    // 람다식의 매개변수가 2개 이상인 경우
    moreParam { a, b -> "Hello World! $a $b" } // 매개변수 이름 생략 불가
    // 만일 특정 람다식의 매개변수를 사용하고 싶지 않을 때는 이름 대신에 언더스코어(_)로 대체할 수 있다.
    moreParam { _, b -> "Hello World! $b" } // 첫 번째 문자열은 사용하지 않고 생략

    // --------------------------------------------------------------------------------------------------------
    // 일반 매개변수와 람다식 매개변수를 같이 사용하기
    // 1. 인자와 함께 사용하는 경우
    withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b" })
    // 2. withArgs() 함수의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능
    withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b" }

    // --------------------------------------------------------------------------------------------------------
    // 일반 함수에 람다식 매개변수를 2개 이상 사용하기
    // 이런 경우 소괄호를 생략할 수 없다.
    twoLambda({ a, b -> "First $a $b " }, { "Second $it" })
    twoLambda({ a, b -> "First $a $b" }) { "Second $it"  }  // 위와 동일
    // 람다식 3개도 위와 마찬가지다.
}

// 매개변수가 없는 람다식이 noParam 함수의 매개변수 out으로 지정됨
fun noParam(out: () -> String) = println(out())

// 매개변수가 1개 있는 람다식이 oneParam() 함수의 매개변수 out으로 지정됨
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}

// 매개변수가 2개 있는 람다식의 moreParam 함수의 매개변수로 지정됨
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}

// withArgs() 함수는 일반 매개변수 2개를 포함, 람다식을 마지막 매개변수로 가짐
fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}

fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
    println(first("OneParam", "TwoParam"))
    println(second("OneParam"))
}
