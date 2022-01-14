package HighOrderFunctionAndLambdaExpressions

fun main() {
    // 일반 함수를 인자나 반환값으로 사용하는 고차함수
    val res1 = sum(3, 2)    // 일반 인자
    val res2 = mul(sum(3, 3), 3)    // 인자에 함수를 사용

    println("res1 : $res1, res2 : $res2")

    // --------------------------------------------------------------------------------------------------------
    // 함수를 반환값으로 사용하는 방법?
    println("funcFunc : ${funcFunc()}")

    // --------------------------------------------------------------------------------------------------------
    // 람다식을 인자나 반환값으로 사용하는 고차 함수
    var result: Int
    val multi = {x: Int, y: Int -> x * y}   // 일반 변수에 람다식 할당
    result = multi(10, 20) // 람다식이 할당된 변수는 함수처럼 사용 가능
    println(result)

    // multi의 자료형 : (Int, Int) -> Int

    // 만약 함수 내용에 표현식이 2줄 이상이라면 마지막 표현식이 반환값이 된다.
    val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
        println("x * y")
        x * y // 마지막 표현식이 반환
    }

    // 람다식의 매개변수에 자료형이 지정되어 있다면 변수의 자료형은 생략할 수 있다.
    // 다음은 모두 같은 표현
    // val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y} 생략되지 않은 전체 표현
    // val multi = {x: Int, y: Int -> x * y} 선언 자료형 생략
    // val multi: (Int, Int) -> Int = {x, y -> x * y} 람다식 매개변수 자료형의 생략

    // 하지만 둘 다 생략해 버리면 자료형이 추론되지 않으므로 오류 발생
    // val multi = {x, y -> x * y} 오류! 추론이 가능하지 않음

    // 반환 자료형이 아예 없거나 매개변수가 하나만 있을 경우
    val greet: () -> Unit = { println("Hello World") }
    val square: (Int) -> Int = {x -> x * x}

    // greet은 매개변수를 표현할 필요가 없으므로 화살표 앞쪽과 화살표 자체가 생략
    // 람다식을 보고 매개변수와 반환값을 추론할 수 있다면 람다식의 매개변수 자료형은 생략할 수 있다.

    // 람다식 안에 람다식을 넣으면 어떻게 자료형을 지정해야 할까?
    val nestedLambda: () -> () -> Unit = {{ println("nested") }}

    // 위의 람다식에서 추론 가능한 부분을 생략해보자.
    // 람다식의 자료형 생략
    // val greet = {println("Hello World!")} 추론 가능
    // val square = {x : Int -> x * x} square 자료형을 생략하려면 x의 자료형을 명시
    // val nestedLambda = {{println("nested")}} 추론 가능

    // 람다식을 매개변수에 사용한 고차 함수의 예
    val result2: Int = highOrder({ x, y -> x + y}, 10, 20)    // 람다식을 매개변수와 인자로 사용한 함수
    println(result2)

    // 인자와 반환값이 없는 람다식
    val out: () -> Unit = { println("Hello World!") }   // 인자와 반화값이 없는 람다식의 선언
    // 자료형 추론이 가능하므로 val out = { println("Hello World") } 와 같이 생략 가능

    out() // 함수처럼 사용 가능
    val new = out // 람다식이 들어 있는 변수를 다른 변수에 할당
    new()
}

fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int) = a * b

fun funcFunc() : Int {  // 함수의 반환값으로 함수 사용
    return sum(2, 2)
}

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}
