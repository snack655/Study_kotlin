package AbstractAndInterface.coffeeMachine

class MyDripCoffeeModule : CoffeeModule {
    companion object {
        val electricHeater: ElectricHeater by lazy { // lazy를 이용한 늦은 초기화
            ElectricHeater()
        }
    }

    private val _thermosiphon : Thermosiphon by lazy {
        // 임시적인 private 프로퍼티
        Thermosiphon(electricHeater)
    }

    // 오직 이 메서드에서만 Thermosiphon을 초기화
    override fun getThermosiphon(): Thermosiphon = _thermosiphon
}

/**
 * MyDripCoffeeModule 클래스에서는 by lazy를 사용해 전기 히터 ElectricHeater와 Thermosiphon이
 * 접근되는 시접에 초기화하도록 하고 있다.
 * 여기서 누여겨볼 부분은 Thermosiphon으로 초기화하기 위해 임시 프로퍼티인 _thermosiphon을 사용해 private으로 선언한 부분이다.
 * 이것은 외부에서 초기화하지 못하고 오직 클래스 내부의 getThermosiphon()에 의해서만 초기화되도록 한 것이다.
 */