package kotlinStandardFunction.other

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * 코틀린에는 람다식을 사용하는 시간 측정 함수를 표준 라이브러리에서도 제공한다.
 * 코틀린 kotlin.system 패키지에 있는 2개의 측정 함수
 * measureTimeMillis()와 measureNanoTime()을 사용할 수 있다.
 * 표준 라이브러리의 Timming.kt에 보면 두 함수는 다음과 같이 선언되어 있다.
 *
 * // kotlin.system 패키지의 Timing.kt 파일
 * public inline fun measureTimeMillis(block: () -> Unit): Long {
 *      contract {
 *          callsInPlace(block, InvocationKind.EXACTLY_ONCE)
 *      }
 *      val start = System.currentTimeMillis()
 *      block()
 *      return System.currentTimeMillis() - start
 * }
 *
 * public inline fun measureNanoTime(block: () -> Unit): Long {
 *      contract {
 *          callsInPlace(block, InvocationKind.EXACTLY_ONCE)
 *      }
 *      val start = System.nanoTime()
 *      block()
 *      return System.nanoTime() - start
 * }
 *
 * 표준 라이브러리 Timing.kt 파일의 코드를 보면
 * 밀리초(ms)와 나노초(ns)를 측정하는 함수 2개가 람다식으로 작성되어 block 코드의 내용을 측정할 수 있다.
 */

fun main() {
    val executionTime = measureTimeMillis {
        // 측정할 작업 코드
    }
    println("Execution Time = $executionTime ms")

    /**
     * 측정하려는 코드를 measureTimeMillis() 함수의 본문에 작성하면
     * 측정 시간을 Long형 값으로 얻을 수 있다.
     * 함수의 성능을 평가할 때 유용하다.
     */
}