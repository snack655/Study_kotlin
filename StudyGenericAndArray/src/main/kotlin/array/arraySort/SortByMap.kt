package array.arraySort

/**
 * 배열 필터링하기
 *
 * filter() 메서드를 활용하면 원하는 데이터를 골라낼 수 있다.
 */

fun main() {
    // 0보다 큰 수 골라내기
    val arr = arrayOf(1, -2, 3, 4, -5, 0)
    arr.filter { e -> e > 0 }
        .forEach { e -> print("$e ") }  // 1 3 4 출력

    /**
     * filter()로 골라낸 0보다 큰 수에 해당하는 요소를 forEach가 받아 출력한다.
     */

    val fruits = arrayOf("banana", "avocado", "apple", "kiwi")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    /**
     * 배열 객체 변수인 fruits에서 여러 개의 메서드인 .filter(), .sortedBy(), .map(), .forEach()를
     * 계속 연속해서 호출하는 방법을 메서드 체이닝(Method Chaining)이라고 한다.
     * 각 결과를 it으로 넘겨받아 처리할 수 있어 매우 유용하다.
     * 다만 특정 메서드에서 오류가 나면 디버깅하기 어렵다.
     * 초반 메서드에서 오류가 나면 후반 메서드는 작동하지 않기 때문에 이런 경우를 '열차 사고'에 비유하기도 한다.
     *
     * 배열에서 특정 요소가 있는지 확인하는 간단한 방법은 when문을 사용하는 것이다.
     * 조건에 요소 이름, in과 배열 이름을 함께 사용해 해당 배열에 필요한 요소가 있는지를 확인할 수 있다.
     *
     * when {
     *      "apple" in fruits -> println("Apple!")
     *      ...
     * }
     *
     * 앞에서 다룬 클래스 객체 product에서 가장 낮은 가격이나 높은 가격을 골라내려면
     * minBy와 maxBy를 다음과 같이 사용할 수 있다.
     *
     * // 지정된 필드의 가장 작은 값과 큰 값 골라내기
     * println(products.minBy { it.price })
     * println(products.maxBy { it.price })
     */
}

