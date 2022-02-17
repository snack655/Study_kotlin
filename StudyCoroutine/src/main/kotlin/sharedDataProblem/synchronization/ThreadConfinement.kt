package sharedDataProblem.synchronization

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

/**
 * 스레드 가두기
 *
 * 또 다른 방법으로 특정 문맥에서 작동하도록
 * 단일 스레드에 가두는(Thread Confinement) 방법이 있다.
 *
 * 보통 UI 애플리케이션에서 UI 상태는 단일 이벤트에 따라 작동해야 한다.
 * 이때 단일 스레드 문맥인 newSingleThreadContext를 사용할 수 있다.
 */

// 단일 스레드 문맥을 선언
var counterContext = newSingleThreadContext("CounterContext")
var counter2 = 0

suspend fun massiveRun2(context: CoroutineContext, action: suspend () -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch(context) {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Complete ${n * k} actions in $time ms")
}

fun main() = runBlocking {
    massiveRun2(counterContext) {
        counter2++
    }
    println("Counter = $counter2")
}

/**
 * 이 방법은 모두 원자 변수 방법보다는 약간 느린 결과를 보인다.
 * 어쨌든 스레드는 문맥상 counter를 독립적으로 가지며 처리하기 때문에
 * 공유 변수 counter의 연산의 무결성을 보장할 수 있다.
 * 다만 공간이 필요하므로 좀 느려진다는 점을 알아두자.
 */

