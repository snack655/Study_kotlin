package sharedDataProblem.actor

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor

/**
 * actor 코루틴 빌더
 *
 * 코루틴의 결합으로 만든 actor는 코루틴과 채널에서 통신하거나 상태를 관리한다.
 * 다른 언어의 actor 개념은 들어오고 나가는 메일 박스 기능과 비슷하지만
 * 코틀린에서는 들어오는 메일 박스 기능만 한다고 볼 수 있다.
 */

/*
data class Task(val desc: String)

val me = actor<Task> {
    while (!isClosedForReveive) {
        println(receive().desc.repeat(5))
    }
}
 */

/**
 *  actor는 한 번에 1개의 메시지만 처리하는 것을 보장한다.
 *  이 코드에서는 특정 루프를 만들고 isClosedForReceive로 닫힌 상태가 아니라면
 *  receive()를 사용해 desc를 반복 출력하도록 했다.
 *  만일 채널이 닫히게 되면 ClosedSendChannelException을 만나게 된다.
 */

/*
sealed class CounterMsg {
    object IncCounter : CounterMsg()    // counter를 증가하기 위한 단방향 메시지
    class GetCounter(val response: SendChannel<Int>) : CounterMsg()     // 응답 채널의 요청
}

// 새로운 counter actor를 위한 함수
fun CoroutineScope.counterActor() = actor<CounterMsg>(CommonPool) {
    var counter = 0 // actor의 상태로 공유되지 않음
    for (msg in channel) {  // 들어오는 메시지 처리
        when (msg) {
            is CounterMsg.IncCounter -> counter++
            is CounterMsg.GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() = runBlocking {
    val counter = counterActor()    // actor의 생성
    GlobalScope.massiveRun {
        counter.send(CounterMsg.IncCounter)
    }

    // actor의 counter 값을 얻기 위해 요청
    val response = CompletableDeferred<Int>()
    counter.send(CounterMsg.GetCounter(response))
    println("Counter = ${response.await()}")
    counter.close() // actor의 중단
}
 */

/**
 * 위의 프로그램은 함수로 쓰인 actor 블록을 생성하고 실행한다.
 * actor는 코루틴이고 순차적으로 실행되며 각 상태는 특정 actor 코루틴에 한정되므로 공유된
 * 변경 가능한 상태에도 문제가 없다.
 * 이 방법은 lock 기법보다 유용한데 문맥 전환이 없기 때문이다.
 * 들어오는 메시지 msg는 CounterMsg 자료형이다.
 * 만일 IncCounter가 사용되면 counter 상태를 증가시킨다.
 * actor는 어떤 특정 상태를 관리하기 위한 백그라운드 태스크에 유용하다.
 */