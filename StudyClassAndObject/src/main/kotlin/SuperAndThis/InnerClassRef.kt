package SuperAndThis

/**
 * 킄래스를 선언할 때 클래스 안에 다시 클래스를 선언하는 것이 가능하다.
 * 이때 특정 클래스 안에 선언된 클래스를 이너 클래스(Inner Class)라고 한다.
 *
 * 여기서는 이너 클래스에서 바깥 클래스를 참조하는 방법을 알아보자.
 * 만일 이너 클래스에서 바깥 클래스의 상위 클래스를 호출하려면 super 키워드와 함께 @ 기호옆에 바깥 클래스 이름을 작성!
 * 예제와 함께 보자.
 */

open class Base {
    open val x: Int = 1
    open fun f() = println("Base Class f()")
}

class Child : Base() {
    override val x: Int = super.x + 1
    override fun f() = println("Child Class f()")
    inner class Inside {
        fun f() = println("Inside Class f()")
        fun test() {
            f()     // 1. 현재 이너 클래스의 f() 접근
            Child().f()     // 2. 바로 바깥 클래스 f() 접근
            super@Child.f() // 3. Child의 상위 클래스인 Base 클래스의 f() 접근
            println("[Inside] super@Child.x: ${super@Child.x}")
        }
    }
}

fun main() {
    val c1 = Child()
    c1.Inside().test()  // 이너 클래스 Inside의 메서드 test() 실행
}