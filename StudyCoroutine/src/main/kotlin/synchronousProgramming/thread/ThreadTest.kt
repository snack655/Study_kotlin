package synchronousProgramming.thread

/**
 * 스레드 생성하기
 *
 * 코틀린의 코루틴 프로그래밍을 해 보기 전에 기존 자바에서 사용하던 스레드를 생성하는 방법을 알아보자.
 * 스레드 루틴을 만들려면 Thread 클래스를 상속받거나 Runnable 인터페이스를 구현한다.
 */

// 1 Thread 클래스를 상속받아 구현하기
class SimpleThread: Thread() {
    override fun run() {
        println("Current Threads: ${Thread.currentThread()}")
    }
}

// 2 Runnable 인터페이스로부터 run() 메서드 구현하기
class SimpleRunnable: Runnable {
    override fun run() {
        println("Current Threads: ${Thread.currentThread()}")
    }
}

fun main() {
    val thread = SimpleThread()
    thread.start()

    val runnable = SimpleRunnable()
    val thread1 = Thread(runnable)
    thread1.start()

    /**
     * 1번에서는 Thread를 직접 상속받아 구현했다.
     * 이 경우에는 다중 상속이 허용되지 않기 때문에 Thread 이외의 클래스를 상속할 수 없다.
     * 2번에서는 Runnable 인터페이스를 구현한 것이므로 다른 클래스를 상속할 수도 있다.
     *
     * 스레드에서 실행할 코드는 run() 메서드를 오버라이딩해서 구현해 둔다.
     * 이것을 실행하려면 해당 클래스 객체의 start() 메서드를 호출하면
     * 각 스레드의 run() 본문을 수행하는 독립된 실행 루틴이 동작하게 된다.
     *
     * 익명 객체를 사용하면 클래스의 객체를 만들지 않고도 다음과 같이 실행할 수 있다.
     */
    object : Thread() {
        override fun run() {
            println("Current Threads(object): ${Thread.currentThread()}")
        }
    }.start()

    /**
     * 이 코드는 코틀린의 객체 표현식에 의해 익명 클래스로 생성하고
     * run() 메서드를 오버라이딩해서 구현했다.
     * 그리고 start() 메서드를 통해 스레드를 실행한다.
     */

    Thread {
        println("Current Threads(lambda): ${Thread.currentThread()}")
    }.start()
}