package generic.variance

/**
 * 공변성에 따른 자료형 제한하기
 */

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

// 1. 형식 매개변수를 Animal로 제한
class Box<out T: Animal>(val element: T) {  // 주 생성자에서는 val만 허용
    fun getAnimal(): T = element    // 2. out은 반환 자료형에만 사용할 수 있음
//    fun set(new: T) {   // 3. 오류! T는 in 위치에 사용할 수 없음
//        element = new
//    }
}

fun main() {
    // 일반적인 객체 선언
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1 // 클래스의 상위 자료형으로 변환하는 것은 아무런 문제 없음
    a1 = s1 // 4. a1은 Spider의 객체가 됨
    println("a1.size = ${a1.size}")

    var c2: Box<Animal> = Box<Cat>(Cat(10)) // 5. 공변성 - Cat은 Animal의 하위 자료형
    println("c2.element.size = ${c2.element.size}")

    // val c3: Box<Cat> = Box<Animal>(10)   // 6. 오류! 반대의 경우는 인스턴스화되지 않음
    // val c4: Box<Any> = Box<Int>(10)  // 7. 오류! 자료형을 제한하여 Animal과 하위 클래스 이외에는 사용할 수 없음.
}

/**
 * 상.하위 관계에 있는 클래스를 다이어그램으로 그리면 아래와 같다.
 *
 *              Animal
 *                ^
 *     -----------|-------------
 *   Cat                    Spider
 *
 * out을 사용하는 경우에 형식 매개변수를 갖는 프로퍼티는 var로 지정될 수 없고 val만 허용한다.
 * 만일 var를 사용하려면 다음과 같이 private으로 지정해야 한다.
 *
 * class Box<out T: Animal>(private var elem: T)
 *
 * 주 생성자의 경우는 위치를 제한할 필요가 없기 때문에 in과 out은 모두 사용할 수 있다.
 * 단, 생성자에서 var, val로 지정하는 경우에는 게터/세터가 같이 생성되기 때문에 in을 쓸지
 * out을 쓸지 클래스의 상하 관계를 따져 봐야 한다.
 * 여기서는 val만 허용하고 있다.
 * 반공변성을 제공해 6번 같은 경우를 허용하려면 다음과 같이 out을 in으로 바꿔야 한다.
 *
 * ...
 * class Box<in T: Animal>(val size: Int)
 * ...
 * class c3: Box<Cat> = Box<Animal>(10) // 반대로 지정됨
 *
 * 그러면 하위 자료형인 Box<Cat>이 상위 자료형인 Box<Animal>로 할당할 수 있게 된다.
 */

