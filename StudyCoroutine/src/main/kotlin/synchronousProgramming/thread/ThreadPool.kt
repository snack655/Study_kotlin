package synchronousProgramming.thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 스레드 풀 사용하기
 *
 * 애플리케이션의 비즈니스 로직을 설계할 때는 스레드가 자주 재사용된다.
 * 따라서 몇 개의 스레드를 먼저 만들어 놓고 필요에 따라 재사용하도록 설계할 수 있다.
 * 보통 이런 경우에는 newFixedThreadPool()로 스레드를 인자의 수만큼 만들고
 * 작업을 수행할 때 여기에서 재사용 가능한 스레드를 고르게 한다.
 */

fun main() {
    val myService: ExecutorService = Executors.newFixedThreadPool(8)
    var i = 0

    /*
    while (i < items.size) {    // 아주 큰 데이터를 처리할 때
        val item = items[i]
        myService.submit {
            processItem(item) // 여기서 아주 긴 시간 동안 처리하는 경우
        }
        i += 1
    }
     */
}