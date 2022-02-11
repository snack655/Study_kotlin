package array.useArray

/**
 * 배열에 여러 가지 자료형 혼합하기
 *
 * 특정 자료형으로 제한하지 않는다면 배열의 요소로 정수, 문자열, Boolean 등 여러 가지 자료형을 혼합할 수 있다.
 * 예를 든다면?
 */

fun main() {
    val mixArr = arrayOf(4, 5, 7, 3, "Chike", false)

    /**
     * mixArr에는 다양한 자료형의 값이 저장되어 있다.
     * 만일 배열에서 특정 자료형을 제한하려면 arrayOf<자료형 이름>()
     * 형태나 자료형 이름 + ArrayOf() 형태의 조합으로 나타낼 수 있다.
     *
     * 이때는 데이터를 혼합해서 사용할 수 없다.
     * 배열을 정수형으로만 제한하는 예를 보자.
     */

    val intOnlyArr1 = arrayOf<Int>(4, 5, 7, 3)
    val intOnlyArr2 = intArrayOf(4, 5, 7, 3)

    /**
     * 자료형 이름 + ArrayOf() 형태의 조합은 자료형에 따라 charArrayOf(), booleanArrayOf(),
     * longArrayOf(), shortArrayOf(), byteArrayOf(), intArrayOf() 등이 있다.
     * 이런 자료형은 내부적으로 기본형의 배열을 생성한다.
     * 예를 들어 intArrayOf() 자료형은 내부적으로 int[]로 변환된다.
     *
     * 만일 부호 없는 정수의 자료형에 대한 배열을 정의하려면 ubyteArrayOf(), ushortArrayOf(),
     * uintArrayOf(), ulongArrayOf()를 사용할 수 있다.
     */
}