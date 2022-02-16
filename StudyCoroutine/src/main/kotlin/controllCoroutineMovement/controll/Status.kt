package controllCoroutineMovement.controll

import kotlinx.coroutines.*

/**
 * 실행 상태의 판단
 *
 * 만일 코드를 중단하기 위해 코루틴에 조건식을 넣으려고 할 때 연산이 마무리되기 전까지는
 * 조건식에 의해 루틴이 중단되지 않는다는 것을 기억해야 한다.
 * 다음 코드를 보자!
 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = GlobalScope.launch {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // 조건을 계산에 의해 반복
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

    /**
     * delay(1300L) 이후 작업 취소 함수에 의해 시그널을 받아 루틴이 바로 취소될 것 같지만
     * while(i < 5) { ... } 루프를 사용하면 루프가 완료될 때까지 루틴이 끝나지 않는다.
     *
     * 취소 시그널을 받아 루프를 중단하려면 소스 코드에서 while(i < 5)를 while(isActive)로 변경한다.
     * 다시 실행하면 의도한 시간에 루프가 취소되어 중단한다.
     */
}