package baekjoon.book

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val num: Int = bufferedReader.readLine().toInt()

    val myQueue: Queue<Int> = LinkedList()
    for (i in 1..num) {
        myQueue.add(i)
    }

    while (myQueue.size > 1) {
        myQueue.poll()
        myQueue.add(myQueue.poll())
    }

    println(myQueue.peek())
}