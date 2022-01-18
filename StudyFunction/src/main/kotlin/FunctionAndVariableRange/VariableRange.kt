package FunctionAndVariableRange

// 변수의 범위

/**
 지역 변수(Local Variable)와 전역 변수(Global Variable)
 특정 코드 블록 안에 있는 변수는 지역 변수
 지역 변수는 블록을 벗어나면 프로그램 메모리에서 더 이상 사용되지 않고 삭제

 전역 변수는 최상위에 있는 변수로 프로그램이 실행되는 동안 삭제되지 않고 메모리에 유지된다.
 코드가 길어지면 전역 변수에 동시 접근하는 코드는 프로그램의 잘못된 동작을 유발
 자주 사용되지 않는 전역 변수는 메모리 자원 낭비 */

var global = 10 // 패키지 FunctionAndVariableRange의 모든 범위에 적용되는 전역 변수

fun main() {

    val local1 = 20 // main() 함수 블록 안에서만 유지되는 지역 변수
    val local2 = 21

    fun nestedFunc() {
        global += 1
        val local1 = 30 // func() 함수 블록 안에서만 유지(기존 local1이 가려짐)
        println("nestedFunc local1 : $local1")
        println("nestedFunc local1 : $local2") // 이 블록 바로 바깥의 main()의 local2 사용
        println("nestedFunc global : $global")
    }

    nestedFunc()
    outsideFunc()

    println("main global : $global")
    println("main local1 : $local1")
    println("main local2 : $local2")
}

fun outsideFunc() {
    global += 1
    val outVal = "outside"
    println("outsideFunc global : $global")
    println("outsideFunc outVal : $outVal")
}
