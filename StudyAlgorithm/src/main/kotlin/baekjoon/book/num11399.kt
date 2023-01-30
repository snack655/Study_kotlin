package baekjoon.book

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val a = MutableList(n) {
        nextInt()
    }

    // 삽입 정렬하기  24 32 40 42 60
    for (i in 1 until n) {
        var insertPoint = i
        val insertValue = a[i]

        for (j in (i - 1) downTo 0) {
            if (a[j] < a[i]) {
                insertPoint = j + 1
                break;
            }
            if (j == 0) {
                insertPoint = 0;
            }
        }

        for (j in i downTo insertPoint + 1) {
            a[j] = a[j - 1]
        }
        a[insertPoint] = insertValue
    }

    // 합 정렬 만들기
    val s = MutableList(n) { 0 }
    s[0] = a[0]
    for (i in 1 until n) {
        s[i] = s[i - 1] + a[i]
    }

    var sum = 0
    s.forEach {
        sum += it
    }
    print(sum)
}