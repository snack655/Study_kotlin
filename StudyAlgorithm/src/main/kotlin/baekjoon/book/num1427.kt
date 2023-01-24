package baekjoon.book

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine()
    val list = MutableList(str.length) {
        str[it].digitToInt()
    }

    for (j in 0 until list.size) {
        var max = j
        for (i in j + 1 until list.size) {
            if (list[max] < list[i])
                max = i
        }

        val swap = list[j]
        list[j] = list[max]
        list[max] = swap
    }

    list.forEach {
        print(it)
    }
}