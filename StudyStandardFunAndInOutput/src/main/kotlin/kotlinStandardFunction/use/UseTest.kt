package kotlinStandardFunction.use

import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter

fun main() {
    PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
        it.println("hello")
    }

    /**
     * PrintWriter()는 파일 등에 내용을 출력한다.
     * 이때 인자로 FileOutputStream()을 사용해 파일 output.txt를 지정하고 있다.
     * 따라서 output.txt에 hello를 출력하고 use()에 의해 내부적으로 파일을 닫게 된다.
     *
     * 다음은 output.txt 파일에 "hello"라는 문자열을 저장하는 소스 코드이다.
     * 일반적으로 파일 적업을 하고 나면 close()를 명시적으로 호출해야 하는데,
     * use 블록 안에서는 그럴 필요가 없다.
     *
     * 물론 파일에서 읽어 들일 때도 사용할 수 있다.
     * 먼저 d:\test\contents.txt에 파일을 생성하고 "Hello World" 문자열을 작성해 둔다.
     * 이제 use() 함수를 사용해 다음과 같이 읽을 수 있다.
     */

    val file = File("d:\\test\\contents.txt")
    file.bufferedReader().use {
        println(it.readText())
    }
}