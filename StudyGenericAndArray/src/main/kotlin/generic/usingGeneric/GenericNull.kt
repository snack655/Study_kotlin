package generic.usingGeneric

/**
 * 형식 매개변수의 null 제어
 *
 * 제네릭의 형식 매개변수는 기본적으로 null 가능한 형태로 선언된다.
 */

class GenericNull<T> {  // 기본적으로 null이 혀용되는 형식 매개변수
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

fun main() {
    val obj = GenericNull<String>() // non-null로 선언됨
    obj.EqualityFunc("Hello", "World")  // null이 혀용되지 않음

    val obj2 = GenericNull<Int?>()  // null이 가능한 형식으로 선언됨
    obj2.EqualityFunc(null, 10) // null 사용
}

/**
 * null을 허용하지 않으려면 어떻게 할까?
 * 형식 매개변수에 다음과 같이 특정 자료형을 지정하면 null을 제한하게 된다.
 */

class GenericNull2<T: Any> {    // 자료형 Any가 지정되어 null을 허용하지 않음
    // ...
}

/**
 * 형식 매개변수는 null이 아닌 Any로 제한하여
 * GenericNull<Int?>와 같이 null을 지정할 수 없게 만들었다.
 */
