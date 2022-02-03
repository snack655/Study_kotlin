package AbstractAndInterface.variousInterface

/**
 * 클래스에서 특정 상위 클래스를 상속할 때는 오로지 1개의 클래스만 가능하다.
 * 클래스를 통해 다중 상속을 할 수 있다.
 * 하지만 인터페이스를 사용하면 여러 인터페이스로부터 구현할 수 있다.
 * 일종의 다중 상속과 같은 형태가 될 수 있다.
 */

interface Bird {
    val wings: Int
    fun fly()
    fun jump() {
        println("bird jump!")
    }
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump() {
        println("jump!, max speed: $maxSpeed")
    }
}

class Pegasus: Bird, Horse {
    override val wings: Int = 2
    override val maxSpeed: Int = 100
    override fun fly() {
        println("Fly!")
    }

    override fun run() {
        println("Run!")
    }

    override fun jump() {
        super<Horse>.jump()
        println("Pegasus Jump!")
    }
}

fun main() {
    val pegasus = Pegasus()
    pegasus.fly()
    pegasus.run()
    pegasus.jump()
}