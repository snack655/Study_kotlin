package DataAndOtherClass.DataClass

/**
 * 객체 디스트럭처링하기
 *
 * 디스트럭처링(Destructuring)한다는 것은 객체가 가지고 있는 프로퍼티를 개별 변수로 분해하여 할당하는 것을 말한다.
 * 변수를 선언할 때 소괄호를 사용해서 분해하고자 하는 객체를 지정한다.
 *
 */

fun main() {
    val (name, email) = cus1
    println("name = $name, email = $email")

    /**
     * 위와 같이 cus1 객체의 프로퍼티 값 2개를 각각 name과 email로 선언된 변수에 가져온다.
     * 특정 프로퍼티를 가져올 필요가 없는 경우 다음과 같이 언더스코어(_)를 사용해 제외할 수 있다.
     */

    val (_, email2) = cus1  // 첫 번째 프로퍼티 제외

    /**
     * 또 개별적으로 프로퍼티를 가져오기 위해 componentN() 메서드를 사용할 수 있다.
     */

    val name2 = cus1.component1()
    val email3 = cus1.component2()
    println("name = $name2, email = $email3")

    /**
     * 데이터가 많아진다면 반복문을 사용해 다음과 같이 작성할 수도 있다.
     */
    val bob = Customer("Bob", "bob@mail.com")
    val erica = Customer("Erica", "erica@mail.com")

    val customer = listOf(cus1, cus2, bob, erica)   // 모든 객체를 컬랙션 List 목록을 구성

    for ((name, email) in customer) {   // 반복문을 사용해 모든 객체의 프로퍼티 분해
        println("name = $name, email = $email")
    }

    /**
     * for문에서 데이터를 가져오기 위해 (name, email)을 그대로 사용해 포함 연산자인 in으로
     * customers의 모든 객체를 반복하면서 프로퍼티를 분해하게 된다.
     *
     * 또 함수로부터 객체가 반환될 경우에도 사용할 수 있다.
     */

    fun myFunc(): Customer = Customer("Mickey", "mic@mail.com")

    val (myName, myEmail) = myFunc()

    // 이번에는 람다식으로
    val myLambda = {
        (nameLa, emailLa): Customer ->
        println(nameLa)
        println(emailLa)
    }

    myLambda(cus1)

    /**
     * 이렇게 데이터 클래스를 이용하면 각종 부가적인 메서드도 사용하면서 데이터에 집중하여 정의할 수 있어서
     * 매우 유용한 클래스 기법이다.
     */
}

