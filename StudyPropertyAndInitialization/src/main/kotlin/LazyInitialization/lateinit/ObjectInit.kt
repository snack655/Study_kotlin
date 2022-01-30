package LazyInitialization.lateinit

/**
 * 객체 지연 초기화하기
 * 생성자를 통해 객체를 생성할 때도 lateinit을 사용해 필요한 시점에 객체를
 * 지연 초기화할 수 있다.
 *
 * 다음 소스 코드를 살펴보자.
 */

data class Person2(var name: String, var age: Int)

lateinit var person2: Person2   // 객체 생성의 지연 초기화

fun main() {
    person2 = Person2("Kildong", 30)    // 생성자 호출 시점에서 초기화됨
    print(person2.name + " is " + person2.age.toString())
}

/**
 * main() 함수 밖의 person2 객체는 생성자를 통해 선언되지 않았다.
 * 하지만 lateinit에 의해서 지연 초기화를 할 수 있기 때문에 오류를 발생하지 않는다.
 * 실제로 person2의 초기화는 main() 함수의 블록 본문에서 생성자를 통해 지연 초기화를 하고 있다.
 */

