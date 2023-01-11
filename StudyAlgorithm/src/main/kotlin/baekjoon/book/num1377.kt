package baekjoon.book

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { idx ->
        Data(readLine().toInt(), idx)
    }
    arr.sort()

    var max = 0
    arr.forEachIndexed { index, mData ->
        if (max < mData.index - index) {
            max = mData.index - index
        }
    }
    println(max + 1)
}

data class Data(
    val value: Int,
    val index: Int
): Comparable<Data> {
    override fun compareTo(other: Data): Int = this.value - other.value
}