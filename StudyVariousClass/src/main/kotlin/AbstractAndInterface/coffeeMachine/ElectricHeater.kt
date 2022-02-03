package AbstractAndInterface.coffeeMachine

class ElectricHeater(var heating: Boolean = false) : Heater {
    override fun on() {
        println("[ElectricHeater] heating...")
        heating = true
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean = heating
}

/**
 * 전기 히터를 나타내는 ElectricHeater 클래스는 heating 프로퍼티를 가지고 있으며
 * 기본값은 false이다. 그리고 Heater 클래스의 켜고 끄거나 끓고 있는지 확인하는 메서드를 오버라이딩해 구현했다.
 */