package kotlinStandardFunction.run

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")
    val returnObj = person.apply {
        name = "Sean"
        skills = "Java"
        "success"   // 사용되지 않음
    }
    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.run {
        name = "Dooly"
        skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")

    /**
     * run() 함수는 마지막 표현식 "success"를 반환했음을 알 수 있다.
     * 물론 마지막 표현식을 구성하지 않으면 Unit이 반환된다.
     */
}