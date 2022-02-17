package sharedDataProblem.synchronization

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

/**
 * 원자 변수
 *
 * 원자 변수(Atomic Variable)란?
 * 특정 변수의 증가나 감소, 더하기나 빼기가 단일 기계어 명령으로 수행되는 것을 말하며
 * 해당 연산이 수행되는 도중에는 누구도 방해하지 못하기 때문에 값의 무결성을 보장할 수 있게 된다.
 *
 * 단일 기계어 명령이란?
 * CPU가 명령을 추리할 때의 최소 단위이다.
 * 이 최소 단위는 누구도 방해할 수 없다.
 * 다음 코드를 작성하고 여러 번 실행될 때 마다 결과를 살펴보자.
 */

//var counter = 0 // 병행 처리 중 문제가 발생할 수 있는 변수
var counter = AtomicInteger(0)  // 원자 변수로 초기화

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 1000    // 실행할 코루틴 수
    val k = 1000    // 각 코루틴을 반복할 수
    var time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main() = runBlocking {
    massiveRun {
        // counter++   // 증가 연산에서 값에서 무결성에 문제가 발생할 수 있다.
        counter.incrementAndGet()   // 원자 변수의 멤버 메서드를 사용해 증가
    }
    // println("Counter = $counter")
    println("Counter = ${counter.get()}")   // 값 읽기
}

/**
 * 이 코드에서는 counter 변수의 값을 증가시키는 연산을 하고 있다.
 * 순차적 프로그랭에서는 문제가 앖으나
 * 많은 수의 독립적인 루틴이 이 코드에 접근해 counter를 공유하면 언제든 코드가
 * 중단될 수 있음을 생각해야 한다.
 *
 * 중단 시점은 CPU의 최소 단위인 명령어가 실행될 때 결정된다.
 * 코드상에서는 counter++이라는 한 줄의 코드인지만
 * 이것이 컴파일되서 CPU가 실행할 명령어로 반환되면 여러 개의 명령어로 분활되므로
 * 프로그래머가 예상하지 못한 결과를 초래할 수도 있다.
 *
 * 즉, counter의 증가를 시작했지만 CPU의 최소 명령어가 마무리되지 않은 시점에서 루틴이 중단되어서
 * 다른 루틴이 counter를 걷드릴 수 있다.
 *
 * 코드상에서는 한 줄로 작성된 코드에 진입한 것처럼 보이지만
 * 결국 내부적으로는 값이 증가되지 못하고 다른 루틴이 실행되어 버린 것이다.
 * 이떄 다른 루틴이 해당 변수를 조작할 수 있기 때문에 값의 무결성을 보장할 수 없게 된다.
 * 이렇게 되면 실행 결과가 매번 달라질 수 있다.
 *
 * 원자 변수를 사용하면 이때 counter의 증가 연산 부분을 CPU의 기계어 명령 하나로 컴파일 하게 된다.
 * 따라서 값이 무결성을 보장한다.
 *
 * AtomicInteger(0)
 * counter.incrementAndGet()
 * counter.get()
 *
 * 전용 메서드는 코드를 단일 기계어 명령으로 변환하므로
 * 값의 무결성을 보장하고 예상할 수 있는 값으로 실행된다.
 */

