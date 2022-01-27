package Encapsulation

/**
 * 가시성 지시자와 클래스의 관계
 *
 * 가시성 지시자는 클래스 간의 관계에서도 접근 범위를 정할 수 있기에
 * 상속된 하위 클래스에서 가시성 지시자를 사용하거나 다른 클래스와의
 * 연관 관계를 지정하기 위해서도 사용할 수 있다.
 */

open class Base {
    // 이 클래스에서는 a, b, c, d, e 접근 가능
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4   // 가시성 지시자 기본값은 public

    protected class Nested {
        // 이 클래스에서는 a, b, c, d, e, f 접근 가능
        public val e: Int = 5   // public 생략 가능
        private val f: Int = 6
    }
}

class Derived : Base() {
    // 이 클래스에서는 b, c, d, e 접근 가능
    // a는 접근 불가
    override val b = 5  // Base의 b는 오버라이딩됨 - 상위와 같은 protected 지시자
}

class Other(base: Base) {
    // base.a, base.b는 접근 물가
    // base.c와 base.d는 접근 가능(같은 모듈 안에 있으므로)
    // Base.Nested는 접근 불가, Nested::e 역시 접근 불가
} 