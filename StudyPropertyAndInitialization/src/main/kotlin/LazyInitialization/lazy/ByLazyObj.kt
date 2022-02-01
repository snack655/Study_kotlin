package LazyInitialization.lazy

/**
 * 객체 지연 초기화하기
 */

class Person(val name: String, val age: Int)

fun main() {
    var isPersonInstantiated: Boolean = false   // 초기화 확인 용도

    val person: Person by lazy {    // 1 lazy를 사용한 person 객체의 지연 초기화
        isPersonInstantiated = true
        Person("Kim", 23)   // 2 이 부분이 Lazy 객체로 반환됨
    }
    val personDelegate = lazy { Person("Hong", 40) }    // 3 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}") // 4 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}") // 5 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
}

/**
 * 언제 초기화될까?
 * 객체의 프로퍼티나 메서드가 접근되는 시점에서 초기화된다.
 *
 * by lazy나 lazy 할당의 차이점은 by lazy는 객체의 위임을 나타내며 lazy는 변수에 위임된
 * Lazy 객체 자체를 나타내브로 이 변수의 value를 한 단께 더 거쳐 객체의 멤버인 value.name과 같은
 * 형태로 접근해야 한다는 것이다.
 */