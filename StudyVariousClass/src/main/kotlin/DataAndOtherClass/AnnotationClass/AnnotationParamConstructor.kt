package DataAndOtherClass.AnnotationClass

import kotlin.reflect.KClass

/**
 * 애노테이션의 매개변수와 생성자
 *
 * 만일 애노테이션에 매개변수를 지정하고나 하려면 다음과 같이 생성자를 통해 정의한다.
 */

annotation class Special(val why: String)   // 애노테이션 클래스의 정의
@Special("example") class Foo3{}    // 애노테이션에 매겨변수를 지정

/**
 * 매개변수로 사용될 수 있는 자료형은 다음과 같은 것이 있다.
 * - 자바의 기본형과 연동하는 자료형(Int형, Long형 등)
 * - 열거형
 * - 문자열
 * - 기타 애노테이션
 * - 클래스(클래스 이름::class)
 * - 위의 목록을 가지는 배열
 *
 * 애노테이션이 또 다른 애노테이션을 가지고 사용할 때는 @ 기호를 사용하지 않아도 된다.
 */

annotation class ReplaceWith(val expression: String)    // 첫 번째 애노테이션 클래스 정의

annotation class Deprecated(    // 두 번쨰 애노테이션 클래스 정의
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith(""))


// ReplaceWith는 @ 기호가 생략됨
@Deprecated("This function is deprecated, use === instead", ReplaceWith("this === other"))
class testest() {
    //...
}

/**
 * 애노테이션의 인자로 특정 클래스가 필요하면, 코틀린의 KClass를 사용해야 한다.
 * 그러면 코틀린 컴파일러 자동적으로 자바 클래스로 변환할 것이다.
 * 이후에 자바 코드에서도 애노테이션 인자를 사용할 수 있게 된다.
 */

annotation class Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)

@Ann(String::class, Int::class) class MyClass3

/**
 * String::class와 Int::class는 코틀린의 리플렉션 표현이다.
 * KClass<T>를 반환한다.
 */