package sharedDataProblem.synchronization

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * 상호 베제
 *
 * 상호 베제(Mutual Exclusion)는 코드가 임계 구역(Critical Section)에 있는 경우
 * 절대로 동시성이 일어나지 않게 하고 하나의 루틴만 접근하는 것을 보장한다.
 *
 * 임계 구역 또는 공유 변수 영역은 병렬 컴퓨팅에서 둘 이상의 스레드가 동시에 접근해서는
 * 안 되는 배타적 공유 자원의 영역으로 정의할 수 있다.
 *
 * 임께 구역은 잘못된 변경이 일어나지 않도록 보호해야 하는 코드가 있는 구역이므로 임계 영역의
 * 처리가 필요한 경우 임께 구역에 들어간 루틴은 다른 루틴이 못 들어오도록 잠가야 한다.
 *
 * 상호 배제의 특징으로는 소유자(Owner) 개념이 있는데
 * 일단 잠근 루틴만이 잠금을 해제할 수 있다는 뜻이다.
 * 다른 루틴은 잠금을 해제할 수 없다.
 * 자바에서는 비슷한 개념으로 보통 synchronized 키워드를 사용해 코드를 보호했다.
 * 코틀린의 코루틴에서는 Mutex의 lock과 unlock을 사용해 임계 구역을 만들 수 있다.
 *
 * 특정 루틴 혹은 태스크가 lock()을 걸고 임계 구역 코드에서 실행 중일 때는
 * 다른 어떤 태스크도 방해하지 못한다.
 * 또 다른 lock()이 호출되면 일시 중단된다.
 * tryLock()을 사용하면 이미 잠겨 있는 경우 false를 반환하고 바로 빠져나온다.
 * holdsLock()을 사용하면 소유자에 의한 잠금인지 확인한다.
 * 기본적인 코딩은 다음과 같다.
 *
 * val mutex = Mutex()
 * ...
 * mutex.lock()
 * ...  // 보호하고자 하는 임계 구역 코드
 * mutex.unlock()
 * ...
 *
 * 람다식 withLock을 사용하면 mutex.lock(); try { ... } finally { mutax.unlock() }와 같은
 * 패턴을 손쉽게 사용할 수 있다. 앞서 만든 코드를 다음과 같이 변경할 수 있다.
 */

val mutex = Mutex()
var counter3 = 0

fun main() = runBlocking {
    massiveRun {
        mutex.withLock {
            counter3++  // 임계 구역 코드
        }
    }
    println("Counter = $counter3")
}

/**
 * 이 밖에도 Mutex에는 검사를 위한 프로퍼티 isLocked가 있다.
 * isLocked는 mutex가 잠금 상태일 때 true를 반환한다.
 * onLock은 잠금 상태로 들어갈 때 select 표현식을 사용해 특정 지연 함수를 선택할 수 있다.
 */