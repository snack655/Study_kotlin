package basicOfCoroutine.launchAndAsync

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {    // 메인 스레드의 문맥
    GlobalScope.launch { // 새로운 코루틴을 백그라운드에 실행
        delay(1000L)    // 1초의 넌블로킹 지연(시간의 기본 단위는 ms)
        println("World!")    // 지연 후 출력
    }
    println("Hello,")   // 메인 스레드의 코루틴이 지연되는 동안 계속 실행
    Thread.sleep(2000L) // 메인 스레드가 JVM에서 바로 종료되지 않게 2초 기다림
    /**
     * 우리가 지금까지 사용한 main() 함수의 블록은 메인 스레드로서 작동하게 된다.
     * 실행 결과를 보면 "Hello"는 메인 스레드에 의해 바로 출력된다.
     * "World!"는 코루틴 코드의 부분으로 메인 스레드와 분리되어 백그라운드에서 1초 뒤 실행된다.
     * 따라서 메인 스레드의 코드보다 지연되어 실행된다.
     * 또한 메인 스레드와 별도로 실행되므로 넌블로킹 코드이기도 하다.
     *
     * 코루틴에서 사용하는 함수는 suspend()로 선언된 지연 함수여야 코투틴 기능을 사용할 수 있다.
     * suspend로 표기함으로서 이 함수는 실행이 일시 중단(suspended)될 수 있으며
     * 필요한 경우에 경우에 다시 재개(resume)할 수 있게 된다.
     *
     * 예제 코드의 delay()의 선언부를 보자.
     * public suspend fun delay(timeMillis: Long): kotlin.Unit { /* compiled code */ }
     *
     * delay()는 suspend와 함께 선언된 함수로 코루틴 블록에서 사용할 수 있게 된다.
     * suspend 키워드는 사용자 함수에서도 사용할 수 있다.
     * suspend 함수는 사용자가 실행을 일시중단 할 수 있음을 의미하고
     * 코루틴 블록 안에서 사용할 수 있다.
     * 만일 suspend 함수를 코루틴 블록 외에 사용하면 다음과 같은 오류를 만날 수 있다.
     *
     * Error:(9, 5) Kotlin: Suspend function 'delay' should be called only from a coroutine or another suspend function
     *
     * 사용자 함수를 추가하기 위해 예제에 다음과 같은 suspend 함수를 직접 선언하고 코루틴에서 사용해 보자.
     */

    suspend fun doSomething() {
        println("Do something!")
    }

    /**
     * 컴파일러는 suspend가 붙은 함수를 자동적으로 추출해 Continuation 클래스로부터 분리된 루틴을 만든다.
     * 이러한 지연 함수는 코루틴 빌더인 launch와 async에서 사용할 수 있지만 메인 스레드에서는 사용할 수 없다.
     * 지연 함수는 또 다른 지연 함수 내에서 사용하거나 코루틴 블록에서만 사용해야 한다.
     */
}

