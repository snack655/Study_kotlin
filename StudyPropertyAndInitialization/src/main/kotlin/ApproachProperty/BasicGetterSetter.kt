package ApproachProperty

/**
 * 기본 게터와 세터 직접 지정하기
 *
 * 기본 게터와 세터를 직접 작성하자.
 * 먼저 게터와 세터가 포함되는 프로퍼티 선언에 대한 구조를 보자.
 * var 프로퍼티 이름[: 프로퍼티 자료형] [= 프로퍼티 초기화]
 *      [get() { 게터 본문 }]
 *      [set(value) { 세터 본문 }]
 * val 프로퍼티 이름[: 프로퍼티 자료형] [= 프로퍼티 초기화]
 *      [get() { 게터 본문 }]
 *
 * 직접 만들어보자.
 */

class User2(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}

fun main() {
    val user1 = User2(1, "Kildong", 30)
    // user1.id = 2 // val 프로퍼티는 값 변경 불가
    user1.age = 35  // 세터
    println("user1.age = ${user1.age}")    // 게터
}

/**
 * 위 코드를 보면 get()과 set()에 특수한 변수 field와 value가 보인다.
 * 이 변수는 게터와 세터에 사용된다.
 * 다음은 value와 field의 용도를 정리한 것이다.
 *
 * value: 세터의 매게변수로 외부로부터 값을 가져옴
 * field: 프로퍼티를 참조하는 변수
 *
 * -------------------------------------------------------------
 * 보조 필드의 역할
 *
 * field는 프로퍼티를 참조하는 변수로 보조 필드(Backing Field)라고도 한다.
 * get() = field는 결국 각 프로퍼티의 값을 읽는 특별한 식별자이다.
 * 만일 게터와 세터 안에서 field 대신 get() = age와 같이 사용하면
 * 프로퍼티의 get()이 다시 호출되는 것과 같으므로 무한 재귀 호출에 빠져 스택 오버플로 오류가 발생할 수 있다.
 * 그래서 임시적인 보조 필드를 따로 사용해 프로퍼티 변수에 접근하는 것!
 *
 * set()에도 값을 할당하기 위해 프로퍼티 이름을 직접 사용하지 않도록 주의해야 한다.
 */