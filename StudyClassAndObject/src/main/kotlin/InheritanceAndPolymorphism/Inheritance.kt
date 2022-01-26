package InheritanceAndPolymorphism

/**
 * Bird 클래스만으로는 특별한 새를 나타내기에 너무 모호할 때는 하위에 새로운 분류를 넣을 수 있다.
 * 예를 들어 '앵무새'라는 새로운 분류(클래스)를 만들 수 있다.
 * 기반 클래스는 Bird 클래스이므로 파생 클래스로서 앵무새를 나타내는 Parrot 클래스를 새롭게 정의하면
 * 기반 클래스인 Bird의 프로퍼티와 메서드를 Parrot 클래스에 상속할 수 있다.
 *
 * 코틀린 모든 클래스는 Any 클래스의 하위 클래스!
 *
 * Bird 클래스가 상속할 수 있는 상태가 되려면 open이라는 키워드가 함께 선언!
 */


// 하위 클래스 선언하기
// 예제를 발전시켜 Bird 클래스에서 파생된 하위 클래스인 Lark와 Parrot 클래스를 선언하자.
// 먼저 상속을 위한 기본 구조는 다음과 같다.

/**
 * open class 기반 클래스 이름 {   // 묵시적으로 Any로부터 상속됨, open으로 파생가능
 *  ...
 * }
 *
 * class 파생 클래스 이름 : 기반 클래스 이름() {  // 기반 클래스로부터 상속됨, 최종 클래스로 파생 불가
 *  ...
 * }
 *
 * 코틀린의 모든 클래스는 묵시적으로 Any로부터 상속
 *
 * val someVal: Int // 일반 변수의 선언
 * open class BaseClass(someArgs: Int)  // 상속 가능한 클래스
 * class SomeClass(someArgs: Int) : BaseClass(someArgs) // 클래스 상속의 선언
 * class SomeClass : BaseClass { ..constructor().. }    // 부 생성자를 사용할 때 클래스 상속 선언
 */

// 1. 상속 가능한 클래스를 선언하기 위해 open 선언
open class Bird(var name: String, var wing: Int, var beak: String, var color: String) {
    // 메서드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

// 2. 주 생성자를 사용하는 상속
class Lark(name: String, wing: Int, beak: String, color: String) : Bird(name, wing, beak, color) {
    fun singHitone() = println("Happy Song!")   // 새로 추가한 메서드
}

// 3. 부 생성자를 사용하는 상속
class Parrot : Bird {
    val language: String

    constructor(
        name: String,
        wing: Int,
        beak: String,
        color: String,
        language: String
    ) : super(name, wing, beak, color) {
        this.language = language    // 새로 추가한 프로퍼티
    }

    fun speak() = println("Speak! $language")
}

fun main() {
    val coco = Bird("myBird", 2, "short", "blue")
    val lark = Lark("myLark", 2, "long", "brown")
    val parrot = Parrot("myParrot", 2, "short", "multiple", "korean")   // 프로퍼티 추가

    println("Coco: ${coco.name}, ${coco.wing}, ${coco.beak}, ${coco.color}")
    println("Lark: ${lark.name}, ${lark.wing}, ${lark.beak}, ${lark.color}")
    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")

    lark.singHitone()   // 새로 추가한 메서드 사용 가능
    parrot.speak()
    lark.fly()
}

