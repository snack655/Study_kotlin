package array.arraySort

/**
 * sortWith() 비교자로 정렬하기
 *
 * 이번에는 주어진 비교자(Comparator)에 의해 정렬하는 방법을 알아보자.
 * sortWith()는 다음과 같이 작성된 Array에 확장된 제네릭 메서드이다.
 *
 * public expect fun <T> Array<out T>.sortWith(comparator: Comparator<in T>): Unit
 *
 * sortWith()는 Comparator를 매개변수로 가지고 있다.
 * 이 방식을 이용해 앞의 예제를 새롭게 작성해 보자.
 */


fun main() {
    val products2 = arrayOf(
        Product("Snow Ball", 870.00),
        Product("Smart Phone", 999.00),
        Product("Drone", 240.00),
        Product("Mouse", 333.55),
        Product("Keyboard", 125.99),
        Product("Monitor", 1500.99),
        Product("Tablet", 512.99))

    products2.sortWith( // Comparator를 이용해 두 객체를 비교하여 p1이 크면 1, 같으면 0, 작으면 -1
        Comparator<Product> { p1, p2 ->
            when {
                p1.price > p2.price -> 1
                p1.price == p2.price -> 0
                else -> -1
            }
        }
    )
    products2.forEach { println(it) }

    products2.sortWith(compareBy({it.name}, {it.price}))
    products2.forEach { println(it) }
}
