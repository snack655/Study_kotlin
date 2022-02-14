package kotlinStandardFunction.with

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)
    val user = User("Kildong", "default")

    val result = with(user) {
        skills = "Kotlin"
        email = "kildong@example.com"
    }
    println(user)
    println("result: $result")

    /**
     * 기본적으로 Unit이 반환되지만, 필요한 경우
     * 마지막 표현식을 반환할 수 있다.
     *
     * val result = with(user) {
     *      ...
     *      "success"   // 마지막 표현식 반환
     * }
     *
     */
}