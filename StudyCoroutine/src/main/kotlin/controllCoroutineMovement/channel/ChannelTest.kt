package controllCoroutineMovement.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 채널의 동작
 *
 * 채널(Channel)은 자료를 서로 주고받기 위해 약속된 일종의 통로 역할을 한다.
 * 코루틴의 채널은 넌블로킹 전송 개념으로 사용되고 있다.
 * 채널을 구현할 때는 SendChannel과 ReceiveChannel 인터페이스를 이용해 값들의
 * 스트림을 전송하는 방법을 제공한다.
 * 실제 전송에는 다음과 같이 다음과 같이 지연 함수의 send()와 receive() 함수를 사용한다.
 *
 * - SendChannel의 suspend fun send(element: E)
 * - ReceiveChannel의 suspend fun receive(): E
 *
 * 코틀린 채널을 사용하는 간단한 예제를 작성해 보자!
 */

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        // 여기에 다량의 CPU 연산 작업이나 비동기 로직을 둘 수 있음
        for (x in 1..5) channel.send(x * x)
    }
    repeat(5) { println(channel.receive()) }    // 5개의 값을 채널로부터 받음
    println("Done!")

    /**
     * 채널을 통해 send() 함수로 값을 보내 놓으면 이후 receive() 함수를 통해 값을 받을 수 있다.
     * 일반 큐와는 다르게 더이상 전달 요소가 없으면 채널을 닫을 수 있다.
     * 보통 for문을 구성해 채널을 받고 close()를 사용하면 바로 채널을 닫는 것이 아니라 닫겠다는 특수한 토큰을 보낸다.
     */

    launch {
        for (x in 1..5) channel.send(x * x)
        channel.close() // 모두 보내고 닫기 명시
    }
    for (element in channel) println(element)   // for문을 사용해 끝까지 읽기
    println("Done!")

    /**
     * 여기서 보내는 쪽과 받는 쪽에 몇 가지 중요한 상태가 있다.
     * 송신자는 SendChannel에서 채널이 꽉 차있는지,
     * 즉 isFull 값이 true인지 살펴보고 꽉 차있으면 일시 지연 된다.
     * 만일 close()에 의해 닫으면 isClosedForSend가 true로 지정되어 isFull은 false를 반환할 수 있다.
     * 수신자는 isEmpty가 true라면 비어 있으므로 가져갈 게 없는 루틴은 일시 지연된다.
     * 마찬가지로 닫을 경우 isClosedForReceive에 의해 false를 반환할 수 있다.
     * 그 밖의 SendChannel과 ReceiveChannel에는 다음과 같은 메서드를 사용할 수 있다.
     *
     * SendChannel.offer(element: E): Boolean   // 가능하면 요소를 채널에 추가. 채널이 꽉 찬 경우 false를 반환
     * ReceiveChannel.poll(): E?    // 요소를 반환. 채널이 비어 있으면 null 반환
     */
}