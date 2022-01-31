package LazyInitialization.lazy

/**
 * lazy는 val을 사용하는 읽기 전용의 프로퍼티를 지연 초기화할 때 매우 유용하다.
 * lazy는 람다식으로 구성되어 lazy 인스턴스 반환값을 가지는 함수이다.
 * lazy를 사용하는 프로퍼티를 선언해 보자.
 */

class LazyTest {
    init {
        println("init block")   // 2
    }

    val subject by lazy {
        println("lazy initialized") // 6
        "Kotlin Programming"    // 7 lazy 반환값
    }

    fun flow() {
        println("not initialized")  // 4
        println("subject one: $subject")    // 5 최초 초기화 시점!
        println("subject two: $subject")    // 8 이미 초기화된 값 사용
    }
}

fun main() {
    val test = LazyTest() // 1
    test.flow() // 3
}

/**
 * 핵심은 프로퍼티에 최초로 접근한 시점에 해당 프로퍼티가 초기화된다는 것이다.
 * 이후에는 이미 초기화된 내용을 재사용하는 것이다.
 * 그리고 초기화된 subject는 val로 선언되었으므로 다시 값을 설정할 수 없다.
 */