package baekjoon.stepProblem.step2

import java.util.*

fun main() {
    val s = Scanner(System.`in`)
    val x: Int = s.nextInt()
    val y: Int = s.nextInt()
    when {
        x > 0 && y > 0 -> print("1")
        x < 0 && y > 0 -> print("2")
        x < 0 && y < 0 -> print("3")
        x > 0 && y < 0 -> print("4")
    }
}