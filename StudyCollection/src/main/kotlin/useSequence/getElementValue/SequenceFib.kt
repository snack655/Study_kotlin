package useSequence.getElementValue

/**
 * 시퀀스를 응요한 피보나치 수열
 *
 * 여러 프로그래밍 언어에서 피보나치 수열을 구현하기 위해 주로 재귀 함수를 사용했다.
 * 그러나 재귀 함수를 잘못 사용할 경우 시간이 폭발적으로 증가하거나 스택 오버플로 오류를 겪을 수 있다.
 * 이것을 해결하기 위해 함수형 프로그래밍 기법에서 다뤄 본 꼬리 재귀를 이용할 수도 있었다.
 * 이번에는 시퀀스 버전으로 만들자.
 */

fun main() {
    val fibonacci = generateSequence(1 to 1) {it.second to it.first + it.second}
        .map { it.first }
    println(fibonacci.take(10).toList())

    /**
     * 1 to 1
     * 1 to 2
     * 2 to 3
     * 3 to 5
     * 5 to 8
     * 8 to 13
     * ...
     * 55 to 89
     */
}