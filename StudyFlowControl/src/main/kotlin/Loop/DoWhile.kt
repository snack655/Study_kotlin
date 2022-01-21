package Loop

/**
 do~while문
 do~while문의 경우 일단 do블록에 작성한 본문을 한 번은 실행한 다음 마지막에 조건식을
 검사해서 true가 나오면 작업을 반복한다.

 do {
    본문
 } while (조건식)
 */

fun main() {
    // do~while문 사용해 보기
    do {
        print("Enter an integer : ")
        val input = readLine()!!.toInt()

        for (i in 0 until input) {
            for (j in 0 until input) print((i + j) % input + 1)
            println()
        }
    } while (input != 0)
}