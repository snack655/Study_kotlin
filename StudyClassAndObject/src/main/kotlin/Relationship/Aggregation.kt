package Relationship

/**
 * 집합 관계
 *
 * 집합(Aggregation) 관계는 연관 관계와 거의 동일하지만 특정 객체를 소유한다는 개념이 추가된 것!
 * 앞에서 나타낸 연못(Pond)과 오리(Duck)의 예에서 오리가 특정 연못을 주거지로 삼는다면 연못이 오리를 소유할 수 있는 것!
 */

// 여러 마리의 오리를 위한 List 매개변수
class Pond(_name: String, _members: MutableList<Duck>) {
    val name: String = _name
    val members: MutableList<Duck> = _members
    constructor(_name: String): this(_name, mutableListOf<Duck>())
}

class Duck(val name: String)

fun main() {
    // 두 개체는 서로 생명주기에 영향을 주지 않음
    val pond = Pond("myFavorite")
    val duck1 = Duck("Duck1")
    val duck2 = Duck("Duck2")

    // 연못에 오리를 추가 - 연못에 오리가 집합
    pond.members.add(duck1)
    pond.members.add(duck2)

    // 연못에 있는 오리들
    for (duck in pond.members) {
        println(duck.name)
    }
}