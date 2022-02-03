package AbstractAndInterface.`interface`

/**
 * 인터페이스의 선언과 구현
 *
 * 인터페이스는 interface 키워드를 사용해 선언하고 상속한 하위 클래스에서는
 * override를 사용해 해당 메서드를 구현해 주어야 한다.
 *
 * interface 인터페이스 이름[: 인터페이스 이름...] {
 *      추상 프로퍼티 선언
 *      추상 메서드 선언
 *
 *      [일반 메서드 선언 { ... }]
 * }
 *
 * 인터페이스 본문에서 메서드는 추상 혹은 일반 메스드 모두 선언이 가능하지만
 * 프로퍼티는 오직 추상 메서드로만 선언해야 하는 것에 주목한다.
 * 간단한 예제를 보자.
 */

interface Pet {
    var category: String    // abstract 키워드가 없어도 기본은 추상 프로퍼티
    val msgTags: String
        get() = "I'm your lovely pet!"

    var species: String // 종을 위한 프로퍼티

    fun feeding()  // 마찬가지로 추상 메서드
    fun patting() {
        // 일반 메서드: 구현부를 포함하면 일반적인 메서드로 기본이 됨
        println("Keep patting!")
    }
}

/**
 * 위의 소스 코드에서 보는 것처럼 인터페이스에서는 추상 클래스와는 다르게 abstract를 붙여 주지 않아도
 * 기본적으로 추상 프로퍼티와 추상 메서드가 지정된다.
 * 그리고 메서드에는 기본 구현부가 있으며 일반 메서드로서 기본 구현을 가진다.
 * 상태를 저장할 수 없기에 프로퍼티에는 기본값을 가질 수 없다.
 *
 * 이제 이 인터페이스로부터 구현 클래스를 정의해보자.
 * 계속해서 Pet 인터페이스 아래에 다음과 같이 추가하자.
 */

class Cat(name: String, override var category: String) : Pet {
    override var species: String = "cat"    // 프로퍼티를 오버라이딩해 종을 특정
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("kitty","small")
    println("Pet Category: ${obj.category}")
    obj.feeding()   // 구현된 메서드
    obj.patting()   // 기본 메서드
}

/**
 * Cat 클래스는 Pet 인터페이스를 구현한 클래스가 된다.
 * 추상 프로퍼티나 추상 메서드였던 부분을 override 키워드를 사용해 구현해 준다.
 * 인터페이스의 구현은 클래에서 상속을 나타내는 콜론(:)을 동일하게 사용해 구현해 준다.
 * 이제 이 클래스는 인터페이스를 구현하겠다는 것을 나태난다.
 */