package AbstractAndInterface.coffeeMachine

class Thermosiphon(heater: Heater) : Pump, Heater by heater {   // 위임의 사용
    override fun pump() {
        if (isHot()) {
            println("[Thermosiphon] pumping...")
        }
    }
}

/**
 * Heater by heater 위임을 통해 isHot()을 그대로 사용하고 있다.
 */