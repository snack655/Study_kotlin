package kotlinStandardFunction.apply

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")
        person.apply { this.skills = "Swift" }  // 여기서 this는 person 객체를 가리킴
    println(person)

    val returnObj = person.apply {
        name = "Sean"   // this는 생략할 수 있음
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
    }
    println(person)
    println(returnObj)

    /**
     * apply()는 확장 함수로서 person을 this로 받아오는데
     * 클로저를 사용하는 방식과 같다!
     * 따라서 객체의 프로퍼티를 변경하면 원본 객체에 반영되고 또한
     * 이 객체는 this로 반환된다.
     *
     * 그러면 also() 함수와 무엇이 다를까?
     * 바로 객체를 넘겨받는 방법이 다른다!
     * also() 함수에서는 it을 사용해 멤버에 접근한다.
     * 위 코드에서 person 객체의 skills에 접근하는 방법을 보면 차이를 바로 알 수 있다.
     *
     * person.also { it.skills = "Java" }   // it으로 받고 생략할 수 없음
     * person.apply { skills = "Swift" }    // this로 받고 생략
     *
     * also() 함수에서는 it을 생략할 수 없지만
     * apply() 함수에서는 this가 생략되어 멤버 이름만 사용할 수 있다.
     * 이것을 활용하면 특정 객체를 초기화하는 데 아주 유용하다.
     */
}