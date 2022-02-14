package kotlinStandardFunction.other

/**
 * takeIf() 함수와 takeUnless() 함수의 활용
 *
 * takeIf() 함수는 람다식이 true이면 결과물을 반환하고,
 * takeUnless() 함수는 람다식이 false이면 결과를 반환한다.
 * 선언부를 확인해 보자.
 *
 * public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
 *      = if (predicate(this)) this else null
 *
 * takeIf() 함수의 정의해서 볼 수 있듯이 predicate는 T 객체를 매개변수로서 받아오고,
 * true이면 this를 반환하고 아니면 null을 반환한다.
 * takeUnless() 함수는 !predicate()가 사용되어 false일 때 반환된다.
 *
 */

fun main() {
    data class SomeObject(var status: Boolean, var name: String)
    val someObject = SomeObject(true, "민재")

    // 기존 코드
    if (someObject != null && someObject.status) {
        // ...
    }

    // 개선한 코드
    if (someObject?.status == true) {
        // ...
    }

    // takeIf() 함수를 사용해 개선한 코드
    someObject?.takeIf { it.status }?.apply {
        //...
    }

    /**
     * null 검사와 someObject 객체의 status의 상태를 검사해 true인 경우에
     * apply()를 적용해 doThis()를 호출한다.
     *
     * 다음과 같이 엘비스 연산자(?:)를 함께 사용해 처리할 수도 있다.
     */

    val input = "Kotlin"
    val keyword = "in"

    // 입력 문자열에 키워드가 있으면 인덱스를 반환하는 함수를 takeIf() 람수를 사용하여 구현
    input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")

    // takeUnless() 함수를 사용하여 구현
    input.indexOf(keyword).takeUnless { it < 0 } ?: error("keyword not found")
}