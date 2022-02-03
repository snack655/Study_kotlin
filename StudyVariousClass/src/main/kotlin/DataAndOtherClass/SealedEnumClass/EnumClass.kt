package DataAndOtherClass.SealedEnumClass

/**
 * 열거형 클래스
 *
 * 여러 개의 상수를 선언하고 열거된 값을 존건에 따라 선택할 수 있는 특수한 클래스이다.
 * 열거형 클래스는 실드 클래스처럼 다양한 자료형을 다루지 못한다.
 * 열거형 클래스는 enum 키워드와 함께 선언할 수 있고 다음과 같이 자료형이 동일한 상수를 나열할 수 있다.
 * 구조를 살펴보면
 *
 * enum class 클래스 이름 [(생성자)] {
 *      상수1[(값)], 상수2[(값)], 상수3[(값)], ...
 *      [; 프로퍼티 혹은 메서드]
 * }
 */

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/**
 * 각 상수는 Direction 클래스의 객체로 취급되고 쉼표(,)로 구분한다.
 *
 * 또 다른 예로 다음과 같이 주 생성자를 가지고 값을 최기화할 수 있다.
 */
enum class DayOfWeek(val num: Int) {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7)
}

/**
 * 각 상수의 값은 매개변수를 통해 초기화될 수 있다.
 * 여기서는 num으로 Int형 값을 각각 지정하고 있다.
 * when문을 사용해 각 정숫값에 따른 실행이 가능하고,
 * 이때 쉼표를 사용해 여러 케이스를 표현할 수 있다.
 */

fun main() {
    val day = DayOfWeek.SATURDAY    // SATURDAY의 값 읽기
    when(day.num) {
        1, 2, 3, 4, 5 -> println("Weekday")
        6, 7 -> println("Weekend!")
    }

    /**
     * 필요한 경우 다음과 같이 메서드를 포함할 수 있는데 이때는 세미콜론(;)을 사용해 열거한 상수 객체를 구분한다.
     */
    println(Color.BLUE.rgb())

    /**
     * 마찬가지로 when문을 사용해 각 케이스를 처리할 수 있다.
     */

    fun getColor(color: Color) = when (color) {
        Color.RED -> color.name // 이름가져오기
        Color.ORANGE -> color.ordinal   // 순서 번호: 1
        Color.YELLOW -> color.toString()    // 문자열 반환
        Color.GREEN -> color  // 기본값(문자열)
        Color.BLUE -> color.r   // r값: 0
        Color.INDIGO -> color.g
        Color.VIOLET -> color.rgb() // 메서드 연산 결과
    }

    println(getColor(Color.BLUE))

    /**
     * 열거형 클래스의 각 상수는 객체로 취급되므로 몇 가지 기본적인 멤벌르 제공한다.
     */
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);  // 세미콜론으로 끝을 알림

    fun rgb() = (r * 256 + g) * 256 + b // 메서드를 포함할 수 있음
}



