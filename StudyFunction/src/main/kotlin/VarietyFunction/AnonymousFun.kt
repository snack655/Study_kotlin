package VarietyFunction

/**
 익명함수(Anonymous Function)란?
 일반 함수이지만 이름이 없는 것!
 **/

fun main() {
    val add: (Int, Int) -> Int = fun(x, y) = x + y  // 익명 함수를 사용한 add 선언
    val result = add(10, 2) // add의 사용
}

// fun(x: Int, y: Int): Int = x + y  함수 이름이 생략된 익명 함수