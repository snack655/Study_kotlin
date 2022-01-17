package CaseOfHighOrderAndLambda

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

// 동기화를 위한 코드 구현 구경하기
// 동기화란?
// 변경이 일어나면 안 되는 특정 코드를 보호하기 위한 잠금 기법
// 동기화로 보호되는 코드는 임계 영역(Critical Section)이라고도 부른다.

var sharable = 1    // 보호가 필요한 공유 자원

fun main() {
    /**
    Lock lock = new ReentrantLock();
    lock.lock();    // 잠금
    try {
        // 보호할 임계 영역의 코드
        // 수행할 작업
    } finally {
        lock.unlock(); // 해제
    }
    **/

    val reLock = ReentrantLock()
    // 1, 2, 3 표현식이 모두 동일
    lock(reLock, { criticalFunc() }) // 1
    lock(reLock) { criticalFunc() }  // 2
    lock(reLock, ::criticalFunc)     // 3

    println(sharable)
}

fun <T> lock(reLock: ReentrantLock, body: () -> T): T {
    reLock.lock()
    try {
        return body()
    } finally {
        reLock.unlock()
    }
}

fun criticalFunc() {
    // 공유 자원 접근 코드 사용
    sharable += 1
}