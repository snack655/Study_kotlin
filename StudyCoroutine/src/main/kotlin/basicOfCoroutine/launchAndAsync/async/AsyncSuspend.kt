package basicOfCoroutine.launchAndAsync.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private suspend fun doWork1(): String {
    delay(1000)
    return "Work1"
}

private suspend fun doWork2(): String {
    delay(3000)
    return "Work2"
}

private fun worksInSerial() {
    // 순차적 실행
    GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One: $one")
        println("Kotlin Two: $two")
    }
}

private fun worksInParallel() {
    // Deferred<T>를 통해 결괏값을 반환
    val one = GlobalScope.async {
        doWork1()
    }

    val two = GlobalScope.async {
        doWork2()
    }

    GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("Kotlin Combined : $combined")
    }
}

fun main() {
    //worksInSerial()
    worksInParallel()
    readLine()  // main()이 먼저 종료되는 것을 방지하기 위해 콘솔에서 [Enter]키 입력 대기
}
