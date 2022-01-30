package ApproachProperty.UseGetterSetter

/**
 * 프로퍼티는 기본적으로 오버라이딩할 수 없는 final 형태로 선언된다.
 * 만일 프로퍼티를 오버라이딩 가능하게 하려면 open 키워드를 사용해 프로퍼티를 선언해야 한다.
 */

open class First {
    open val x: Int = 0     // 1 오버라이딩 가능
        get() {
            println("First x")
            return field
        }
    val y: Int = 0  // 2 open 키워드가 없으면 final 프로퍼티
}

class Second: First() {
    override val x: Int = 0
        get() {
            println("Second x")
            return field + 3
        }
    // override val y: Int = 0  // 4 오류! 오버라이딩 불가
}

fun main() {
    val second = Second()
    println(second.x)   // 5. 오버라이딩된 두 번째 클래스 객체의 x
    println(second.y)   // 상위 클래스로부터 상속받은 값
}

/**
 * open으로 정의되어 있으므로 하위 클래스인 Second에서 오버라이딩할 수 있다.
 * 오버라이딩 시 상위 클래스에 프로퍼티를 val로 정의한 경우에는 하위 클래스에서 var로 변경할 수 있다.
 * 반대로 var를 val로 변경할 수는 없다.
 */

