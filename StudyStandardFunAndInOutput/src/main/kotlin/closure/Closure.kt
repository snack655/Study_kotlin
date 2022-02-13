package closure

fun main() {
    val calc = Calc()
    var result = 0  // 외부의 변수
    calc.addNum(2, 3) { x, y -> result = x + y } // 클로저
    println(result) // 값을 유지하여 5 출력

    /**
     * 이 코드에서 result는 var로 선언되었다.
     * Calc 클래스의 메서드인 addNum()이 호출되면 result는 자신의 유효 범위를 벗어나 삭제되어야 하지만
     * 클로저의 개념에 의해 독립된 복사본을 가진다.
     *
     * 람다식에서 반환값은 Unit으로 선언되어 반환하는 값이 없다.
     * 하지만 result = x + y와 같이 result에 값을 저장함으로써 포획된 변수 result에 값을 저장할 수 있었다.
     */

    calc.filteredNames(4)
}

class Calc {
    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) {   // 람다식 add에는 반환값이 없음
        add(a, b)
    }

    fun filteredNames(length: Int) {
        val names = arrayListOf("Kim", "Hong", "Go", "Hwang", "Jeon")
        val filterResult = names.filter { it.length == length } // 바깥의 length에 접근
        println(filterResult)
    }
}

/**
 * filter는 ArrayList의 멤버 메서드로 람다식을 전달받고 있다.
 * 이때 length는 람다식 바깥의 변수로 인자로 입력받은 길이에 일치하는 요소 목록을 반환해
 * filterResult에 저장하고 출력한다.
 *
 * 이렇게 클로저를 사용하면 내부의 람다식에서 외부 함수의 변수에 접근해 처리할 수 있어
 * 효율성이 높다. 또 완전히 다른 함수에서 변수에 접근하는 것을 제한할 수 있다.
 * 코틀린의 표준 라이브러리는 이러한 개념이 사용되어 설계되었다.
 */


