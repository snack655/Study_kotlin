package controllCoroutineMovement.controll

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * 코루틴의 시간 만료
 *
 * 일정 실행 시간 뒤에 코루틴을 취소할 수 있도록 해 보자.
 * withTimeout()의 선언부는 다음과 같다.
 *
 * public suspend fun <T> withTimeout(timeMillis: Long, block: suspend CoroutineScope.() -> T): T { /* compiled code */ }
 *
 * 다음은 시간이 만료되면 block을 취소시키고 TimeoutCancellationException 오류가 발생하는 코드이다.
 * 예외를 발생하지 않고 null로 처리하려면 withTimeoutOrNull()을 사용한다.
 */

fun main() = runBlocking {
    try {
        withTimeout(1300L) {    // Timeout 예외 발생, null로 처리하는 경우 withTimeoutOrNull()을 사용
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("timed out with $e")
    }
}