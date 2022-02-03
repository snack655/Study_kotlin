package DataAndOtherClass.DataClass

/**
 * 데이터 클래스 선언하기
 *
 * 데이터 클래스를 위해 data 키워드를 제공하며 다음과 같이 선언할 수 있다.
 * data class Customer(var name: String, var email: String)
 *
 * 데이터 클래스는 다음 조건을 만족해야 한다.
 * - 주 생성자는 최소한 하나의 매개변수를 가져야 한다.
 * - 주 생성자의 모든 매개변수는 val, var로 지정된 프로퍼티여야 한다.
 * - 데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없다.
 *
 * 데이터 클래스는 오로지 데이터를 기술하는 용도로만 사용된다.
 * 하지만 필요하다면 추가로 부 생성자나 init 블록을 넣어 데이터를 위한 간단한 로직을 포함할 수 있다.
 */

data class Customer(var name: String, var email: String) {
    var job: String = "Unknown"
    constructor(name: String, email: String, _job: String): this(name, email) {
        job = _job
    }
    init {
        // 간단한 로직은 여기에
    }
}

/**
 * 데이터 클래스로 정의된 Customer는 필요한 데이터인 name과 email을 주 생성자에 프로퍼티로 가지고 있고,
 * 부 생성자를 통해 job을 하나 더 초기화할 수 있다.
 * 여기에는 보이지 않지만 데이터 클래스를 정의하면 자동으로 생성되는 메서드가 있다.
 *
 * equals() : 두 객체의 내용이 같은지 비교하는 연산자(고유 값은 다르지만 의미 값이 같을 때)
 * hashCode() : 객체를 구별하기 위한 고유한 정숫값 생성, 데이터 세트나 해시 테이블을 사용하기 위한 하나의 생성된 인덱스
 * copy() : 빌더 없이 특정 프로퍼티만 변경해서 객체 복사하기
 * toString() : 데이터 객체를 읽기 편한 문자열로 반환하기
 * componentN() : 객체의 선언부 구조를 분해하기 위해 프로퍼티에 상응하는 메서드
 *
 * 먼저 equals()는 두 개체의 값이 같은지 동등성(Equality)을 비교하는 것.
 * 보통 우리가 사용하는 연산자인 == 표현은 내부적으로 equals()를 호출하는 것과 같다.
 * 두 값이 동등하면 true를 반환한다.
 * hashCode()는 객체를 구별하기 위한 고유한 정숫값을 생성한다.
 * 만일 두 객체가 동등하다면 동일한 정숫값을 생성!
 */

val cus1 = Customer("Sean", "sean@mail.com")
val cus2 = Customer("Sean", "sean@mail.com")
fun main() {
    println(cus1 == cus2)   // 동등성 비교
    println(cus1.equals(cus2))  // 위와 동일
    println("${cus1.hashCode()}, ${cus2.hashCode()}")

    /**
     * copy()를 사용하면 데이터 객체를 복사하되 다른 프로퍼티 값을 가지는 것만 명시하여 변경할 수 있다.
     */

    val cus3 = cus1.copy(name = "Alice")    // name만 변경하고자 할 때
    println(cus1.toString())
    println(cus3.toString())
}
