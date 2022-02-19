package baekjoon.stepProblem.step2

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // 윤년 문제
    val year = scanner.nextInt()
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        print("1")
    } else {
        print("0")
    }
}