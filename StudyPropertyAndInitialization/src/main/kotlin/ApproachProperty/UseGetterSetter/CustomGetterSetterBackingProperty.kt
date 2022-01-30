package ApproachProperty.UseGetterSetter

import java.lang.AssertionError

/**
 * 보조 프로퍼티의 사용
 *
 * 만일 보조 필드를 사용하지 않는 경우에는 임시적으로 사용할 프로퍼티를 선언해 놓고 게터나 세터에서 사용할 수 있다.
 */

class User2(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    private var tempName: String? = null
    var name: String = _name
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        }
    var age: Int = _age
}

fun main() {
    val user1 = User2(1, "kildong", 35)
    user1.name = ""
    println("user3.name = ${user1.name}")
}

/**
 * 이 소스 코드에서 사용한 tempName은 이름이 null이 되는 경우를 처리하기 위해
 * 임시적으로 사용하는 프로퍼티이다.
 * 이런 경우 보조 필드인 field를 사용하지 않고 추가로 내부의 프로퍼티를 임시로 선언해 사용할 수 있다.
 * 이것이 보조 프로퍼티이다.
 */