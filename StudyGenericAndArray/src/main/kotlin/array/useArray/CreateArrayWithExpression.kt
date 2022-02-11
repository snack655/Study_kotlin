package array.useArray

import java.util.*

/**
 * 표현식을 통해 배열 생성하기
 *
 * Array() 생성자에 표현식을 사용해 배열을 생성 해보자.
 * val|var 변수 이름 = Array(요소 개수, 초깃값)
 *
 * Array() 생성자의 첫 번째 인자는 요소 개수,
 * 두 번째 인자는 초깃값이다.
 * 람다식 초깃값은 init: (Int) -> T와 같이 정의되어 있다.
 * 다음과 같이 활용하자.
 */

fun main() {
    val arr3 = Array(5) { i -> i * 2 }
    println("arr3: ${Arrays.toString(arr3)}")

    /**
     * 표현식 {i -> i * 2}에 의해 5개의 요소를 가지는 배열이 만들어진다.
     *
     * 만일 요소 개수가 많은 배열을 생성하려면 다음과 같이 arrayOfNulls를 사용하거나 표현식을 사용하면 된다.
     */

    var a = arrayOfNulls<Int>(1000) // 1000개의 null로 채워진 정수 배열
    var a2 = Array(1000) { 0 }  // 0으로 채워진 배열

    /**
     * null과 0은 엄연히 다르니 주의하자.
     *
     * 특정 클래스 객체로 배열을 만들려면 다양한 람다식 표현법으로 필요한 요소를 생성할 수 있다.
     */
    var a3 = Array(1000) { i -> myClass(i) }

}

class myClass(val i: Int)
