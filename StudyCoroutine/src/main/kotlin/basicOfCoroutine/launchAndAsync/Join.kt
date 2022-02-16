package basicOfCoroutine.launchAndAsync

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * join() 함수의 결과 기다리기
 *
 * 명시적으로 코루틴의 작업이 완료되는 것을 기다리게 하려면 Job 객체의 join() 함수를 사용하면 된다.
 * launch에서 반환하는 값은 Job 객체이므로 이것을 이용해 main() 함수에서 join() 함수를 호출할 수 있다.
 */

fun main() = runBlocking<Unit> {
    val job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join()  // 명시적으로 코루틴이 완료되길 기다림. 최소할 경우 job.cancel() 함수를 사용
}


/**
 * launch는 Job 인스턴스를 반환한다.
 * 이 경우에 main() 함수는 job에서 지정한 작업이 완료되기 전까지 기다린다.
 * 작업을 취소하려면 cancel() 함수를 사용할 수 있다.
 */