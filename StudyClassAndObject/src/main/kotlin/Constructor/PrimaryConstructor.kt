package Constructor

// 주 생성자란?
// 클래스 이름과 함께 생성자 정의를 이용할 수 있는 기법
// 주 생성자는 클래스 이름과 블록 시작 부분 사이에 선언!

// 주 생성자 선언
class Bird3 constructor(_name: String, _wing: Int, _beak: String, _color: String) {
    // 1. 프로퍼티 - 선언만 함
    var name: String = _name
    var wing: Int = _wing
    var beak: String = _beak
    var color: String = _color

    // 메서드
    fun fly() = println("Fly wing : $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

/**
 주 생성자의 선언은 클래스 이름 오른쪽에 constructor 키워드로 시작
 주 생성자의 키워드는 다음과 같이 생략이 가능하다.
 class Bird(_name: String, _wing: Int, _beak: String, _color: String) {}

 키워드를 생략해서 코드가 훨씬 보기 좋은 상태가 되었다.
 하지만 가시성 지시자나 애노테이션 포기가 클래스 선언에 있다면 constructor를 생략할 수 없다.
 */

//-------------------------------------------------------------------------------
/**
 프로퍼티를 포한한 주 생성자

 내부의 프로퍼티를 생략하고 생성자의 매개변수에 프로퍼티 표현을 함께 넣어 보겠다.
 val, var를 사용하여 매개변수를 선언하면
 생성자에서 this 키워드를 사용하거나 매개변수 이름에 언더스코어를 붙인 다음 생성자에서 인자를 할당할 필요가 없다.

 class Bird(val name: String, val wing: Int, val beak: String, var color: String) {
 ...    // constructor 생략

 예제를 보자.
 */

class Bird4(var name: String, var wing: Int, var beak: String, var color: String) {
    // 프로퍼티는 매개변수 안에 var를 사용해 프로퍼티로서 선언되어 본문에서 생략됨

    // 메서드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird4("myBird", 2, "short", "blue")

    coco.color = "yellow"
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)

    main2()
    main3()
}

//-------------------------------------------------------------------------------
/**
 초기화 블록을 가진 주 생성자
 객체를 생성할 때 변수 초기화 이외에 코드를 실행할 수는 없을까?

 생성자는 기본적으로 함수를 표현하는 기능이기 때문에 변수를 초기화하는 것 말고도
 특정한 작업을 하도록 코드를 작성할 수 있다.
 단, 클래스 이름 다음에 주 생성자를 표현하는 경우 클래스 블록({})안에 코드를 넣을 수 없다.

 따라서 초기화에 꼭 사용해야 할 코드가 있다면 init {...} 초기화 블록을 클래스 선언부에 넣어 주어야한다.

 예제를 보자.
 */

class Bird5(var name: String, var wing: Int, var beak: String, var color: String) {
    // 1. 초기화 블록
    init {
        println("--------- 초기화 블록 시작 ----------")
        println("이름은 $name, 부리는 $beak")
        this.sing(3)
        println("--------- 초기화 블록 끝  -----------")
    }

    // 메서드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main2() {
    val coco = Bird5("myBird", 2, "short", "blue")  // 2. 객체 생성과 함께 초기화 블록 수행

    coco.color = "yellow"
    println("coco.color: ${coco.color}")
    coco.fly()

    // init 초기화 블록에서는 출력문이나 프러퍼티, 메서드 등과 같은 코드를 사용할 수 있다.
    // 그리고 객체 생성과 함께 같이 실행된다.
}

//-------------------------------------------------------------------------------
// 프로퍼티의 기본값 지정
// 생성자의 매개변수에 기본값을 사용할 수 있다.
// 그러면 객체를 생성할 때 기본값이 있는 인자는 생략할 수 있다.

// 프로퍼티의 기본값 지정
class Bird6(var name: String = "NONAME", var wing: Int = 2, var beak: String, var color: String) {
    // ...
}

fun main3() {
    val coco = Bird6(beak = "long", color = "red")  // 기본값이 있는 것은 생략하고 없는 것만 전달 가능

    println("coco.name: ${coco.name}, coco.wing ${coco.wing}")
    println("coco.color: ${coco.color}, coco.beak ${coco.beak}")
}


