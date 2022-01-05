class Function {

}

fun main() {
    val res1 = sum(3,2) // 일반 인자
    val res2 = mul(sum(3, 3), 3) // 인자에 함수를 사용

    println("res1 : $res1, res2 : $res2")


    // 값에 의한 호출로 람다식 사용하기
    val result = callByValue(lambda())  // 람다식 함수를 호출
    println(result)
}

fun sum(a : Int, b : Int) = a + b
fun mul(a : Int, b : Int) = a * b

fun callByValue(b : Boolean): Boolean {     // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

// 마지막 표현식 문장의 결과가 반환
val lambda: () -> Boolean = {   // 람다 표현식이 2줄
    println("lambda function")
    true
}