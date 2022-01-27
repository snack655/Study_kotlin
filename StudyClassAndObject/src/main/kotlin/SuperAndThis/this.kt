package SuperAndThis

/**
 * this로 현재 객체 참조하기
 *
 * 여러 개의 부 생성자에서 참조하기
 * super와 마찬가지로 this를 이용해 프로퍼티, 메서드, 생성자 등을 참조할 수 있다.
 */

open class Person {
    constructor(firstName: String) {
        println("[Person] firstName: $firstName")
    }
    constructor(firstName: String, age: Int) {  // 3
        println("[Person] firstName: $firstName, $age")
    }
}

class Developer: Person {
    constructor(firstName: String): this(firstName, 10) {   // 1
        println("[Developer] $firstName")
    }
    constructor(firstName: String, age: Int): super(firstName, age) {   // 2
        println("[Developer] $firstName, $age")
    }
}

fun main() {
    val sean = Developer("Sean")

    // 상속을 통해서 클래스를 만드는 경우에는 상위 클래스의 생성자가 있다면
    // 반드시 하위 클래스에서 호출해야 한다.

    constructor()
}

//-------------------------------------------------------------------------------
// 주 생성자와 부 생성자 함께 사용하기
// 만일 주 생성자와 부 생성자가 함께 있다면 this를 사용해 주 생성자를 가리킬 수 있다.

class Person2(
    firstName: String,
    out: Unit = println("[Primary Constructor] Parameter")
) { // 2. 주 생성자
    val fName = println("[Property] Person fName: $firstName")  // 3. 프로퍼티 할당

    init {
        println("[init] Person init block") // 4. 초기화 블록
    }

    // 1. 부 생성자
    constructor(firstName: String, age: Int, out: Unit = println("[Secondary Constructor] Parameter")): this(firstName) {
        println("[Secondary Constructor] Body: $firstName, $age")   // 5. 부 생성자 본문
    }
}

fun constructor() {
    val p1 = Person2("Kildong", 30) // 1 -> 2 호출, 3 -> 4 -> 5 실행
    println()
    val p2 = Person2("Dooly")   // 2 호출, 3 -> 4 실행
}

