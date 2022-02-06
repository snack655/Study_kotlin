package generic.usingGeneric

/**
 * 제네릭과 람다식
 *
 * 형식 매개변수로 선언된 함수의 매개변수를 연산할 경우에는 자료형을 결정할 수 없기 때문에 오류가 난다.
 */

fun <T> add(a: T, b: T): T {
    // return a + b    // 오류! 자료형을 아직 결정할 수 없음
    return a
}

/**
 * 여기서 람다식을 매개변수로 받으면 자료형을 결정하지 않아도 실행 시 람다식 본문을 넘겨 줄 때 결정되므로
 * 이런 문제를 손 쉽게 해결할 수 있다.
 */

fun <T> add(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main() {
    val result = add(2, 3) { a, b -> a + b }
    println(result)

    /**
     * 람다식 {a, b -> a + b}은 add() 함수가 실행될 때 넘겨지는 인자이므로 연산식을 함수 선언부에 직접
     * 구현하지 않고 전달하는 방법을 사용한다.
     * 따라서 함수의 형식 매개변수의 자료형을 특정하지 않아도 실행이 가능하다.
     *
     * 좀 더 일기 좋게 하기 위해 다음과 같이 람다식만 변수로 따로 정의해 add() 함수의 인자로 넣어도 좋다.
     */

    var sumInt: (Int, Int) -> Int = {a, b -> a + b}
    var sumInt2 = {a: Int, b: Int -> a + b} // 변수 선언부가 생략된 경우에는 표현식에 자료형 ㅂ=표기
    println(add(2, 3, sumInt))
    println(add(2, 3, sumInt2))

    /**
     * 함수의 람다식 매개변수를 좀 더 읽기 좋게 단순화하기 위해서는 typealias를 사용해 다른 이름을 줄 수 있다.
     */
}
typealias arithmetic<T> = (T, T) -> T

fun <T> addAux(a: T, b: T, op: arithmetic<T>): T {
    return op(a, b)
}

