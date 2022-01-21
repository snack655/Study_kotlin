package StopAndReturnOfFlow

// return문

fun main() {
    // return으로 값 반환하기
    // 보통은 return문은 다음과 같이 값이 반환하는데 사용한다.
    fun add(a: Int, b: Int): Int {
        return a + b
        println("이 코드는 실행되지 않습니다.") // 여기에 도달하지 않음
    }
    // return이 사용되면 코드의 흐름을 중단하고 함수의 역할을 끝낸다.

    //------------------------------------------------------------------------------------
    // return으로 Unit 반환하기

    // 값 없이 return만 사용하면?
    // 자료형을 반환하지 않을 경우 Unit을 사용
    // 코틀린에서 Unit이란 반환하는 값이 아예 없는 뜻이 아니라 Unit이라는 자료형 자체를 반환!
    // 다음의 3가지 표현으로 사용한다.

    // 1. Unit을 명시적으로 변환
    fun hello1(name: String): Unit {
        println(name)
        return Unit
    }

    // 2. Unit 이름을 생략한 반환
    fun hello2(name: String): Unit {
        println(name)
        return
    }

    // 3. return문 자체를 생략
    fun hello3(name: String) {
        println(name)
    }

    //------------------------------------------------------------------------------------
    // 람다식에서 return 사용하기

    // 인라인(inline)으로 선언되지 않은 람다식에서는 return을 그냥 사용할 수 없다.
    // return@label과 같이 라벨(label) 표기와 함께 사용!
    // 라벨이란?
    // 코드에서 특정한 위치를 임의로 표시한 것으로, @ 기호와 이름을 붙여서 사용한다.

    // 인라인으로 선언된 함수에서 람다식을 매개변수로 사용하면 람다식에서 return을 사용할 수 있다.
    retFunc()

    //------------------------------------------------------------------------------------
    /**
     람다식에서 라벨과 함께 return 사용하기

     그렇다면 비지역 반환을 방지하고 가장 가까운 함수인 retFunc() 함수 위치로 빠져 나가게 하려면?
     람다식에서 라벨을 정의해 return을 사용해야 한다.
     먼저 라벨을 지정하기 위해서 정의할 때는 앳(@) 기호를 라벨 뒤에 붙여 라벨 이름@과 같이 지정하고,
     사용할 때는 앞부분에 return@라벨 이름으로 지정!

     람다식 함수 이름 라벨 이름@ {
        ...
        return@라벨 이름
     }

     */
    // 예제를 보자.
    retFunc2()

    //------------------------------------------------------------------------------------
    // 암묵적 라벨이란?
    // 람다식 표현식 블록에 직접 라벨을 쓰는 것이 아닌 람다식의 명칭을 그대로 라벨처럼 사용할 수 있다.

    // 기존 코드를 변경해보자!
    retFunc3()

    //------------------------------------------------------------------------------------
    // 익명 함수를 사용한 반환
    // 람다식 대신에 익명 함수를 넣을 수도 있다.
    // 이때는 라벨을 사용하지 않고도 가까운 익명 함수 자체가 반환되므로 위와 동일한 결과를 가질 수 있다.
    // 기존의 코드를 변경하자
    retFunc4()

    // 또 다른 예로 람다식의 방법으로 return을 사용하려면 다음과 같다
    // 람다식 방법
    val getMessage = lambda@ { num: Int ->
        if (num !in 1..100) {
            return@lambda "Error"   // 라벨을 통한 반환
        }
        "Success"   // 마지막 식이 반환
    }

    // 익명 함수 방법
    val getMessage2 = fun(num: Int): String {
        if (num !in 1..100) {
            return "Error"
        }
        return "Success"
    }

    // 익명 함수 방법을 사용하면 2개의 return이 확실히 구별된다.
    // 해당 값의 범위에 따라 반환되는 문자열을 분명히 하고 있다.
    // 따라서 보통의 경우에는 람다식을 사용하고 return과 같이 명시적으로 반환해야 할 것이 여러 개라면 익명 함수를 쓰는 것이 좋다.

    //------------------------------------------------------------------------------------
    /**
     람다식과 익명 함수를 함수에 할당할 때 주의할 점
     익명 함수와 람다식은 할당하는 방법에서 약간의 차이가 있다.
     읽기에 따라 문제가 생길 수 있다.

     먼저 함수에 람다식을 할당한다고 생각해보자.
     fun greet() = { println("Hello") }

     그러면 다음과 같이 greet() 함수를 실행하면 무엇이 나올까?
     println() 함수에 지정된 "Hello"가 출력될까?
     greet()
     결과는 아무것도 출력되지 않는다.
     할당 연산자(=)에 의해 람다식 { println("Hello") } 자체가 greet() 함수에 할당된 것일 뿐!
     greet() 함수가 가지고 있는 함수를 사용하려면 다음과 같이 표기!
     greet()()

     함수가 할당됨을 명시적으로 표현하려면 익명 함수를 써서 선언하는 것이 읽기에 더 좋을 수 있다.
     fun greet() = fun() { println("Hello") }

     이런 차이점에 주의하자.
     */


}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("start of retFunc")     // 1
    inlineLambda(6, 3) { a, b ->    // 2
        val result = a + b
        if (result > 10) return     // 3 10보다 크면 이 함수를 빠져 나감
        println("result: $result")  // 4 10보다 크면 이 문장에 도달하지 못함
    }
    println("end of retFunc")   // 5
}

fun inlineLambda2(a: Int, b: Int, out: (Int, Int) -> Unit) {    // inline을 제거
    out(a, b)
}

fun retFunc2() {
    println("start of retFunc2")
    inlineLambda2(13, 3) lit@{ a, b ->  // 1 람다식 블록의 시작 부분에 라벨을 지정
        val result = a + b
        if (result > 10) return@lit // 2 라벨을 사용한 블록의 끝부분으로 반환
        println("result: $result")
    }   // 3 이 부분으로 빠져나감
    println("end of retFunc")   // 4 이 부분이 실행
}

fun retFunc3() {
    println("start of retFunc3")
    inlineLambda2(13, 3) { a, b ->
        val result = a + b
        if (result > 10) return@inlineLambda2
        println("result: $result")
    }
    println("end of retFunc")
}

fun retFunc4() {
    println("start of retFunc4")
    inlineLambda2(13, 3, fun (a, b) {
        val result = a + b
        if (result > 10) return@inlineLambda2
        println("result: $result")
    })  // inlineLambda()의 끝부분
    println("end of retFunc")
}