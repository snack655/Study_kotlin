package generic.usingGeneric

/**
 * 자료형 변환
 *
 * 일반적으로 상위 클래스와 하위 클래스의 선언 형태에 따라 클래스의 자료형을 변환할 수 있지만
 * 제네릭 클래스는 가변성을 지정하지 않으면 형식 매개변수에 상.하위 클래스가 지정되어도 서로 자료형이 변환되지 않는다.
 */


open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    val obj1: Parent = Child()     // Parent 형식의 obj1은 Child 자료형으로 변환될 수 있다.
//  val obj2: Child = Parent()     // 오류! 자료형 불일치!

//  val obj3: Cup<Parent> = Cup<Child>()    // 오류! 자료형 불일치!
//  val obj4: Cup<Child> = Cup<Parent>()    // 오류! 자료형 불일치!

    val obj5 = Cup<Child>() // obj5는 Cup<Child>의 자료형이 된다.
    val obj6: Cup<Child> = obj5 // 자료형이 일치하므로 OK!
}

/**
 * 제네릭 클래스에서는 형식 매개변수인 T에 상위와 하위 클래스를 지정하더라도 서로 관련이 없는 형식이 되기 때문에
 * obj3과 obj4처럼 형식이 일치하지 않는 오류가 발생하게 된다.
 * obj5는 Cup<Child> 형식이므로 obj6에 문제없이 할당할 수 있다.
 *
 * 이처럼 상.하위 클래스를 형식 매개변수에 지정해 서로의 관계에 따라 변환이 가능하게 하려면
 * 제네릭의 가변성을 주기 위해 in, out에 대해 알아야 한다.
 */