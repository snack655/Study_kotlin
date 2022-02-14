package fileInOutput.basicOfIO

import java.util.*

/**
 * readLine() 함수 사용해 보기
 */

fun main() {
    print("Enter: ")
    val input = readLine()!!
    println("You entered: $input")

    /**
     * input에는 표준 입력 장치인 콘솔로부터 입력받아 String형으로 할당하고 있다.
     * 입력에 실패할 경우 null 가능성이 생기기 때문에 !! 혹은 ?를 사용해 NPE 발생 여부를 처리한다.
     * 입력받은 값들은 문자열 값이 기본이기 때문에 입력 직후 정수형으로 변환하려면 readLine()!!.toInt() 형태로 호출할 수 있다.
     *
     * 입력에는 자바 표준 라이브러리인 Scanner를 이용할 수 있다.
     * 자바 라이브러리인 java.util.*을 임포트하고 사용해야 한다.
     */
    val reader = Scanner(System.`in`)
    var integer: Int = reader.nextInt()

    /**
     * 이때는 nextInt()라는 멤버 메서드를 사용해 정수형으로 값을 입력받을 수 있다.
     * 그 밖에 nextLong(), nextFloat(), nextDouble(), nextBoolean() 형식으로도 입력받을 수 있다.
     * 문자열은 nextLine()을 통해 입력받는다.
     */
}