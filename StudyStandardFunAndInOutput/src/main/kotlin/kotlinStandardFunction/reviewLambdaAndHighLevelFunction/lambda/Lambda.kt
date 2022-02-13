package kotlinStandardFunction.reviewLambdaAndHighLevelFunction.lambda

/**
 * 람다식과 고차 함수 복습하기
 *
 * 람다식
 *
 * 람다식은 항상 중괄호로 묶어 있으며
 * 중괄호 안에 매개변수는 화살표(->) 왼쪽에 배치되고 오른쪽에는
 * 그에 따른 식을 구성한다.
 *
 * val 변수 이름: 자료형 선언 = { 매개변수[,...] -> 람다식 본문 }
 */

fun main() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val mul = { x: Int, y: Int -> x * y }

    /**
     * 매개변수가 1개인 경우, 매개변수를 생략하고 it으로 표기할 수 있다.
     */
    val add: (Int) -> Int = { it + 1 }

    /**
     * 만일 추론된 반환 자료형이 Unit이 아닌 경우에는 본문의 마지막 표현식이 반환값으로 처리된다.
     */
    val isPositive: (Int) -> Boolean = {
        val isPositive = it > 0
        isPositive  // 마지막 표현식이 반환됨
    }

    val isPositiveLabel: (Int) -> Boolean = number@ {
        val isPositive = it > 0
        return@number isPositive    // 라벨을 사용해 반환됨
    }
}