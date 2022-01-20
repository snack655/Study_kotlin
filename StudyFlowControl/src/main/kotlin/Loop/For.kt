package Loop

/**
 for문

 for문은 변수를 선언하고 조건식에 따라 변수 값을 반복해서 증감하는 구문입니다.
 코틀린은 앞의 in 연산자와 함께 for문을 사용한다.
 for문은 내부적으로 반복을 처리하는 인터페이스인 이터레이터(Iterator)에 의해 배열이나 특정 값의 범위,
 컬렉션으로 불리는 요소 등에서 사용할 수 있다.

 for문은 변수의 값이 범위 안에 있다면 계속해서 for문의 본문을 수행할 수 있다.
 본문 실행 후 해당 변수가 증가하거나 감사하면서 값이 계속 바뀌어 범위 외의 값이 되면
 for의 본문을 탈출하게 된다.
 기본적으로 변수를 증가시킨다.

 다음은 for문의 기본형이다.
 for (요소 변수 in 컬렉션 또는 범위) { 반복할 본문 }

 ex
 for (x in 1..5) { // in과 범위 지정을 활용한 반복
    println(x)  // 본문
 }

 for문 블록의 내용이 단 한 줄이라면 다음과 같이 중괄호를 생략
 for (x in 1..5) println(x)
 */

fun main() {
    // for문을 이용해 1부터 10까지 더하기
    var sum = 0

    for (x in 1..10) sum += x
    print("sum: $sum")

    //------------------------------------------------------------------------------------
    // 하행, 상행 및 다양한 반복 방법
    // 5, 4, 3, 2, 1..?
    // for (i in 5..1) print(i) 아무것도 출력되지 않음

    // 이때는 범위 연산자 대신 downTo 키워드를 사용
    for (i in 5 downTo 1) print(i)

    // 홀수의 계수만 사용하기 위해 숫자를 2단계씩 증가하게 하려면?
    // step 키워드를 사용
    for (i in 1..5 step 2) print(i)

    // 혼합
    for (i in 5 downTo 1 step 2) print(i)
    // 5, 3, 1

    //------------------------------------------------------------------------------------
    // for문을 활용한 삼각형 출력하기
    // 별찍기..
    /**
     n: 줄 수 입력
     반복 (line: 1 -> n만큼) {
        반복 (space: 1 -> (n-line)만큼) { 공백 출력 }
        반복 (star: 1 -> (2*line-1)만큼) { 별표 출력 }
        개행
     }
     */

    println()
    print("Enter the lines: ")
    val n = readLine()!!.toInt()    // 콘솔로부터 입력받음

    for (line in 1..n) {
        for (space in 1..(n - line)) print(" ") // 공백 출력
        for (star in 1 until 2 * line) print("*") // 별표 출력
        println() // 개행
    }

    //------------------------------------------------------------------------------------
    // 1~100의 홀수의 합 구하기
    var total: Int = 0
    for (num in 1..100 step 2) total += num
    println("Odd total: $total")

    for (num in 0..99 step 2) total += num
    println("Even total: $total")
}


