package Relationship

/**
 * 구성(Composition) 관계는 집합 관계와 거의 동일하지만 특정 클래스가 어느 한 클래스의 부분이 되는 것!
 * 구성품으로 지정된 클래스는 생명주기가 소유자 클래스에 의존되어 있다.
 * 만일 소유자 클래스가 삭제되면 구성하고 있던 클래스도 같이 삭제된다.
 */

class Car(val name: String, val power: String) {
    private var engine = Engine(power)  // Engine 클래스 객체는 Car에 의존적

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()
}

class Engine(power: String) {
    fun start() = println("Engine has been started.")
    fun stop() = println("Engine has been stopped")
}

fun main() {
    val car = Car("tico", "100hp")
    car.startEngine()
    car.stopEngine()
}

/**
 * Engine 클래스는 Car 클래스의 생명주기에 의존적이다.
 * car 객체를 생성함과 동시에 Engine 클래스의 객체도 생성된다.
 * 집합 관계와 달리 구성 관계에서는 만일 car 객체가 삭제되면 동시에 engine 객체도 삭제된다.
 */