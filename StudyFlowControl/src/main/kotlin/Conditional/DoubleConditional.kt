package Conditional

// else if문으로 조건문 중첩하기

fun main() {
    // number 변수가 0보다 크면 "양수 값", 0보다 작으면 "음수 값" 그 외의 경우(number가 0인 경우)는 "0"을 반환하는 코드!

    val number = 0
    val result = if (number > 0)
            "양수 값"
        else if (number < 0)
            "음수 값"
        else
            "0"


    // else if문을 사용한 등급 판별하기
    print("Enter the score : ")
    val score = readLine()!!.toDouble() // 콘솔로부터 입력받음
    var grade: Char = 'F'

    if (score >= 90.0) {
        grade = 'A'
    } else if (score >= 80.0 && score <= 89.9) {
        grade = 'B'
    } else if (score >= 70.0 && score <= 79.9) {
        grade = 'C'
    }

    println("Score: $score, Grade: $grade")

    //------------------------------------------------------------------------------------
    // in 연산자와 범위 연산자로 조건식 간략하게 만들기
    // 코틀린에서는 포함 여부 확인을 위한 in 연산자와 2개의 점(..)으로 구성된 범위(range) 연산자를 제공

    // 변수 이름 in 시작값..마지막값

    // 위의 코드를 수정해보자.
    if (score >= 90) {
        grade = 'A'
    } else if (score in 80.0..89.9) {
        grade = 'B'
    } else if (score in 70.0..79.9) {
        grade = 'C'
    }
}