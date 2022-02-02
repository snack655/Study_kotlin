package AbstractAndInterface.abstract

/**
 * 만일 추상 클래스로부터 하위 클래스를 생성하지 않고 단일 인스턴스로 객체를
 * 생성하려면 object를 사용해서 지정할 수 있다.
 * 다음의 예를 보자.
 */

// 추상 클래스의 선언
abstract class Printer {
    abstract fun print() // 추상 메서드
}

val myPrinter = object: Printer() { // 객체 인스턴스
    override fun print() {
        // 추상 메서드의 구현
        println("출력합니다.")
    }
}

fun main() {
    myPrinter.print()
}

/**
 * 추상 메서드 하나를 가지는 클래스인 Printer는 객체 인스턴스를 지정하기 위해 익명 객체를 지정하는 object 키워드를 사용!
 * 이때는 콜론(:) 오른쪽에 생성자 이름을 사용하고 블록에서 관련 메서드를 오버라이딩해 구현해 두어야 한다.
 */