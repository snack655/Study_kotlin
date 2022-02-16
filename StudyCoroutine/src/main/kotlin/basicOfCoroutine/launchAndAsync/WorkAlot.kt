package basicOfCoroutine.launchAndAsync

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 많은 작업의 처리
 *
 * 10만 개의 코루틴을 List로 생성하고 각 루틴으로 화면에 점(.)을 찍도록 작성해 보자.
 */

fun main() = runBlocking {
    val jobs = List(100_000) {  // 많은 양의 코루틴을 위한 List
        launch {
            delay(1000L)
            print(".")
        }
    }
    jobs.forEach { it.join() }  // 모든 jobs가 완료될 때까지 기다림

    /**
     * 이런 코드를 스레드로 바꾸면 Out-of-memory 오류가 발생한다.
     * 하지만 코루틴으로 작업하면 단 몇 개에 스레드로 수많은 코루틴을 생성해 실행할 수 있기 때문에
     * 오류가 발생하지 않는다.
     * 또 메모리나 실행 속도 면에서 큰 장점을 가진다.
     *
     * 또 다른 방법으로는 repeat() 함수를 사용하면 손쉽게 많은 양의 코루틴을 생성할 수 있다.
     */

    repeat(100_000) {
        launch {
            delay(1000L)
            print("#")
        }
    }
}

