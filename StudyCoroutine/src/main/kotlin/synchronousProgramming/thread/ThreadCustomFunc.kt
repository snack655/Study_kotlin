package synchronousProgramming.thread

/**
 * 사용자 함수를 통해 스레드 생성하기
 *
 * start나 기타 매개변수로 상태 제어가 쉽도록 다음과 같이 추가 람다식을 직접 만들어도 된다.
 */

// 람다식을 추가로 만들어 실행
public fun thread(start: Boolean = true, isDaemon: Boolean = false,
                  contextClassLoader: ClassLoader? = null,
                  name: String? = null, priority: Int = -1,
                  block: () -> Unit): Thread {
    val thread = object : Thread() {
        override fun run() {
            block()
        }
    }
    if (isDaemon)   // 백그라운드 실행 여부
        thread.isDaemon = true
    if (priority > 0)   // 우선순위 (1: 낮음 ~ 5: 보통 ~ 10: 높음)
        thread.priority = priority
    if (name != null)   // 이름
        thread.name = name
    if (contextClassLoader != null)
        thread.contextClassLoader = contextClassLoader
    if (start)
        thread.start()
    return thread
}

fun main() {
    // 스레드의 옵션 변수를 손쉽게 설정할 수 있음
    thread(start = true, isDaemon = true) {
        println("Current Threads(Custom function): ${Thread.currentThread()}")
        println("Priority: ${Thread.currentThread().priority}")
        println("Name: ${Thread.currentThread().name}")
        println("Name: ${Thread.currentThread().isDaemon}")
    }

    thread(start = true) {
        println("Current Threads(Custom function): ${Thread.currentThread()}")
        println("Priority: ${Thread.currentThread().priority}")
        println("Name: ${Thread.currentThread().name}")
        println("Name: ${Thread.currentThread().isDaemon}")
    }
}