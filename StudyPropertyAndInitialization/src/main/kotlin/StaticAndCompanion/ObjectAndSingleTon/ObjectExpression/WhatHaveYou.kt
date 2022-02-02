package StaticAndCompanion.ObjectAndSingleTon.ObjectExpression


// 딱 한 번만 구현되는 인터페이스 구현 클래스를 정의하기가 부담스러운 경우에 다음과 같이 사용할 수 있다.
interface Shape {
    fun onDraw()    // 구현해야 할 메서드
}

val triangle = object: Shape {
    override fun onDraw() { // 여기서 딱 한 번 구현됨
        println("triangle")
    }
}

// 객체는 필요하지만 상위 인터페이스나 클래스가 없는 경우는 다음과 같이 사용할 수 있다.
fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

/**
 * 이런 익명 객체는 지역(local)이나 private 정의 영역에서만 자료형으로 사용될 수 있다.
 * 만일 익명 객체를 public 함수의 반환 자료형이나 public 속성의 자료형으로 쓴다면,
 * 이러한 함수나 속성의 실제 자료형은 익명 객체로 선언된 상위 자료형이 되거나 혹은 상위 자료형을 선언하지 않으면 Any형이 된다.
 */

class C {
    // Private function -> 반환 자료형은 익명 객체 자료형이 됨
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function -> 반환 자료형은 Any형이 됨
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x    // 문제 없음
        // val x2 = publicFoo().x  // 오류! Unresolved reference: x
    }
}
/**
 * 자바의 익명 내부 클래스와 같이, object 표현식 안의 코드는
 * 둘러싸여 있는 범위 내부의 변수에 접근할 수 있다.
 */