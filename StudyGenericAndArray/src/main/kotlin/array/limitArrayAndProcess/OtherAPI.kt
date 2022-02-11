package array.limitArrayAndProcess

/**
 * 기타 배열 관련 API 사용하기
 *
 * 배열의 유용한 메서드를 더 살펴보자.
 */

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(arr.first())    // 첫 번째 요소 확인
    println(arr.last())     // 마지막 요소 확인

    println("indexOf(3): ${arr.indexOf(3)}")    // 요소 3의 인덱스 출력
    println("average: ${arr.average()}")    // 배열의 평균 값 출력
    println("count: ${arr.count()}")    // 요소 개수 세기

    /**
     * 그 밖에 요소의 순서를 완전히 뒤집는 reversedArray(), reverse(), 요소를 합산하는 sum(),
     * 주어진 요소를 채우는 fill() 등 다양한 메서드가 있다.
     * 또 다른 유용한 메서드로서 배열에 특정 요소가 포함되어 있는지 확인하는 contains()가 있다.
     * 이떄 지정한 요소가 존재한다면 true를 반환한다.
     * 함수의 구조는 다음과 같다.
     *
     * operator fun <T> Array<out T>.contains(element: T): Boolean
     */

    println(arr.contains(4))    // arr 배열에 요소 4가 포함되었는지 확인
    println(4 in arr)
}

