package useSequence.getElementValue

/**
 * 요소 값 가져오기
 *
 * 메서드 체이닝의 중간 결과 생성하기
 *
 * 중간 연산 결과 없이 한 번에 끝까지 연산한 후 결과를 반환하려면 asSequence()를 사용할 수 있다.
 * 특히 filter나 map을 메서드 체이닝해서 사용할 경우 순차적 연산이기 때문에 시간이 많이 걸릴 수 있지만
 * asSequence()를 사용하면 병렬 처리되기 때문에 처리 성능이 좋아진다.
 * 먼저 시퀀스를 사용하지 않는 기본 메서드 체이닝을 살펴보자.
 */

fun main() {
    val list1 = listOf(1, 2, 3, 4, 5)
    val listDefault = list1
        .map { println("map($it) "); it * it }  // 1
        .filter { println("filter($it) "); it % 2 == 0 }    // 2
    println(listDefault)

    /**
     * asSequence()를 통해 가져오기
     */
    val listSeq = list1.asSequence()
        .map { print("map($it) "); it * it }    // 1
        .filter { println("filter($it) "); it % 2 == 0 }    // 2
        .toList()   // 3
    println(listSeq)

    /**
     * 결과를 보면 연속적으로 map과 filter가 각각 수행된 것을 알 수 있으며,
     * 최종 결과는 toList()에 의해 만들어진 [4, 16]이다.
     * map의 수행 결과를 새로운 List에 만들고 이것을 다시 짝수인지 판별해
     * 리스트를 만드는 과정이 없어진 것이다.
     * 따라서 시퀀스를 사용하면 요소의 개수가 많을 때 속도나 메모리 측면에서 훨씬 좋은 성능을 낼 수 있다.
     */


}