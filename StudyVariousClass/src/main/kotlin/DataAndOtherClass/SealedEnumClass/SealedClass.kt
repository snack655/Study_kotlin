package DataAndOtherClass.SealedEnumClass

/**
 * 실드 클래스
 *
 * 실드 클래스를 사용하려면 sealed 키워드를 class와 함께 사용한다.
 * 실드 클래스 그 자체는 추상 클래스와 같기 때문에 객체를 만들 수 없다.
 * 또한 생성자도 기본적으로는 private이며 private이 아닌 생성자는 허용하지 않는다.
 * 실드 클래스는 같은 파일 안에서는 상속이 가능하지만, 다른 파일에서는 상속이 불가능하게 제한된다.
 * 블록 안에 선언되는 클래스는 상속이 필요한 경우 open 키워드로 선언될 수 있다.
 */

// 실드 클래스를 선언하는 첫 번째 방법
sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}

class Status: Result()  // 실드 클래스 상속은 같은 파일에서만 가능
class Inside: Result.Success("Status") // 내부 클래스 상속

/**
 * 먼저 Result 클래스는 실드 클래스이다.
 * 이 클래스 블록에는 Success와 Error 클래스가 묶여있다.
 * 그리고 Success 클래스는 상속할 수 있도록 open 키워드를 가지고 있다.
 * 실드 클래스 자체를 상속할 때는 같은 파일에서만 가능하다.
 *
 * 다음과 같음 방법으로도 선언할 수 있다.
 */

// 실드 클래스를 선언하는 두 번째 방법
sealed class Result2

open class Success(val message: String): Result2()
class Error(val code: Int, val message: String): Result2()

class Status2: Result2()
class Inside2: Success("Status")

/**
 * 이 경우에는 내부 클래스를 상속할 때 점(.) 표기로 접근하지 않고 그대로 사용
 *
 * 왜 이렇게 클래스를 묶어서 사용할까?
 * 계속해서 when문과 함께 메시지 검사 함수를 만들어보자.
 */

fun main() {
    // Success에 대한 객체 생성
    val result = Result.Success("Good!")
    val msg = eval(result)
    println(msg)
}

// 상태를 검사하기 위한 함수
fun eval(result: Result): String = when(result) {
    is Status -> "in progress"
    is Result.Success -> result.message
    is Result.Error -> result.message
    // 모든 조건을 가지므로 else가 필요없음
}

/**
 * 만일 이것을 이너 클래스나 중첩 클래스로 구현하려고 하면 모든 경우의 수를
 * 컴파일러가 판단할 수 없어 else문을 가져야 한다.
 * 하지만 실드 클래스를 사용하면 필요한 경우의 수를 직접 지정할 수 있다.
 */