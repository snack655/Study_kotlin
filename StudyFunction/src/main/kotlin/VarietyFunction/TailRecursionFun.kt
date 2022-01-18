package VarietyFunction

import java.math.BigInteger

/**
 꼬리 재귀 함수
 재귀(Recursion)란?
 자기 자신을 다시 참조하는 방법을 의미

 재귀 함수는 자기 자신을 계속 호출하는 특징이 있고 설계를 잘못하면 스택 오버플로(Stack Overflow) 오류가 발생하기도 한다.
 따라서 다음의 조건을 지켜야 한다.
 1. 무한 호출에 빠지지 않도록 탈출 조건을 만들어 둔다.
 2. 스택 영역을 이용하므로 호출 횟수를 무리하게 많이 지정해 연산하지 않는다.
 3. 코드를 복잡하지 않게 한다.

 코틀린에서는 꼬리 재귀 함수(Tail Recursive Function)를 통해 스택 오버플로 현상을 해결할 수 있다.
 이것은 스택에 계속 쌓이는 방식이 아닌 꼬리를 무슨 형태로 반복한다.
 이때 코틀린 고유의 tailrec 키워드를 사용한다.
 */

fun main() {
    // factorial 재귀 함수로 스택 오버플로 경험하기
    val number = 4
    val result: Long

    result = factorial(number)
    println("Factorial: $number -> $result")

    // --------------------------------------------------------------------------------------------------------
    // 꼬리 재귀로 스택 오버플로 방지하기
    // 꼬리 재귀에서는 계산을 먼저하고 재귀 함수가 호출된다.
    // 즉, 위 함수가 계산을 먼저 할 수 있도록 함수를 수정해야한다.

    val newNumber = 5
    println("Factorial : $number -> ${newFactorial(number)}")

    // 꼬리 재귀에서는 계산을 먼저하고 재귀 함수가 호출된다.
    // 즉, 함수가 계산을 먼저 할 수 있도록 함수를 수정했다.

    // --------------------------------------------------------------------------------------------------------
    // 피보나치 수열 재귀 함수와 꼬리 재귀 함수
    // 피보나치 수열이란?
    // 0, 1로 시작하여 n번째 수와 n+1번째 수의 합이 n+2번째 수가 되는 수열이다.
    // -> 0 1 1 2 3 5 8 13
    val n = 100
    val first = BigInteger("0")
    val second = BigInteger("1")

    println(fibonacci(n, first, second))

}

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n * factorial(n - 1)
}

tailrec fun newFactorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else newFactorial(n-1, run*n)
}

// 꼬리 재귀 함수(피보나치)
tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacci(n-1, b, a+b)
}