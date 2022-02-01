package LazyInitialization.by

/**
 * 클래스의 위임
 *
 * 간단한 예를 보자.
 *
 * interface Animal {
 *      fun eat() { ... }
 *      ...
 * }
 * class Cat : Animal { }
 * val cat = Cat()
 * class Robot : Animal by cat  // Animal의 정의된 Cat의 모든 멤버를 Robot에 위임
 *
 * 만약 Animal 인터페이스를 구현하고 있는 Cat 클래스가 있다면 Animal에서 정의하고 있는
 * Cat의 모든 멤버를 Robot 클래스로 위임할 수 있다.
 * 즉, Robot은 Cat이 가지는 모든 Animal의 메소드를 가지는데 이것을 클래스 위임(Class Delegation)이라고 한다.
 *
 * 사실 Cat은 Animal 자료형의 private 멤버로 Robot 클래스 안에 저장되며
 * Cat에서 구현된 모든 Animal의 메서드는 정적 메서드로 생성된다.
 * 따라서 Robot 클래스를 사용할 때 Animal을 명시적으로 참조하지 않고도 eat()을 바로 호출하는 것이 가능하다.
 *
 * 그렇다면 왜 위임을 사용할까?
 * 기본적으로 코틀린이 가지고 있는 표준 라이브러리는 open으로 정의되지 않은 클래스를 사용하고 있는데,
 * 다시 말하면 모두 final 형태의 클래스이므로 상속이나 직접 클래스의 기능 확장이 어렵게 된다.
 * 오히려 어떻게 어렵게 만들어 둠으로써 표준 라이브러리의 무분별한 상속에 따른 복잡한 문제를 방지할 수 있다.
 * 따라서 필요한 경우에만 위임을 통해 상속과 비슷하게 해당 클래스의 모든 기능을 사용하면서
 * 동시에 기능을 추가 확장 구현할 수 있는 것이다.
 */

interface Car {
    fun go(): String
}

class VanImpl(val power: String): Car {
    override fun go() = "은 짐이 적재하며 $power 을 가집니다."
}

class SportImpl(val power: String): Car {
    override fun go(): String = "은 경주용에 사용되며 $power 을 가집니다."
}

class CarModel(val model: String, impl: Car): Car by impl {
    fun carInfo() {
        println("$model ${go()}")   // 1 참조 없이 각 인터페이스 구현 클래스의 go()에 접근
    }
}

fun main() {
    val myDamas = CarModel("Damas 2010", VanImpl("100마력"))
    val my350z = CarModel("350Z 2008", SportImpl("350마력"))

    myDamas.carInfo()   // 2 carInfo에 대한 다형성을 나타냄
    my350z.carInfo()
}