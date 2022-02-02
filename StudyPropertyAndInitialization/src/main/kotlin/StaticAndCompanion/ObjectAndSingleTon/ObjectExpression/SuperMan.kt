package StaticAndCompanion.ObjectAndSingleTon.ObjectExpression

/**
 * object 표현식
 *
 * object 표현식은 object 선언과 달리 이름이 없으며 싱글톤이 아니다.
 * 따라서 object 표현식이 사용될 때마다 새로운 인스턴스가 생성된다.
 * 결과적으로 이름이 없는 익명 내부 클래스로 불리는 형태를 object 표현식으로 만들 수 있다.
 *
 * object 표현식을 이용해 하위 클래스를 만들지 않고도 클래스의 특정 메서드를 오버라이딩해보자.
 */

open class SuperMan() {
    fun work() = println("Taking photos")
    fun talk() = println("Talking with people")
    open fun fly() = println("Flying in the air")
}

fun main() {
    val pretendedMan = object: SuperMan() { // 1 object 표현식으로 fly() 구현의 재정의
        override fun fly() = println("I'm not a real superman. I can't fly!")
    }

    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}