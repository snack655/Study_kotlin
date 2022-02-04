package generic.usingGeneric

class Box<T>(t: T) {    // 형식 매개변수로 받은 인자를 name에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = Box<Int>(1)
    val box2: Box<String> = Box<String>("Hello")
    println(box1.name)
    println(box2.name)


    /**
     * Box<T>에서 T가 바로 형식 매개변수 이름이다.
     * 보통 Type을 줄인 T를 사용하지만 꼭 T를 사용해야 한다는 강제적인 사항은 없다.
     * 다만 일종의 규칙처럼 사용되는 이름이다.
     * 그 밖에 제네릭에서 사용하는 형식 매개변수 이름을 나열하면 다음과 같다.
     *
     * 제네릭에서 사용하는 형식 매개변수 이름
     * 형식 매개변수 이름                   의미
     * E                        요소(Element)
     * K                        키(Key)
     * N                        숫자(Number)
     * T                        형식(Type)
     * V                        값(Value)
     * S, U, V etc.             두 번째, 세 번째, 네 번째 형식(2nd, 3rd, 4th types)
     *
     * 위의 소스 코드를 살펴보면 <T>는 객체 box1과 box2를 생성할 때 자료형이 결정되며
     * <Int> 또는 <String>으로 선언되어 사용할 수 있었다.
     * 객체 생성 시 만일 생성자에서 유추될 수 있는 자료형이 있다면 선언된 자료형인 <String>이나 <Int>는 다음과 같이 생략 가능!
     */

    val box3 = Box(1)   // 1은 Int형이므로 Box<Int>로 추론
    val box4 = Box("Hello") // "Hello"는 String형이므로 Box<String>으로 추론

    /**
     * 따라서 이와 같은 제네릭을 사용하면 인자의 자료형을 고정할 수 없거나
     * 예측할 수 없을 때 형식 매개변수인 T를 이용해 실행 시간에 자료형을 결정할 수 있게 되므로 매우 편리하다.
     */
}