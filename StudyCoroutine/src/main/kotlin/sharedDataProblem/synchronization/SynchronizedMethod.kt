package sharedDataProblem.synchronization

/**
 * synchronized 메서드와 블록
 *
 * 자바에서 synchronized는 메서드나 코드 블록에 사용할 수 있다.
 * 스레드 간 서로 공유하는 데이터가 있을 때 동기화해서 데이터의 안정성을 보장한다.
 * 특정 스레드가 이미 자원을 사용하는 중이면 나머지 스레드의 접근을 막는 것이다.
 *
 * 코틀린에서 이것을 메서드에 사용하려면 @Synchronized 애노테이션 표기법으로 사용해야 한다.
 */

@Synchronized fun synchronizedMethod() {
    println("inside: ${Thread.currentThread()}")
}