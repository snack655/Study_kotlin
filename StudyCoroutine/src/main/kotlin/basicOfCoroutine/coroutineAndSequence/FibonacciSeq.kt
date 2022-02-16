package basicOfCoroutine.coroutineAndSequence

val fibonacciSeq = sequence {
    var a = 0
    var b = 1
    yield(1)    // 1 지연 함수가 사용됨

    while (true) {
        yield(a + b)    // 2
        val tmp = a + b
        a = b
        b = tmp
    }
}

fun main() {
    println(fibonacciSeq.take(8).toList())  // 8개의 값을 획득

    /**
     * 1번의 sequence 블록에서 지연 함수인 yield() 함수를 호출하면서 코루틴을 생성한다.
     * 2번의 while 루프는 매 단계를 무한하게 순회할 떄 코루틴에서 다음 수를 계산하도록 실행된다.
     * 3번에서 take().toList()에 의해 무한한 피보나치 수열 중 8개를 List로 변환해 화면상에 출력한다.
     *
     * 여기서 핵심은 yield() 함수의 작동 방식이다.
     * 각 표현식을 계속 진행하기 전에 실행을 잠시 멈추고 요소를 반환한다.
     * 이것은 값을 산출(yielding)한다고 이야기할 수 있다.
     * 그리고 멈춘 시점에서 다시 실행을 재개한다.
     * 1번과 2번은 작업이 일시 중단되었다가 다시 재개되는 부분이다.
     * 3번에서 이렇게 가져온 데이터는 사실 일회성이기 때문에 어딘가에 저장되어 있지 않고
     * 단 한 번 사용될 뿐이다.
     *
     * 위 소스 코드를 수정해 보자.
     */

    println(seq.take(7).toList())

    /**
     * 여기서는 yieldAll()을 사용해 반복적으로 멈추게 되면서 특정 범위의 값을
     * 산출할 수 있다. 또한 yieldAll()을 사용해 무한한 시퀀스를 만들어 내는
     * generateSequence() 함수를 사용해서도 요소 값을 산출할 수 있다.
     *
     * 모든 요소는 일회성이기 때문에 각 요소에 대한 다음 요소를 직접 지정하려면 iterator()를
     * 통해 next() 메서드를 사용해야 한다.
     */

    val saved = fibonacciSeq.iterator()
    println("${saved.next()}, ${saved.next()}, ${saved.next()}")
}

val seq = sequence {
    val start = 0

    yield(start)
    yieldAll(1..5 step 2)
    yieldAll(generateSequence(8) { it * 3 })    // 무한한 시퀀스에서 산출
}
