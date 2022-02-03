package AbstractAndInterface.`interface`

/**
 * 인터페이스 구현의 필요성
 */

open class Animal(val name: String)

// 1 feeding의 구현을 위해 인터페이스 Pet 지정
class Dog(name: String, override var category: String) : Animal(name), Pet {
    override var species: String = "dog"
    override fun feeding() {
        println("Feeding the dog a bone")
    }
}

class Master {
    fun playWithPet(pet: Pet) { // 인터페이스를 객체로 매개변수를 지정
        println("Enjoy with my ${pet.species}.")
    }
}

fun main() {
    val master = Master()
    val dog = Dog("Toto", "Small")
    val cat = Cat("Coco", "BigFat")
    master.playWithPet(dog)
    master.playWithPet(cat)
}

/**
 * 여기서 문제가 나타난다.
 * 만일 애완동물의 종류가 Bird, Rat.. 등으로 늘어나면 그만큼 많은 수의 오벌로딩된 메서드가 필요하다.
 * 메서드를 매번 작성해야 하는 이 문제를 해결할 수 있을까?
 * 코드를 수정해보자.
 */

/**
 * 이제 Pet 인터페이스에 종을 위한 프로퍼티인 species를 선언하고 이것을 이용해 어떤 애완동물과 놀게 될지
 * 알 수 있다. 이제 Master 클래스의 playWithPet() 메서드는 각 애완동물에 따라서 메서드를
 * 오버로딩할 필요가 없어졌다.
 *
 * 기존의 Master 클래스가 Cat이나 Dog 클래스에 의존적인 클래스였으나
 * 인터페이스를 이용해서 의존성을 제거했다.
 * 이렇게 Master 클래스가 독립성을 확보할 수 있다는 점에서 인터페이스가 핵심 역할을 했다.
 */