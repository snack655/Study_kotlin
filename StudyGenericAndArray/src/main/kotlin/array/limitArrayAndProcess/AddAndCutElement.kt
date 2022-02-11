package array.limitArrayAndProcess

import java.util.*

/**
 * 배열에 요소 추가하고 잘라내기
 *
 * 배열이 일단 정의하면 고정되기 때문에 다음과 같이 새로 할당하는 방법으로
 * 요소를 추가하거나 잘라낼 수 있다.
 */

fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5)    // 5개로 고정된 배열

    val arr2 = arr1.plus(6) // 하나의 요소를 추가한 새 배열 생성
    println("arr2: ${Arrays.toString(arr2)}")

    /**
     * arr1은 5개의 요소로 초기화되면서 더 이상 추가할 수 없다.
     * 새로운 요소를 추가하기 위해 새로운 배열 arr2를 선언하고 arr1의 멤버 메서드인 plus()를
     * 사용해 요소 6이 추가된 새배열을 arr2에 할당한다.
     *
     * 그러면 기존 배열 arr1을 잘라내보자.
     * 멤버 메서드인 sliceArray()를 호출해 잘라낸다.
     * 마찬가지로 arr1에 다시 설정할 수 없다.
     */

    val arr3 = arr1.sliceArray(0..2)    // 필요한 범위를 잘라내 새 배열 생성
    println("arr3: ${Arrays.toString(arr3)}")
}