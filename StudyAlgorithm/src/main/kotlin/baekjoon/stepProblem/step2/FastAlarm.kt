package baekjoon.stepProblem.step2

import java.util.*

fun main() {
    val s = Scanner(System.`in`)
    val hm = s.nextLine().split(" ")
    var (h, m) = hm

    if ( m.toInt() - 45 > 0 ) {
        print("$h ${m.toInt() - 45}")
    } else if (m.toInt() - 45 < 0) {
        if (h.toInt() == 0) {
            print("23 ${60 - (45 - m.toInt())}")
        } else {
            print("${h.toInt() - 1} ${60 - (45 - m.toInt())}")
        }
    }
}