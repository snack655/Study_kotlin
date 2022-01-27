package SuperAndThis

/**
 * 인터페이스에서 참조하기
 *
 * 인터페이스(Interface)란?
 * 일종의 구현 약속으로 인터페이스를 참조하는 클래스는 인터페이스가 가지고 있는 내용을 구현해야 하는 가이드를 제시!
 *
 * 따라서 인터페이스 자체로는 객체로 만들 수 없고 항상 인터페이스를 구현하는 클래스에서 생성해야 한다.
 * 여기서는 인터페이스에 접근하는 부분에 대해서만 초점을 맞추자.
 *
 * 코틀린은 자바처럼 한 번에 2개 이상의 클래스를 상속받는 다중 상속이 되지 않는다.
 * 하지만 인터페이스로는 필요한 만큼 다수의 인터페이스를 지정해 구현할 수 있다.
 * 만일에 동일한 이름의 프로퍼티나 메서드가 있다면 앵글 브래킷(<>)을 사용해 접근하려는 클래스나 인터페이스의 이름을 정해준다.
 *
 * 이름을 중복되는 예를 보자!
 */

open class A {
    open fun f() = println("A Class f()")
    fun a() = println("A Class a()")
}

interface B {
    fun f() = println("B Interface f()")    // 인터페이스는 기본적으로 open
    fun b() = println("B interface b()")
}

class C: A(), B {   // 1. 쉼표(,)를 사용해 클래스와 인터페이스를 지정
    // 컴파일되려면 f()가 오버라이딩되어야 함
    override fun f() = println("C Class f()")

    fun test() {
        f() // 2. 현재 클래스의 f()
        b() // 3. 인터페이스 B의 b()
        super<A>.f() // 4. A 클래스의 f()
        super<B>.f() // 5. B 클래스의 f()
    }
}

fun main() {
    val c = C()
    c.test()
}

// f() 처럼 중복된 경우는
// 앵글 브래킷을 사용해 super<A>.f()와 super<B>.f()로 구분 가능하다.