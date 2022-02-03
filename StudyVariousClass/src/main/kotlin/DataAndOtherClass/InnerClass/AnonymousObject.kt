package DataAndOtherClass.InnerClass

/**
 * 익명 객체
 *
 * 자바에서는 익명 이너 클래스라는 것을 제공해 일회성으로 객체를 생성해 사용한다.
 * 코틀린에서는 object 키웓를 사용하는 익명 객체로 이와 같은 기능을 수행한다.
 * 자바와 다른점은 익명 객체 기법으로 다중의 인터페이스를 구현할 수 있다는 것이다.
 */

interface Switcher { // 1 인터페이스의 선언
    fun on(): String
}

class Smartphone3(val model: String) {
    fun powerOn(): String {
        class Led(val color: String) {
            fun blink(): String = "Blink $color on $model"
        }
        val powerStatus = Led("Red")
        val powerSwitch = object : Switcher { // 2 익명 객체를 사용해 Switcher의 on()을 구현
            override fun on(): String {
                return powerStatus.blink()
            }
        } // 익명(object) 객체 블록의 끝
        return powerSwitch.on() // 익명 객체의 메서드 사용
    }
}