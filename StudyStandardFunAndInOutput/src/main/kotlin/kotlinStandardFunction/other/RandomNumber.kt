package kotlinStandardFunction.other

import kotlin.random.Random

/**
 * 난수 생성하기
 *
 * 난수를 생성하려면 자바의 java.util.Random을 사용할 수도 있었지만
 * JVM에만 특화된 난수를 생성하기 때문에 코틀린에서는 멀티 플랫폼에서도 사용 가능한
 * kotlin.random.Random 패키지를 제공한다.
 * 다음 소스 코드의 number는 0부터 21사이의 난수를 제공한다.
 */

fun main() {
    val number = Random.nextInt(21) // 숫자는 난수 발생 범위
    println(number)
}