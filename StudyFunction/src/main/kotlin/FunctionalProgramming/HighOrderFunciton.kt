package FunctionalProgramming

// 고차 함수(High-order Function)란?
// 다른 함수를 인자로 사용하거나 함수를 결괏값으로 반환하는 함수
// 두 특징이 있어도 고차 함수
// 일급 객체 혹은 일급 함수를 서로 주고받을 수 있는 함수

fun main() {
    println(highFunc({x, y -> x + y}, 10, 20))  // 람다식 함수를 인자로 넘김
}

fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)   // sum 매개변수는 함수

// 함수형 프로그래밍의 정의와 특징
// 1. 순수 함수를 사용해야 한다.
// 2. 람다식을 사용할 수 있다.
// 3. 고차 함수를 사용할 수 있다.