package controllCoroutineMovement.produce

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 버퍼를 가진 채널
 *
 * 채널에는 기본 버퍼가 없으므로 send() 함수가 먼저 호출되면
 * receive() 함수가 호출되기 전까지 send() 함수는 일시 지연된다.
 * 반대의 경우도 receive() 함수가 호출되면
 * send() 함수가 호출되기 전까지 receive() 함수는 지연된다.
 *
 * 하지만 채널에 버퍼 크기를 주면 지연 없이 여러 개의 요소를 보낼 수 있게 된다.
 * Channel() 생성자에는 capacity 매개변수가 있으며 이것이 버퍼 크기를 정한다.
 */

fun main() = runBlocking {
    val channel = Channel<Int>(3)   // 버퍼 capacity 값을 줌
    val sender = launch(coroutineContext) { // 송신자 측
        repeat(10) {
            println("Sending $it")
            channel.send(it)    // 지속적으로 보내다가 꽉 차면 일시 지연
        }
    }
    delay(1000) // 아무것도 받지 않고 1초 기다린 후
    sender.cancel() // 송신자의 작업을 취소
}