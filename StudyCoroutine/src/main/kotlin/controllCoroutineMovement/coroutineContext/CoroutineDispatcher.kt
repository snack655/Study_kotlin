package controllCoroutineMovement.coroutineContext

import kotlinx.coroutines.*

/**
 * 코루틴의 문맥
 *
 * 코루틴은 항상 특정 문맥에서 실행된다.
 * 이때 어떤 문맥에서 코루틴을 실행할지는 디스패처(Dispatcher)가 결정한다.
 */

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()

    jobs += launch(Dispatchers.Unconfined) { // 3 메인 스레드에서 작업
        println("Unconfined: \t\t ${Thread.currentThread().name}")
    }

    jobs += launch(coroutineContext) { // 부모의 문맥, 여기서는 runBlocking의 문맥
        println("coroutineContext:\t ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.Default) {   // 1 디스패처의 기본값
        println("Default:\t\t ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.IO) {    // 2 입출력 중심의 문맥
        println("IO:\t\t ${Thread.currentThread().name}")
    }

    jobs += launch {
        println("main runBlocking: ${Thread.currentThread().name}")
    }

    jobs += launch(newSingleThreadContext("MyThread")) {    // 4 새 스레드를 생성
        println("MyThread:\t\t ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }
}

/**
 * 코루틴은 CoroutineContext으로 구현된 형식의 문맥을 가진다.
 * CoroutineDispatcher는 추상 클래스로 몇 가지 디스패처 객체를 정의하고 있다.
 * 다음은 디스패처 객체를 정리한 것이다.
 *
 * 1 기본 문맥
 * 먼저 Dispatchers.Default는 기본 문맥인 CommonPool에서 실행되고 GlobalScope로도 표현된다.
 * 따라서 launch(Dispatchers.Default) { ... }와 GlobalScope.launch { ... }는 같은 표현이다.
 * 이것이 공유된 백그라운드 스레드의 CommonPool에서 코루틴을 실행하도록 한다.
 * 다시 말하면 스레드를 새로 생성하지 않고 기존에 있는 것을 이용한다.
 * 따라서 연산 중심의 코드에 적합하다.
 *
 * 2 I/O를 위한 문맥
 * Dispatchers.IO는 입출력 위주의 동작을 하는 코드에 접합한 공유된 풀이다.
 * 따라서 블로킹 동작이 많은 파일이나 소켓 I/O 처리에 사용하면 좋다.
 *
 * 3 Unconfined 문맥
 * Dispatchers.Unconfined는 호출자 스레드에서 코루틴을 시작하지만 첫 번째 지연점까지만 실행한다.
 * 특정 스레드나 풀에 가두지 않고, 첫 번째 일시 중단 후 호출된 지연 함수에 의해 재개된다.
 * 이 옵션을 사용하는 것은 권장하지 않는다.
 *
 * 4 새 스레드를 생성하는 문맥
 * newSingleThreadContext는 사용자가 직접 새 스레드 풀을 만들 수 있다.
 * 새 스레드를 만들기 때문에 비용이 많이 들고 더 이상 필요하지 않으면 해제하거나 종료시켜야 한다.
 * 이 옵션은 성능상의 이유로 향후 변경될 가능성이 크다.
 * 코루틴 안에 또 다른 코루틴을 정의하면 자식 코루틴이 된다.
 * 부모가 취소(cancel)되는 경우 자식 코루틴은 재귀적으로 최소된다.
 * 따라서 필요한 경우 join() 함수를 사용해 명식적으로 처리를 기다리도록 만들 수 있다.
 */