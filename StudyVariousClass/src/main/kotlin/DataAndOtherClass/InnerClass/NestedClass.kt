package DataAndOtherClass.InnerClass

/**
 * 중첩 클래스
 *
 * 코틀린에서 중첩 클래스는 기본적으로 정적(static) 클래스처럼 다뤄진다.
 * 즉, 중첩 클래스는 객체 생성 없이 접근할 수 있다는 것이다.
 */

class Outer {
    val ov = 5
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello ! $nv" // 외북의 ov에는 접근 불가
    }

    fun outside() {
        val msg = Nested().greeting()   // 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}")    // 중첩 클래스의 프로퍼티 접근
    }
}

fun main() {
    // static처럼 객체 생성 없이 사용
    val output = Outer.Nested().greeting()
    println(output)

    // Outer.outside() // 오류! 외부 클래스의 경우는 객체를 생성해야 함
    val outer = Outer()
    outer.outside()
}

/**
 * 바깥 클래스에 접근할 수 있는 방법은?
 * Outer 클래스가 컴패니언 객체를 가지고 있을 때!
 */

class Outer2 {
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello ! $nv"

        fun accessOuter() { // 컴패니언 객체는 접근할 수 있음
            println(country)
            getSomething()
        }
    }

    companion object {  // 컴패니언 객체는 static처럼 접근 가능
        const val country = "Korea"
        fun getSomething() = println("Get Something...")
    }
}

/**
 * 이것이 가능한 이유는 컴페니언 객체로 지정되어
 * 객체 생성 없이 고정적인 메모리를 가지기 때문이다.
 */