package stringHandling.literalString

/**
 * 특수한 문자를 처리하기 위해 백슬래스(\)를 포함한 문자 표현인 이스케이프 문자(Escape Character)를 사용할 수 있다.
 *
 * 이스케이프 문자의 종류
 *
 * 종류
 * \t 탭(tab)                \r 캐리지 리턴(carriage return)          \\ 백슬래스(backslash)
 * \b 백스페이스(backspace)    \' 작은따옴표(single quote)               \$ 달러 기호(dollar)
 * \n 개행(newline)          \" 큰따옴표(double quote)
 *
 * 또한 유니코드를 사용할 수 있는데 \uHHHH 형태로 16진값을 나타낸다.
 */

fun main() {
    val str = "\tYou're just too \"good\" to be true\n\tI can't take my eyes off you."
    val uni = "\uAC00"  // 한글코드의 범위 AC00-D7AF

    println("$str \n $uni")

    /**
     * 그 밖에 3중 따옴표(""")를 사용하면 이스케이프 문자 중 개행 문자를 넣지 않고도
     * 원본 문자열 그대로 개행까지 표시할 수 있다.
     * 또한 trimMargin()을 사용해 특정 문자 기준으로 공백을 제거할 수 있다.
     * 특정 문자의 기본값은 파이프 기호(|)이다.
     * 물론 trimMargin()에 인자를 넣어 바꿀 수 있다.
     */

    val text = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
    """.trimMargin()    // trim default는 |

    print(text)
}
