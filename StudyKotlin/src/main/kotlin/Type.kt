class Type {

}

fun main() {
//    val a: Int = 1
//    val b: Double = a.toDouble()
//    val c: Int = 1.1.toInt()

    val compare1 : Int = 3
    val compare2 : Int = 3
    val compare3 : Boolean = compare1 == compare2
    val compare4 : Boolean = compare1 === compare2
    //println(compare3)
    //println(compare4)

    val a: Int = 128
    val b = a
    println(a === b)        // 같은 스택에 저장되어 있다.

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    println(c == d)         // 힙에서 서로 다른 주소를 참조하지만 값은 같다.
    println(c === d)        // 힘에서 서로 다른 주소를 참조하므로 false
    println(c === e)        // 같은 주소를 참조한다.
    // 만약 -128 ~ 127의 값을 입력하면 스택이 아닌 캐시에 저장되니 주의하자!

    // smart test 이해하기!
    var test: Number = 12.2
    println("$test")

    test = 12
    println("$test")

    test = 120L
    println("$test")

    test += 12.0f
    println("$test")

    // 자료형 검사하기
    // is 키워드를 사용하면 자료형을 검사할 수 있다.
    // is는 왼쪽 항의 변수가 오른쪽 항의 자료형과 같으면 true, 아니면 false를 반환한다.
    val num = 256

    if(num is Int)      // num이 Int형일 때
        println(num)
    else if (num !is Int)       // num이 Int형이 아닐 때
        print("Not a Int")

    // Any형을 사용하면 자료형을 결정하지 않은 채로 변수를 선언할 수 있다.
    val x: Any
    x = "Hello"
    if(x is String) {
        println(x.length)
    }

    // as에 의한 스마트 캐스트
    // as로 스마트 캐스트할 수도 있습니다.
    // as는 형 변환이 가능하지 않으면 예외를 발생시킨다.
    //val x2 : String = y as String
    // 위의 경우는 y가 null이 아니면 String으로 형 변환되어 x에 할당된다.

    val y: Char = 'A'
    val x3: String? = y as? String
    println(x3)

    // 묵시적 변환
    var t: Any = 1
    t = 14L
    println("a: $a type: ${a.javaClass}")

    checkArg("Hello")
    checkArg(5)
}

fun checkArg(x: Any) {
    if(x is String) {
        println("x is String : $x")
    }
    if (x is Int) {
        println("x is Int : $x")
    }
}
