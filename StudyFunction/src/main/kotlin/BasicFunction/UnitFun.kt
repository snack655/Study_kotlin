// 반환값이 없는 함수
// 함수의 반환값은 생략할 수 있다. return문을 생략할 수 있다는 뜻
// 그 대신 반환값의 자료형을 Unit으로 지정하거나 생략할 수 있다.
// Unit : Kotlin에서 다루는 특수한 자료형 중 하나로 반환값이 없을 때 사용

fun main() {
    printSum(3, 6)
    printSum2(5, 263)
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}