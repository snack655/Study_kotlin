package array.useArray

/**
 * 다차원 배열
 *
 * 다차원 배열은 기본적인 배열을 묶어서 2차원 이상의 배열로 표현하는 형태를 말한다.
 * 2차원 배열은 기본 배열을 묶어 다시 배열로 표현한 것이다.
 * 이것은 1차원 배열로 나타낸 array1, array2, array3을 각각 선언한 후 이것을 배열 arr2d에
 * 다시 배열하는 방법으로 나타낼 수 있다.
 */

fun main() {
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)
    val array3 = arrayOf(7, 8, 9)

    val arr2d = arrayOf(array1, array2, array3)

    /**
     * 다음과 같이 arrayOf() 안에 또 다시 배열을 선언하는 방법으로 간략화할 수 있다.
     * val arr2d = arrayOF(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
     *
     * 이제 2차원 요소의 내용을 출력하려면 for문을 중첩해서 다음과 같이 사용해야 한다.
     */

    for (e1 in arr2d) {
        for (e2 in e1) {
            print(e2)
        }
        println()
    }

    /**
     * 먼저 arr2d에 대해 꺼낸 요소 e1은 1차원 배열이 된다.
     * 이것을 다시 중첩된 for문의 e2에서 각각의 요소를 꺼내게 된다.'
     * 실행 결과는 다음과 같다.
     *
     * 123
     * 456
     * 789
     *
     * 2차원 이상의 배열도 표현할 수 있다.
     * 3차원을 표현하기 위해 2차원 배열에서 배열을 한 단계 더 표현하면 된다.
     */
}



