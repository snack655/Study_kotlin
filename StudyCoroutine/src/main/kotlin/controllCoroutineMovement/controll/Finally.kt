package controllCoroutineMovement.controll

import kotlinx.coroutines.*

/**
 * finally의 실행 보장
 *
 * try~finally 구분을 사용해 finally 블록에서 코루틴의 종료 과정을 처리하도록 할 수 있다.
 * 다음 블록을 넣어 수정해 보자.
 */

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("Bye!")
        }
    }
    delay(1300L)
    job.cancelAndJoin() // 작업을 취소하고 완료될 때까지 기다림
    println("main: Quit!")

    /**
     * 일반적인 finally 블록에서 지연 함수를 사용하려고 하면 코루틴이 취소되므로
     * 지연 함수를 사용할 수 없다.
     * 그 외에 파일을 닫거나 통신 채널을 닫는 등의 작업은 넌블로킹 형태로 작동하며
     * 지연 함수를 포함하고 있지 않기 때문에 문제가 없다.
     *
     * 만일 finally 블록에 시간이 걸리는 작업이나 지연 함수가 사용될 경우 실행을 보장하기 위해서는
     * NonCancellable 문맥에서 작동하도록 해야 한다.
     * 이것을 위해 withContext(NonCancellable) { ... }을 사용해
     * 다음과 같이 finally 블록을 구성할 수 있다.
     * 다음은 1초 이후에도 println() 함수의 실행을 보장하는 예이다.
     */

    val job2 = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {   // finally의 완전한 실행을 보장함
                println("I'm running finally")
                delay(1000L)
                println("Non-Cancellable")  // 1초를 지연해도 취소되지 않음
            }
        }
    }
}