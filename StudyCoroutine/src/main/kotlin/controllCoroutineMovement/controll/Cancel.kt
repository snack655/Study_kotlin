package controllCoroutineMovement.controll

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴 작업 취소하기
 *
 * 만일 join() 함수만 사용하면, main() 함수가 job의 완료를 기다리기 때문에
 * repeat() 함수의 1,000번의 반복 실행이 모두 진행된다.
 * cancel() 함수를 사용하면 job은 1.3초 뒤 작업을 취소하고 main() 함수가 종료된다.
 */

fun main() = runBlocking {
    val job = launch {
        repeat(1000){
            println(it)
            delay(500L)
        }
    }
    delay(1300L)
    job.cancel()
}