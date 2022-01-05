fun main() {
    lambda1()

}

fun lambda1() {
    var result : Int
//    val multi : (Int, Int) -> Int = { x, y -> x * y} // 일반 변수에 람다식 할당
    val multi = {x: Int, y: Int -> x * y}
    result = multi(10, 20) // 람다식이 할당된 변수는 함수처럼 사용 가능
    println(result)

    // 표현식이 2개 이상일 때
    val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
        println("x * y")
        x * y // 마지막 표현식이 반환된다.
    }

    println(multi2(10, 20))

    // 람다식의 매개변수에 자료형이 지정되어 있다면 변수의 자료형은 생략할 수 있다.
    // 아래는 모두 같은 표현입니다.
    val multi3: (Int, Int) -> Int = {x: Int, y: Int -> x * y} // 생략되지 않은 전체 표현
    val multi4 = {x: Int, y: Int -> x * y} // 선언 자료형 생략
    val multi5: (Int, Int) -> Int = {x, y -> x * y} // 람다식 매개변수 자료형의 생략

    // val multi = {x, y -> x * y} 오료! 추론이 가능하지 않음!

    // 반환 자료형이 없거나 매개변수가 하나만 있을때
    val greet: () -> Unit = { println("Hello World") }
    val square: (Int) -> Int = {x -> x * x}

    // 람다식 안에 람다식을 넣을때의 자료형
    val nestedLambda: () -> () -> Unit = {{ println("nested") }}

    // 람다식의 자료형 생략
    val greet2 = { println("Hello World!") } // 추론 가능
    val square2 = {x : Int -> x * x} // square2의 자료형을 생략하려면 x의 자료형을 명시해야 함
    val nestedLambda2 = {{ println("nested") }} // 추론 가능

    // 람다식을 매개변수에 사용한 고차 함수의 예
    var result2: Int
    result2 = highOrder({x, y -> x + y}, 10, 20) // 람다식을 매개변수와 인자로 사용한 함수
    println(result2)

    // 인자와 반환값이 없는 람다식
    val out: () -> Unit = { println("Hello World!") } // 인자와 반환값이 없는 람다식의 선언
    // 자료형 추론이 가능하르모 val out = { println("Hello World!") }와 같이 생략 가능

    out() // 함수처럼 사용 가능
    val new = out // 람다식이 들어 있는 변수를 다른 변수에 할당
    new()


}

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}

