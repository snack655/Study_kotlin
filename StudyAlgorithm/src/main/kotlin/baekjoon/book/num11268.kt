package baekjoon.book

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val myQueue = PriorityQueue<Int> { o1, o2 ->
        val firstAbs = abs(o1);
        val secondAbs = abs(o2);
        if (firstAbs == secondAbs) return@PriorityQueue if (o1 > o2) 1 else -1
        else return@PriorityQueue firstAbs - secondAbs
    }

    for (i in 0 until n) {
        val request = readLine().toInt()
        if (request == 0) {
            println(if (myQueue.isEmpty()) "0" else myQueue.poll())
        } else {
            myQueue.add(request)
        }
    }
}