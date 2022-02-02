package StaticAndCompanion

/**
 * 컴패니언 객체 사용하기
 *
 * 코틀린에서는 정적 변수를 사용할 때 static 키워드가 없는 대신 컴패니언 객체를 제공!
 * 자바처럼 특정 클래스 이름의 프로퍼티로 객체를 생성하지 않고 접근한다고 가정하자.
 */

class Person {
    var id: Int = 0
    var name: String = "Youngdeok"
    companion object {
        var language: String = "Korean"
        fun work() {
            println("working...")
        }
    }
}

fun main() {
    println(Person.language) // 인스턴스를 생성하지 않고 기본값 사용
    Person.language = "English" // 기본값 변경 가능
    println(Person.language)    // 변경된 내용 출력
    Person.work()   // 메서드 실행
    // println(Person.name) // name은 컴패니언 객체가 아니므로 오류
}

/**
 * Person 클래스의 language는 객체의 생성 없이도 접근할 수 있게 되었다.
 * 물론 work() 멤버 메서드도 객체 생성 없이 실행할 수 있다.
 *
 * 컴패니언 객체는 실제 객체의 싱글톤(Singleton)으로 정의된다.
 *
 * 여기서 싱글톤이란?
 * 전역 변수를 사용하지 않고 객체를 하나만 생성하도록 하며,
 * 생성된 객체를 어디에서든지 참조할 수 있도록 하는 디자인 패턴의 하나라는 것!
 *
 * 왜 이러한 패턴을 사용할까?
 * 객체가 서로 동일한 정보를 가질 때 하나의 메모리만 유지해 자원의 낭비를 줄일 수 있기 때문이다!
 */