package useSequence.createElementValue

/**
 * 요소 값 생성하기
 *
 * generateSequence()로 생성하기
 *
 * 특정 값을 생성하기 우해 generateSequence()를 사용할 수 있다.
 * 이때 시드(Seed) 인수에 의해 시작 요소의 값이 결정된다.
 */

fun main() {
    // 시드 값 1을 시작으로 1씩 증가하는 시퀀스 정의
    val nums: Sequence<Int> = generateSequence(1) { it + 1 }

    // take()를 사용해 원하는 요소 개수만큼 획득하고 toList()를 사용해 List 컬렉션으로 반환
    println(nums.take(10).toList())

    /**
     * 주어진 식에 따라 새로운 컬렉션을 반환하는 map이나 filter 같은 연산을 사용할 수도 있다.
     */
    val squares = generateSequence(1) { it + 1 }.map { it * it }
    println(squares.take(10).toList())

    val oddSquares = squares.filter { it % 2 != 0 }
    println(oddSquares.take(5).toList())

    /**
     * map이나 filter는 호출할 때 바로 수행되어 실행할 때마다 새로운 List를 생성해 반환한다.
     * map이나 filter와 같은 메서드를 연속하는 메서드 체이닝(Method Chaining)을 쓴다면
     * 하나의 구문이 끝날 때마다 중간 결과로 새로운 List를 계속해서 만들어 낸다.
     */
}