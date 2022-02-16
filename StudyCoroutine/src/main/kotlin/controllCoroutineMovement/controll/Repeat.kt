package controllCoroutineMovement.controll

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * repeat() 함수를 사용한 반복 동작하기
 *
 * 앞의 예제처럼 지속적으로 반복하는 코드를 작성하기 위해 repeat() 함수를 이용할 수 있다.
 * 그러면 백그라운드에서 실행하는 일종의 데몬(daemon) 스레드를 구성할 수 있다.
 */

fun main() = runBlocking<Unit> {
    GlobalScope.launch { // 만일 launch만 사용하면 종료되지 않음
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
}

/**
 * 1000회를 반복하기 위해 repeat() 함수에 1000이라는 인자를 주고 있다.
 * 하지만 GlobalScope로 생명주기를 한정했기 때문에 메인 스레드가 종료되어 버리면 더 이상 진행되지 않는다.
 * 여기서 1.3초 뒤 종료되므로 약 3번 정도만 진행되고 중단된다.
 * 만일 GlobalScope를 제거하면 모든 횟수를 진행할 때까지 프로그램이 종료되지 않는다.
 */