package Constructor

// 부 생성자
// 클래스의 본문에 함수처럼 선언
// 부 생성자를 사용하는 Bird 클래스를 정의

class Bird {
    // 1. 프로퍼티 - 선언만 함
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // 2. 부 생성자 - 매개변수를 통해 초기화할 프로퍼티에 지정
    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name    // 3. this.name은 선언된 현재 클래스의 프로퍼티를 나타냄
        this.wing = wing
        this.beak = beak
        this.color = color
    }

    // 메서드
    fun fly() = println("Fly wing : $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird("myBird", 2, "short", "blue")   // 4. 생성자의 인자로 객체 생성과 동시에 초기화

    coco.color = "yellow"
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)
    /**
     1번에 의해 인자("myBird", 2, "short", "blue")가 부 생성자로 전달
     2번과 같이 부 생성자의 매개변수(name)가
     3번에 나온 프로퍼티의 변수를 초기화.
     실제로는 메모리에 로드된 객체 coco의 멤버 프로퍼티가 초기화되는 것!

     this 키워드를 사용하지 않으려면 프로퍼티와 매개변수를 구분하기 위해 다른 이름을 사용할 수 있다.
     보통 언더스코어(_)를 사용.
     name = _name

     */

    //-----------------------------------------------------------------------------
    // 부 생성자를 여러 개 포함한 클래스 사용하기
    // 코틀린에서는 클래스에 부 생성자를 하나 이상 포함할 수 있다.
    // 이때는 constructor() 함수 형태로 매개변수가 다르게 여러 번 선언할 수 있다.

    /**
     class 클래스 이름 {
        constructor(매개변수[, 매개변수...]) {
            // 코드
        }

         constructor(매개변수[, 매개변수...]) {
            // 코드
         }
        ...
     }

     예제를 보자.(class Bird2 { ... }) 아래 참고

     따라서 객체를 생성할 때 다음과 같이 해당 인자의 개수에 따라 생성자를 다르게 호출할 수 있다.
     */

    val bird1 = Bird2("myBird", 2, "short", "blue")
    val bird2 = Bird2("myBird2", "long")

}

// 주 생성자가 없고 여러 개의 부 생성자를 가진 클래스
class Bird2 {
    // 1. 프로퍼티
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // 첫 번째 부 생성자
    constructor(_name: String, _wing: Int, _beak: String, _color: String) {
        name = _name
        wing = _wing
        beak = _beak
        color = _color
    }

    // 두 번째 부 생성자
    constructor(_name: String, _beak: String) {
        name = _name
        wing = 2
        beak = _beak
        color = "grey"
    }

    // 메서드
    fun fly() = println("Fly wing : $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

