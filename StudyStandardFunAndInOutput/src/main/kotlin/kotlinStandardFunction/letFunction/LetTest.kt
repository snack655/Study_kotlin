package kotlinStandardFunction.letFunction

/**
 * let() 함수 활용하기
 *
 * let() 함수는 함수를 호출하는 객체 T를 이어가는
 * block의 인자로 넘기고 block의 결괏값 R을 반환한다.
 * 먼저 표준 함수의 정의를 보자.
 *
 * public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }
 *
 * let() 함수는 제네릭의 확장 함수 형태이므로 어디든 적용할 수 있다.
 * 매개변수로는 람다식 형태인 block이 있고 T를 매개변수로 받아 R을 반환한다.
 * let() 함수 역시 R을 반환하고 있다.
 * 본문의 this는 객체 T를 가리킨다.
 * 이것은 람다식 결과 부분을 그대로 반환한다는 뜻이다.
 * 이 함수를 호출한 객체를 인자로 받으므로 이를 사용하여 다른 메서드를 실행하거나
 * 연산을 수행해야 하는 경우 사용할 수 있다.
 */

fun main() {
    val score: Int? = 32
    // var score = null

    // 일반적인 null 검사
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    // let 함수를 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") }    // 1
        val str = score.let { it.toString() }   // 2
        println(str)
    }
    checkScore()
    checkScoreLet()

    /**
     * score는 null 가능성이 있는 변수로 선언되었다.
     * 1번의 checkScoreLet()을 보면 score에 멤버 메서드를 호출하듯 let 함수를 사용했는데
     * 매개변수가 람다식 하나일 때는 let({ ... })에서 표현이 소괄호가 생략되어 let { ... }과 같이
     * 작성할 수 있다.
     * 그리고 score?. 처럼 null에 안전한 호출을 위해 세이프 콜을 사용했다.
     * 만일 score가 null일 경우 람다식 구문을 수행되지 않는다.
     * null이 아니라면 자기 자신의 값 score를 it으로 받아서 처리할 수 있다.
     *
     * 2번을 보면 toString()을 사용해 it을 문자열로 변환한 후 반환된 값을 str에 할당한다.
     * 이때 세이프 콜(?.)을 사용하지 않았다.
     * 만일 score가 null이라면 str에는 null이 할당된다.
     * 세이프 콜(?.)을 사용하더라도 람다식을 사용하지 않게 되므로 str은 String?으로 추론되어 null이 할당된다.
     *
     *
     * null 가능성 있는 객체에서 let() 함수 사용하기
     *
     * let() 함수를 세이프 콜(?.)과 함께 사용하면 if (null != obj)와 같은 null 검사 부분을 대체할 수 있다.
     */
    val obj: String? = readLine()    // null일 수 있는 변수 obj

    if (null != obj) {  // obj가 null이 아닐 경우 작업 수행(기존 방식)
        println(obj)
    }

    obj?.let {  // obj가 null이 아닐 경우 작업 수행
        println(it)
    }

    /**
     * 만일 다음과 같이 else문이 포함된 긴 문장을 변경하려면?
     */

    val firstName: String? = null
    val lastName: String? = "민재"
    // if문을 사용하는 경우!
    if (null != firstName) {
        print("$firstName $lastName")
    } else {
        print("$lastName")
    }

    /**
     * firstName의 변수에 다음과 같이 let()과 엘비스 연산자(?:)를 적용해
     * 변경하면 아래와 같이 한 줄로 단순화할 수 있다.
     */

    // let을 사용하는 경우
    firstName?.let { println("$it $lastName") } ?: println(lastName)

    /**
     * 메서드 체이닝을 사용할 때 let() 함수 활용하기
     *
     * 메서드 체이닝이란?
     * 여러 메서드 혹은 함수를 연속적으로 호출하는 기법이다.
     * 다음과 같이 let() 함수를 체이닝 형태로 사용할 수 있다.
     */

    var a = 1
    var b = 2

    a = a.let { it + 2 }.let {
        val i = it + b
        i   // 마지막 식 반환
    }
    println(a)
}