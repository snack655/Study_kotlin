package Conditional

/**
 if문과 if~else문
 if문은 조건을 판단하기 위해 자주 사용한다.

 if(조건식) {
    수행할 문장 // 조건식이 true일 경우에만 수행
    ...
 }

 조건식에는 Boolean 자료형으로 참(true) 또는 거짓(false) 값을 받을 수 있는 조건식을 구성!
 만일 조건식이 true인 경우 if문이 가지고 있는 블록을 수행

 특정 조건을 판단하는 데 사용하는 조건식은 표현식으로도 구성할 수 있다.

 만일 조건식이 false일 경우에 수행하고자 하는 문장이 있다면 else문의 블록에 코드를 작성!

 if (조건식) {
    수행할 문장 // 조건식이 true일 경우에만 수행
 } else {
    수행할 문장 // 조건식이 false일 경우에 수행
 }
 */

fun main() {
    // if문과 if~else문을 이용할 큰 수 판단하기
    // if문
    /*var max = a
    if (a > b)
        max = b // 수행할 문장이 한 줄이면 중괄호를 생략할 수 있음.*/

    // if~else문
    /*var max = Int
    if (a > b)
        max = b
    else
        max = b*/

    // 한 줄 표현
    // val max = if (a > b) a else b

    //------------------------------------------------------------------------------------
    // 블록의 표현식이 길어질 때
    // 중괄호로 감싸야 한다.
    // 람다식처럼 블록의 마지막 표현식이 변수에 반환되어 할당된다.
    
    val a = 12
    val b = 7

    // 블록과 함께 사용
    val max = if (a > b) {
        println("a 선택")
        a   // 마지막 식인 a가 반환되어 max에 할당
    }
    else {
        println("b 선택")
        b   // 마지막 선언 b가 반환되어 max에 할당
    }

    println(max)
}