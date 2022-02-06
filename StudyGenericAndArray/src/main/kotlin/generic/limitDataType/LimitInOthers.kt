package generic.limitDataType

/**
 * 다수 조건의 형식 매개변수 제한하기
 *
 * 형식 매개변수의 자료형을 제한할 때 하나가 아닌 여러 개의 조건에 맞춰 제한하고자 할 때가 있다.
 * 에를 들어 클래스를 정의할 때 2개의 특정 인터페이스 구현이 포함된 클래스로 형식 매개변수를 제한하려면 어떻게 할까?
 *
 * 구체적으로 InterfaceA와 InterfaceB를 구현하는 클래스만 허용하려고 할 때는 형식 매개변수의 사용 범위를 지정하는
 * where 키워드를 사용할 수 있다. where를 통해 지정된 제한을 모두 포함하는 겨우만 허용하도록 할 수 있다.
 */

interface InterfaceA
interface InterfaceB

class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceA

class ClassA<T> where T: InterfaceA, T: InterfaceB  // 2개의 인터페이스를 구현하는 클래스로 제한

fun main() {
    val obj1 = ClassA<HandlerA>()   // 객체 생성 가능
    //val obj2 = ClassA<HandlerB>() // 범위에 없으므로 오류 발생!
}

/**
 * 이번에는 함수에서 wehre를 사용해 두 조건을 만족하는 경우로 제한하자.
 */

fun <T> myMax(a: T, b: T): T where T: Number, T: Comparable<T> {
    return if (a > b) a else b
}

/**
 * myMax의 인자, a, b에 들어갈 자료형을 숫자형(Number)과 비교형(Comparable)만으로 한정.
 *
 * 비교형인 Comparable 인터페이스는 특정 객체를 비교하는 클래스의 구현을 위해 사용하는 인터페이스이다.
 */

