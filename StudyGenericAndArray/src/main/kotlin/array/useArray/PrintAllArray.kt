package array.useArray

import java.util.*

/**
 * 배열의 내용 한꺼번에 출력하기
 *
 * 자바의 표준 라이브러리 Arrays에서 멤버인 toString()을 사용하면 배열의
 * 내용을 한꺼번에 출력할 수 있다.
 */

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(Arrays.toString(arr))   // [1,2,3,4,5] 출력

    /**
     * 다음과 같은 다차원 배열을 표시하고자 할 때는 deepToString()을 사용한다.
     */

    val array = arrayOf(intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 6, 7))
    println(array.contentDeepToString()) // [[1,2],[3,4],[5,6,7]] 출력
}
