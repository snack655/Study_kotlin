package SuperAndThis

import InheritanceAndPolymorphism.Bird2

/**
 * super로 상위 객체 참조하기
 *
 * 메서드를 오버라이딩하려고 할 때 만일 상위 클래스에서 구현한 내용을 그대로 사용하고
 * 거기에 필요한 내용만 추가하고 싶을 수도 있다.
 * 이때 상위 클래스를 가리키는 특별한 키워드인 super를 사용한다.
 * super를 사용하면 상위 클래스의 프로퍼티나 메서드, 생성자를 사용할 수 있다.
 *
 * 다음 예제를 보자.
 *
 */

open class Bird(var name: String, var wing: Int, var beak: String, var color: String) {
    // 메서드
    fun fly() = println("Fly wing: $wing")
    open fun sing(vol: Int) = println("Sing vol: $vol") // 오버라이딩 가능한 메서드
}

class Parrot(name: String, wing: Int = 2, beak: String, color: String, var language: String = "natural") : Bird(name, wing, beak, color) {
    fun speak() = println("Speak! $language")

    override fun sing(vol: Int) {   // 1. 상위 클래스의 내용과 다르게 새로 구현된 내용을 가짐
        super.sing(vol) // 상위 클래스의 sing()을 먼저 수행
        println("I'm a parrot! The volume level is $vol")
        speak()
    }
}