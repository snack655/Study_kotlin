package generic.reified

import java.lang.IllegalStateException

fun main() {
    val result = getType<Float>(10)
    println("result = $result")
}

inline fun <reified T> getType(value: Int): T {
    println(T::class)   // 실행 시간에 삭제되지 않고 사용 가능
    println(T::class.java)

    return when(T::class) {
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("${T::class} is not supported!")
    }
}