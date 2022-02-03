package DataAndOtherClass.InnerClass

/**
 * 지역 클래스
 *
 * 특정 메서드의 블록이나 init 블록과 같이 블록 범위에서만 유효한 클래스이다.
 * 블록 범위를 벗어나면 더 이상 사용되지 않는다.
 */

class Smartphone2(val model: String) {
    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int) {
        fun getInfo() = "$model : Installed on $cpu with ${size}GB" // 바깥 클래스의 프로퍼티 접근
    }

    fun powerOn(): String {
        class Led(val color: String) {  // 지역 클래스 선언
            fun blink(): String = "Blink $color on $model"  // 외부의 프로퍼티는 접근 가능
        }
        val powerStatus = Led("Red")    // 여기에서 지역 클래스가 사용됨
        return powerStatus.blink()
    }   // powerOn() 블록 끝
}

fun main() {
    val myPhone = Smartphone2("Note9")
    myPhone.ExternalStorage(128)
    println(myPhone.powerOn())
}