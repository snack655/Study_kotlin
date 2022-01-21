package Loop

/**
 while문은 조건식이 true를 만족하는 경우 while문의 블록을 무한히 반복
 조건식이 false가 되면 실행문이 중단되어 while 루프(반복)를 빠져나갑니다.
 while (조건식) { // 조건식이 true인 동안 본문의 무한 반복
    본문
    ....
 }

 var i = 1
 while (i <= 5) {
    println("$i")
    ++i  // 계속 반복하다 보면 조건식의 i 값이 5를 넘어갈 때 false가 되어 탈출
 }
 */

fun main() {
    // while문 응용하여 팩토리얼 계산하기
    print("Enter the number : ")
    var number = readLine()!!.toInt()
    var factorial: Long = 1

    while (number > 0) {  // n * ... * 4 * 3 * 2 * 1
        factorial *= number
        --number
    }

    println("Factorial : $factorial")
}

