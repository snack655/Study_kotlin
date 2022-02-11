package array.arraySort

/**
 * sortBy()로 데이터 클래스 정렬하기
 *
 * 데이터 클래스의 멤버에 따라 정렬하자.
 * Array에서 확장된 sortBy() 함수를 이용하면 해당 멤버 변수에 따라 정렬할 수 있다.
 */

data class Product(val name: String, val price: Double)

fun main() {
    val products = arrayOf(
        Product("Snow Ball", 870.00),
        Product("Smart Phone", 999.00),
        Product("Drone", 240.00),
        Product("Mouse", 333.55),
        Product("Keyboard", 125.99),
        Product("Monitor", 1500.99),
        Product("Tablet", 512.99))


    products.sortBy { it.price }    // 값에 따라 정렬
    products.forEach { println(it) }
}