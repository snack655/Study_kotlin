package InheritanceAndPolymorphism

/**
 * 다형성
 *
 * 상위 클래스의 메서드나 프로퍼티를 상속할 때 하위 클래스에서 똑같은 이름의 메서드나 프로퍼티를 지정한다면?
 *
 * 클래스를 상속하다 보면 때로는 같은 이름이지만 매개변수를 다르게 하거나
 * 아예 기능 구현부를 다르게 작성할 필요가 생길 수 있다.
 *
 * 이름이 동일하지만 매개변수가 서로 다른 형태를 취하거나 샐행 결과를 다르게 가질 수 있는 것을 다형성(Polymorphism)이라고 한다.
 *
 * 동작은 동일하지만 인자만 달라지는 것은 오버로딩(Overloading)이라고 부른다.
 * 상위와 하위 클래스에서 메서드나 프로퍼티의 이름은 같지만 기존의 동작을 다른 동작으로 재정의하는 것을 오버라이딩(Overriding)이라고 부른다.
 *
 * -----------------------------------------------------------------------------------------------------------
 * 오버로딩
 * 오버로딩은 동일한 클래스 안에서 같은 메서드가 매개변수만 달리해서 달리해서 여러 변 정의될 수 있는 개념,
 * 반환값은 동일하거나 달라질 수 있다.
 * 구현되는 동작은 대부분 동일하다.
 *
 * 간단하게 더하는 예시를 보자면
 * fun add(x: Int, y: Int): Int { // 정수형 매개변수 2개를 더함
 *      return x + y
 * }
 *
 * fun add(x: Double, y: Double): Double { // 실수형 매개변수 2개를 더함
 *      return x + y
 * }
 *
 * fun add(x: Int, y: Int, z: Int): Int { // 정수형 매개변수 3개를 더함
 *      return x + y + z
 * }
 *
 * 클래스의 메서드뿐만 아니라 일반 함수도 오버로딩이 가능하다.
 */

fun main() {
    val calc = Calc()
    println(calc.add(3, 2))
    println(calc.add(3.2, 1.3))
    println(calc.add(3, 3, 2))
    println(calc.add("Hello", "World"))

    overriding()
}

class Calc {
    // 다양한 매개변수로 오버로딩된 메서드
    fun add(x: Int, y: Int): Int = x + y
    fun add(x: Double, y: Double): Double = x + y
    fun add(x: Int, y: Int, z: Int): Int = x + y + z
    fun add(x: String, y: String): String = x + y
}

/**
 * 오버라이딩
 *
 * 오버라이드(Override)란?
 * 사전적 의미로 '(기존의 작업을) 중단하다', '뒤엎다' 등으로 해석된다.
 * 하위 클래스에서 새로 만ㄷ르어지는 메서드가 이름이나 매개변수, 반환값이 이전 메서드와 똑같지만 새로 작성되는 것!
 * 간단하게 '재정의한다'라고도 표현할 수 있다.
 *
 * 코틀린에서는 기반 클래스의 내용을 파생 클래스가 오버라이딩하기 위해 기반 클래스에서는 open 키워드,
 * 파생 클래스에서는 override 키워드를 각각 사용한다.
 *
 * 코틀린에서는 프로퍼티도 오버라이딩(재정의)할 수 있다.
 * 먼저 메서드를 오버라이딩하는 예제를 간단하게 보자.
 *
 * open class Bird { // open은 상속 가능을 나타냄
 * ...
 *      fun fly() { ... }   // 1. 최종 메서드로 오버라이딩 불가
 *      open fun sing() { ... }     // 2. sing() 메서드는 하위 클래스에서 오버라이딩 가능
 * }
 *
 * class Lark() : Bird() { // 하위 클래스
 *      fun fly() { /* 재정의 */ } // 오류! 상위 메서드에 open 키워드가 없어 오버라이딩 불가
 *      override fun sing() { /* 구현부를 새롭게 재정의 */ } // 3. 구현부를 새롭게 작성
 * }
 *
 * 오버라이딩을 막고자 한다면 어떻게 해야할까?
 * override 키워드 앞에 final 키워드를 사용해 하위 클래스에서 재정의 되는 것을 막을 수 있다.
 * open class Lark() : Bird() {
 *      final override fun sing() { /* 구현부를 새롭게 재정의 */ } // 하위 클래스에서 재정의를 막음
 * }
 */

// 상속 가능한 클래슬 위해 open 사용
open class Bird2(var name: String, var wing: Int, var beak: String, var color: String) {
    // 메서드
    fun fly() = println("Fly wing: $wing")
    open fun sing(vol: Int) = println("Sing vol: $vol") // 오버라이딩 가능한 메서드
}

class Parrot2(
    name: String,
    wing: Int = 2,
    beak: String,
    color: String,  // 마지막 인자만 var로 선언되어 프로퍼티가 추가되었음을 알 수 있음
    var language: String = "natural"
) : Bird2(name, wing, beak, color) {

    fun speak() = println("Speak! $language")   // Parrot에 추가된 메서드
    override fun sing(vol: Int) {   // 오버라이딩된 메서드
        println("I'm a parrot! The volume level is $vol")
        speak() // 달라진 내용
    }
}

fun overriding() {
    var parrot2 = Parrot2(name = "myParrot", beak = "short", color = "multiple")
    parrot2.language = "English"

    println("Parrot: ${parrot2.name}, ${parrot2.wing}, ${parrot2.beak}, ${parrot2.color}, ${parrot2.language}")
    parrot2.sing(5) // 달라진 메서드 실행 가능
}