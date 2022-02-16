package basicOfCoroutine.launchAndAsync.launch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val job: Job = GlobalScope.launch {  // Job 객체의 반환
        delay(1000L)
        println("World!")
    }
    println("Hello, ")
    println("job.isActive: ${job.isActive}, completed: ${job.isCompleted}")
    Thread.sleep(2000L)
    println("job.isActive: ${job.isActive}, completed: ${job.isCompleted}")
}