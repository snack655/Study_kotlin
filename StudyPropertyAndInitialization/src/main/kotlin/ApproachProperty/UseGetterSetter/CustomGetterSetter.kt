package ApproachProperty.UseGetterSetter

import java.util.*

/**
 * 커스텀 게터와 세터의 사용
 *
 * 사용자가 직접 게터와 세터를 정의하면서 새로운 내용을 작성하는 것을 커스텀(Custom) 게터와 세터라고 한다.
 */

class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    var name: String = _name
        set(value) {
            println("The name was changed")
            field = value.uppercase(Locale.getDefault())    // 1. 받은 인자를 대문자로 변경해 프로퍼티에 할당
        }

    var age: Int = _age
}

fun main() {
    val user1 = User(1, "kildong", 35)
    user1.name = "coco" // 2. 여기서 사용자 고유의 출력 코드가 실행
    println("user3.name = ${user1.name}")
}

/**
 * 만일 보안 때문에 외부에서 name에 접근해서 사용하지 못하게 하려면 가시성 지시자를 넣어줄 수 있다.
 * 예를 들어 set 앞에 private과 같은 가시성 지시자를 넣어 주면 외부에서 프로퍼티에 값을 할당할 수 없다.
 *
 * var name: String = _name
 *      private set
 */