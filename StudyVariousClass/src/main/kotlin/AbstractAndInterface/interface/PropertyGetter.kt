package AbstractAndInterface.`interface`

/**
 * 인터페이스에서는 프로퍼티에 값을 저장할 수 없다고 했다.
 * 단, val로 선언된 프로퍼티는 게터를 통해 필요한 내용을 구현할 수 있다.
 */

interface Pet2 {
    val category: String
    val msgTags: String    // val 선언 시 게터의 구현이 가능
        get() = "I'm your lovely pet!"

    fun feeding()
    fun patting() = println("Keep patting!")
}


class Cat2(override var category: String) : Pet2 {
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val kitty = Cat2("shark")
    println("Pet Message Tags: ${kitty.msgTags}")
}

/**
 * val로 선언된 msgTags는 초기화할 수 없지만 게터를 통해 반환값을 지정할 수 있다.
 * 하지만 여전히 보조 필드인 field를 사용할 수 없다.
 * var로 프로퍼티를 선언하더라도 보조 필드를 사용할 수 없기 때문에 받은 value를 저장할 수 없다.
 */