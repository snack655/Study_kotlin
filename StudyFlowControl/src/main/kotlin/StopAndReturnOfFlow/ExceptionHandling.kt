package StopAndReturnOfFlow

import java.lang.ArithmeticException
import java.lang.Exception
import javax.naming.InvalidNameException

/** 예외 처리
 예외(Exception)란?
 프로그램 코드를 작성하다 보면 해당 코드가 제대로 작동하지 못하고 중단되는 현상이 발생하는 것

 대부분의 오류(Error)는 코드를 작성하는 도중에 컴파일러가 잡아낼 수 있다.
 하지만 메모리 부족이나 파일이 손상되는 등의 실행 도중의 잠재적인 오류까지 검사활 수 없기 때문에 정상적으로
 실행되다가 비정상적으로 프로그램이 종료될 수 있다.

 예외를 발생시키는 상황으로는 다음과 같음 것들이 있다.
 - 운영체제의 문제(잘못된 시스템 호출의 문제)
 - 입력값의 문제(존재하지 않는 파일 또는 숫자 입력란에 문자 입력 등)
 - 받아들일 수 없는 연산(0으로 나누기 등)
 - 메모리의 할당 실패 및 부족
 - 컴퓨터 기계 자체의 문제(전원 문제, 망가진 기억 장치 등)

 따라서 프로그램을 실행할 때 발생할 수 있는 예외에 대비해야 하는데 이것을 예외 처리라고 한다.
 잠재적으로 예외가 발생할 수 있는 코드를 try~catch문으로 감싸 놓는다.
 try 블록에서 예외가 발생하면 catch 블록에 잡아서 그 예외를 처리한다.

 코틀린에서도 다음과 같이 자바와 동일한 문법으로 예외 처리 블록을 사용한다.
 try {
    예외 발생 가능성 있는 문장
 } catch (e: 예외 처리 클래스 이름) {
    예외를 처리하기 위한 문장
 }  finally {
    반드시 실행되어야 하는 문장
 }
 */

fun main() {
    // 0으로 나누었을 때 예외를 발생하는 예제
    val a = 6
    val b = 0
    var c : Int

    try {
        c = a / b   // 0으로 나눔
    } catch (e: Exception) {
        println("Exception is handled")
    } finally {
        println("finally 블록은 반드시 항상 실행됨")
    }
    // catch 인자에 Exception 클래스는 일반적인 모든 예외를 가리킨다.

    //------------------------------------------------------------------------------------
    // 특정 예외 처리
    // 산술 연산에 대한 예외를 따로 특정해서 잡으려면 ArithmeticException을 사용할 수 있다.
    try {
        c = a / b   // 0으로 나눔
    } catch (e: ArithmeticException) {
        println("Exception is handled. ${e.message}")
    }
    // 문자열에 e.message처럼 예외를 가리키는 객체 e의 멤버 변수 또는 프로퍼티로 불리는 message를 읽으면
    // 예외 원인을 간단히 출력해준다.
    // / by zero

    //------------------------------------------------------------------------------------
    // 스택의 추적
    // 임시 메모리 영역인 스택을 추적
    try {
        c = a / b   // 0으로 나눔
    } catch (e: Exception) {
        e.printStackTrace()
    }
    // e의 멤버 메서드인 printStackTrace()를 사용하면 다음과 같이 ArithmeticException이 발생했음을 알 수 있고,
    // 또한 오류가 발생한 코드의 줄을 학인 할 수 있다.
    // java.lang.ArithmeticException: / by zero
    //	 at StopAndReturnOfFlow.ExceptionHandlingKt.main(ExceptionHandling.kt:66)
    //	 at StopAndReturnOfFlow.ExceptionHandlingKt.main(ExceptionHandling.kt)

    // 오류의 원인이 되는 줄을 스택으로부터 추적할 수 있는 이유는 프로그램이 디버깅 정보를 유지하고 있기 때문이다.

    //------------------------------------------------------------------------------------
    // 예외 발생시키기
    // 의도적으로 예외를 발생할 수 있을까?
    // throw 키워드를 사용해 의도적으로 예외를 발생할 수 있다.
    // 먼저 특정 함수를 만들면서 필요한 경우 예외를 발생하도록 하려면 다음과 같은 형태로 지정
    // throw Exception(message: String)

    // 잔고가 1,000 이하일 때 예외를 발생하는 예제
    var amount = 600
    
    fun checkAmount(amount: Int) {
        if (amount < 1000)
            throw Exception("잔고가 $amount 으로 1000 이하입니다.")
    }

    try {
        amount -= 100
        checkAmount(amount)
    } catch (e: Exception) {
        println(e.message)
    }
    println("amount: $amount")



    //------------------------------------------------------------------------------------
    /**
     사용자 정의 예외
     기존 Exception 클래스로부터 새롭게 사용자가 정의한 예외 클래스를 만들어 낼 수 있다.

     class <사용자 예외 클래스 이름>(message: String) : Exception(message)

     콜론(:)을 사용해 하위 클래스인 사용자 예외 클래스 이름을 지정해 예외로 만들 수 있다.
     이름을 검사해 문자 이외에 숫자가 이름에 포함되어 있으면 예외를 발생하도록 코드를 작성해보자.
     */
    class InvalidNameException(message: String) : Exception(message)    // 1. 사용자 예외 클래스

    var name = "Kildong123" // 2 숫자가 포함된 이름
    try {
        validateName(name)
    } catch (e : InvalidNameException) {    // 3. 숫자가 포함된 예외 처리
        println(e.message)
    } catch (e : Exception) {   // 기타 예외 처리
        println(e.message)
    }
}

fun validateName(name: String) {
    if (name.matches(Regex(".*\\d+.*"))) {  // 4. 이름에 숫자가 포함되어 있으면 예외 발생시킴
        throw InvalidNameException("Your name : $name : contains numerals.")
    }

    // 정규식을 사용
    // 정규식(Regular Expression)이란?
    // 특정한 규칙을 가진 문자열로 어떤 문자열에서 정해진 패턴을 알아낼 때 자주 사용
    // 다만, 정규식의 기호가 읽기에는 좀 어렵기 때문에 익숙해지는 데 시간이 필요
    // 정규식을 알아두면 문자열 작업에 대단히 유용하다.
    // regexr 웹사이트(https://regexr.com/)를 방문하면 정규식을 연습할 수 있다.
}