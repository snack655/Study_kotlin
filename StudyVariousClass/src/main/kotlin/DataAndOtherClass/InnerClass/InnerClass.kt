package DataAndOtherClass.InnerClass

/**
 * 이너 클래스
 *
 * 이너(Inner)는 내부라는 뜻이지만 여기서는 특별한 키워드인 inner를 사욯하고 있으므로
 * 이너 클래스라고 부르겠다.
 * 단순히 내부에 작성된 중첩 클래스와는 좀 다른 역할을 한다.
 * 클래스 안에 이너 클래스를 정의할 수 있는데 이때 이너 클래스는 바깥 클래스의 멤버들에 접근할 수 있다.
 * 심지어 private 멤버도 접근이 가능하다.
 */

class Smartphone(val model: String) {
    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int) {
        fun getInfo() = "$model : Installed on $cpu with ${size}GB" // 바깥 클래스의 프로퍼티 접근
    }
}

fun main() {
    val mySDCard = Smartphone("S7").ExternalStorage(32)
    println(mySDCard.getInfo())
}