package Conditional

/**
 when문으로 다양한 조건 처리하기

 조건식이 아주 많이 필요할 경우에 when문을 사용하면 더 편리하고
 간단한 문장을 구성할 수 있다.

 when은 함수처럼 인자가 있는 경우와 없는 경우의 2가지 사용법이 있다.
 */

fun main() {
    // 인자를 사용하는 when문
    // 형태를 보자면
    /**
         when (인자) {
            인자에 일치하는 값 혹은 표현식 -> 수행할 문장
            인자에 일치하는 범위 -> 수행할 문장
            ...
            else -> 수행할 문장
         }

         when 블록의 안을 보면 화살표(->) 왼쪽에는 일치하는 값, 표현식, 범위로 조건을 나태내고
         오른쪽에는 수행할 문자을 사용한다.
         조건과 일치하는 값이 없으면 else문 다음에 작성한 문장을 실행
         */
    when (readLine()!!.toInt()) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {   // 블록 사용 가능
            print("x는 1, 2가 아닙니다.")
        }
    }

    // 일치되는 조건을 한 번에 여러 개 표현하려면 쉼표(,)를 이용
    when (readLine()!!.toInt()) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("기타")
    }

    //------------------------------------------------------------------------------------
    // when문에 함수의 반환값 사용하기
    val s = 3
    when (readLine()!!.toInt()) {
        parseInt(s) -> print("일치함!")
        else -> print("기타")
    }
    // 입력값이 함수의 반환값과 일치하면 문장을 실행하도록 구성할 수도 있다.

    //------------------------------------------------------------------------------------
    // when문에 in 연산자와 범위 지정자 사용하기
    when (readLine()!!.toInt()) {
        in 1..10 -> print("x는 1 이상 10 이하입니다.")
        !in 10..20 -> print("x는 10 이상 20 이하의 범위에 포함되지 않습니다.")
        else -> print("x는 어떤 범위에도 없습니다.")
    }
    // 이때 in 연산자 앞에 느낌표를 사용하면(!in) 해당 범위 이외의 요소를 가리키게 된다.

    //------------------------------------------------------------------------------------
    // when과 is 키워드 함께 사용하기
    // is 키워드를 사용하면 특정 자료형을 검사할 수 있다.
    val str = "안녕하세요."
    val result = when(str) {
        is String -> "문자열입니다."
        else -> false
    }

    // 다른 예제
    print("Enter the score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    when(score) {
        in 90.0..100.0 -> grade = 'A'
        in 80.0..89.9 -> grade = 'B'
        in 70.0..79.9 -> grade = 'C'
        !in 70.0..100.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

    //------------------------------------------------------------------------------------
    // 인자가 없는 when문
    // when문에 인자가 주어지지 않으면 else if문처럼 각각의 조건을 실행할 수 있다.
    /**
     when {
        조건[혹은 표현식] -> 실행할 문장
        ...
     }

     when문에 인자를 두지 않은 경우에는 조건이나 표현식을 직접 만들 수 있기 때문에 특정 인자에
     제한하지 않고 다양한 조건을 구성할 수 있다.
     */
    print("Enter the score: ")
    var score = readLine()!!.toDouble()
    var grade: Char = 'F'

    when {
        score >= 90.0 -> grade = 'A'    // 인자 있는 when문과 다르게 조건식을 구성할 수 있음
        score in 80.0..89.9 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

    //------------------------------------------------------------------------------------
    // 다양한 자료형의 인자 받기
    // when문의 인자로서 Any를 사용하게 되면 다양한 자료형의 인자를 받을 수 있다.
    cases("Hello")  // 2. String형
    cases(1)    // Int형
    cases(System.currentTimeMillis())   // 현재 시간(밀리초 단위)을 Long형 값으로 반환
    cases(MyClass())    // 객체
}

fun parseInt(num: Int) = 2

fun cases(obj: Any) {
    when (obj) {
        1 -> println("Int: $obj")
        "Hello" -> println("String: $obj")
        is Long -> println("Long: $obj")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}