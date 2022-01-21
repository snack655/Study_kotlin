package StopAndReturnOfFlow

/**
 break문과 continue문
 break는 해당 키워드를 사용한 지점에서 for나 while, do~while문 루프를 빠져나오게 된다.
 continue는 이후 본문을 계속 진행하지 않고 다시 반복 조건을 살펴보게 된다.

 예제를 만들자
 */

fun main() {
    for (i in 1..5) {
        if (i == 3) break
        print(i)
    }
    println()   // 개행 문자
    println("outside")

    //------------------------------------------------------------------------------------
    // break와 continue에 라벨 함께 사용하기
    fun labelBreak1() {
        println("labelBreak")
        for (i in 1..5) {
            second@ for (j in 1..5) {
                if (j == 3) break
                println("i:$i, j:$j")
            }
            println("after for j")
        }
        println("after fo i")
    }

    fun labelBreak2() {
        println("labelBreak2")
        first@ for (i in 1..5) {
            second@ for (j in 1..5) {
                if (j == 3) break@first
                println("i:$i, j:$j")
            }
            println("after for j")
        }
        println("after fo i")
    }
}