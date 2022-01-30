package ApproachProperty

/**
 * 코틀린에서 게터와 세터가 작동하는 방식
 *
 * 먼저 자바에서 필드라고 부른느 것과 달리 클래스의 변수의 선언 부분을 코틀린에서는
 * 프로퍼티라고 부르는데 그 이유를 파악해보자!
 *
 * 주 생성자에서 받은 매개변수 _id, _name, _age는 클래스 안에 있는 프로퍼티 id, name, age에 할당!
 */

// 주 생성자에 3개의 매개변수 정의
class User(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id // 불변(읽기 전용)
    var name: String = _name    // 변경 가능
    var age: Int = _age     // 변경 가능
}

// class User(val id: Int, var name: String, var age: Int)
// 위와 같이 간소화 가능

// main에서 접근해보자.
fun main() {
    val user = User(1, "Sean", 30)

    val name = user.name    // 게터에 의한 값 획득

    user.age = 41   // 세터에 의한 값 지정

    println("name: $name, ${user.age}")

    /**
     * 객체 user를 생성하고 점(.) 표기법으로 접근한다.
     * user.name은 프로퍼티에 직접 접근하는 것처럼 보이나
     * 코틀린 내부적으로 접근 메서드가 내장되어 있다.
     * 실제로는 getName()과 같이 코틀린 내부의 게터 메서드를 통해 접근하는 것!
     * user.age = 41처럼 프로퍼티에 값을 할당하면 반대로 setAge()와 같은 세터 메서드를 사용하는 것
     *
     * 여기서 val로 설정되어 있던 id에 값을 할당하려고 시도하면 오류가 발생한다.
     * user.id = 2 // 읽기 전용 프로퍼티에는 세터로 값을 다시 지정할 수 없다.
     */
}