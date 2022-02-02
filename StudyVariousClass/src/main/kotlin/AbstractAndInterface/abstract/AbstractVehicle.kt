package AbstractAndInterface.abstract

/**
 * 추상 클래스
 *
 * 추상 클래스는 abstract라는 키워드와 함께 선언하며
 * 추상 클래스로부터 일반적인 객체를 생성하는 방법으로 인스턴스화 될 수 없다.
 * 다만 추상 클래스를 상속하는 하위 클래스가 어떻게 만들어야 하는지를 나타내는 용도로 사용된다.
 *
 * 추상 클래스의 정의와 구현
 *
 * 추상 클래스를 정의하려면 다음과 같이 클래스 앞에 abstract 키워드를 사용한다.
 * abstract class Vehicle
 *
 * 추상 클래스를 설계할 때는 멤버인 프로퍼티나 메서드도 abstract로 선언될 수 있다.
 * 이때는 추상 프로퍼티나 추상 메서드라고 부른다.
 * 물론 기본적인 프로퍼티나 메서드의 선언은 abstract가 아니므로 특정 초기화나 구현이 필요하지만
 * abstract로 선언된 프로퍼티나 메서드는 아직 미완성되었다는 의미를 줄 수 있다.
 * 만일 클래스에서 추상 프로퍼티나 메서드가 하나라도 있다면 해당 클래스는 추상 클래스가 되어야 한다.
 * 그러면 이동 수단을 위한 추상 클래스로 Vehicle 클래스를 정의해 보자.
 */

// 추상 클래스, 주 생성자에는 비추상 프로퍼티 선언의 매개변수 3개가 있음
abstract class Vehicle(val name: String, val color: String, val weight: Double) {

    // 추상 프로퍼티(반드시 하위 클래스에서 재정의해 초기화해야 함)
    abstract var maxSpeed: Double

    // 일반 프로퍼티(초깃값인 상태를 저장할 수 있음)
    var year = "2018"

    // 추상 메서드(반드시 하위 클래스에서 구현해야 함)
    abstract fun start()
    abstract fun stop()

    // 일반 메서드
    fun displaySpecs() {
        println("Name: $name, Color: $color, Weight: $weight, Year: $year, Max Speed: $maxSpeed")
    }
}

/**
 * Vehicle 클래스는 객체를 생성할 수 없고 탈것에 대한 기본 설계 역할을 한다.
 * 주 생성자의 매개변수에 val이 사용되었으므로 프로퍼티가 된다.
 * 3개의 프로퍼티 name, color, weight는 abstract가 없는 일반 프로퍼티로 선언되었다.
 * 또 year는 일반 프로퍼티로 초깃값으로 "2018"을 가지고 있다.
 *
 * abstract 키워드로 선언된 최대 속도를 나타내는 maxSpeed 프로퍼티, 운행과 중단을 나타내는 start(), stop()
 * 메서드는 특정 구현 내용이 없는 추상 멤버이기 때문에 하위 클래스에서 재정의하거나 구현해야 한다.
 * 반면에 year 프로퍼티나 displaySpecs() 메서드는 하위 클래스에서 재정의할 필요가 없다.
 *
 * 추상 클래스에서는 상속을 위해 open 키워드를 사용할 필요가 없다.
 * 마찬가지로 추상 프로퍼티나 메서드에도 open이 필요없다.
 * 추상 클래스에서는 abstract 키워드 자체가 상속과 오버라이딩을 허용하기 때문이다.
 * 하지만 일반 프로퍼티나 메서드를 오버라이딩하려면 open 키워드가 필요하다.
 * 다음 내용을 보자.
 */

class Car(
    name: String,
    color: String,
    weight: Double,
    override var maxSpeed: Double   // maxSpeed는 오버라이딩 함
): Vehicle(name, color, weight) {

    override fun start() {
        // 코드의 구현
        println("Car started")
    }

    override fun stop() {
        // 코드의 구현
        println("Car Stopped")
    }
}

class Motorcycle(
    name: String,
    color: String,
    weight: Double,
    override var maxSpeed: Double
): Vehicle(name, color, weight) {

    override fun start() {
        // 코드의 구현
        println("Bike Started")
    }

    override fun stop() {
        // 코드의 구현
        println("Bike Stopped")
    }
}

fun main() {
    val car = Car("SuperMatiz", "yello", 1110.0, 270.0)
    val motor = Motorcycle("DreamBike", "red", 173.0, 100.0)

    car.year = "2013"
    car.displaySpecs()
    car.start()
    motor.displaySpecs()
    motor.start()
}

/**
 * displaySpecs()는 기존에 추상 클래스가 가지고 있던 일반 메서드이다.
 * 각 객체의 start()와 stop()은 추상 메서드로부터 오버라이딩되어 하위 클래스에서 구현된 메서드이다.
 *
 * 추상 클래스는 abstract 키워드를 사용해 하위 클래스에서 반드시 갖춰야 하는 프로퍼티와 메서드를 제시한다.
 * 추상 클래스에는 일반 프로퍼티나 메서드도 만들 수 있기 때문에 공통의 프로퍼티와 메서드를 미리 만들어 둘 수 있다.
 * 보통 연관성이 높은 클래스의 기능이나 속성을 미리 정의해 둔다.
 */