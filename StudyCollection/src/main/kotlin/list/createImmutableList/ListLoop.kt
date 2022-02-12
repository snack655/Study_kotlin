package list.createImmutableList

/**
 * 컬렉션 반복하기
 *
 * 배열과 마찬가지로 List 같은 컬렉션에서 요소를 순환하기 위해 for문을 사용할 수 있다.
 */

fun main() {
    val fruits = listOf("apple", "banana", "kiwi")
    for (item in fruits) {
        println(item)
    }

    /**
     * 요소의 인덱스를 통해 List에 접근하려면 컬렉션에 .indices 멤버를 추가혀면 된다.
     */

    for (index in fruits.indices) { // 인덱스 지정
        println("fruits[$index] = ${fruits[index]}")
    }

    /**
     * 인덱스로 값을 얻을 땐 나머지 연산자(%)를 사용해
     * index % 2 == 0과 같이 작성하면 인덱스 0번과 짝수 요소만 골라낼 수 있다.
     */

    for (index in fruits.indices) { // 인덱스 지정
        if (index % 2 == 0) println("fruits[$index] = ${fruits[index]}")    // 짝수만 고르기
    }

    /**
     * while문을 사용해 출력하려면 인덱스는 0번부터 시작하므로 멤버 변수인 size보다 하나 작은 횟수만큼 반복해 읽을 수 있다.
     */

    var index = 0
    while (index < fruits.size) {
        println("fruits[$index] = ${fruits[index]}")
        index++
    }
}