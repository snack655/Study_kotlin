package fileInOutput.writeOnFile

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.lang.Exception

/**
 * File의 PrintWriter 사용하기
 *
 * 이번에는 java.io 패키지에서 자주 사용되는 PrinterWriter와 BufferedWriter 클래스를 사용해 보자.
 *
 * PrinterWriter의 경우 기본적인 printWriter() 외에도 print(), println(), printf(), write() 처럼
 * 파일에 출력하는 메서드를 제공하고 있어 기존에 콘솔에 출력하듯이 바이트 단위로 파일에 쓸 수 있다.
 *
 * BufferedWriter는 버퍼를 사용해 데이터를 메모리 영역에 두었다가
 * 파일에 쓰는 좀 더 효율적인 파일 쓰기를 지원하고 있다.
 */

fun main() {
    val outString: String = "안녕하세요!\tHello\r\nWorld!."  // 1. 문자열의 구성
    val path = "/Users/choiminjae/공부/ioTest/testfile.txt"

    /*
    val file = File(path)
    val printWriter = PrintWriter(file)

    printWriter.println(outString)  // 2 파일에 출력
    printWriter.close()
    */

    /**
     * 보통 파일을 사용한 후 닫게(close) 된다.
     * 코틀린의 use()를 사용하면 닫을 수 잇는 객체를 자동으로 닫아 준다.
     * 따라서 close() 메서드를 호출할 필요가 없으므로 코드를 다음과 같이 간단하게 줄일 수 있다.
     */
//  File(path).printWriter().use { out -> out.println(outString) }
    // 인자가 1개이므로 더 줄이자.
    File(path).printWriter().use { it.println(outString) }

    /**
     * 코틀린의 표준 함수 use()를 printWriter()와 함께 사용하면
     * 람다식으로 전달 받은 개체가 사용된 뒤 자동으로 안전하게 닫아 준다는 것!
     * 즉, use() 내부적으로 close()를 호출한다.
     *
     *
     * File의 BufferedWriter 이용하기
     *
     * BufferedWriter는 버퍼를 사용한다는 차이점만 빼면 사용법은 PrintWriter와 같다.
     * bufferedWriter()를 사용하면 먼저 내용을 메모리에 특정 공간에 저당한 뒤 파일로 다시 쓰여진다.
     * 기존의 printWriter()는 다음과 같이 바꿀 수 있다.
     */

    File(path).bufferedWriter().use { it.write(outString) }

    /**
     * File의 writeText() 사용하기
     *
     * 코틀린에서 확장해 감싼(wrapped) 메서드로 제공하는 writeText()를 사용해 보자.
     * 감싼 메서드란 기존의 존재하는 메서드를 또 다른 메서드로 감싼 후
     * 기능을 더 추가해 편리하게 사용할 수 있게 한 메서드이다.
     */

    val file = File(path)
    file.writeText(outString)
    file.appendText("\nDo great work!") // 파일에 문자열을 추가

    /**
     * writeText()를 사용하고 appendText()에서 문자열을 파일에 추가할 수 있다.
     * 이후에 닫기(close) 처리가 보이지 않는다.
     * writeText의 선언부를 보면
     *
     * public fun File.writeText(text: String, charset: Charset = Charsets.UTF_8): Unit = writeBytes(text.toByteArray(charset))
     *
     * 여기서 writeBytes를 또 보면
     *
     * public fun File.writeBytes(array: ByteArray): Unit = FileOutputStream(this).use { it.write(array) }
     *
     * 그러면 writeText()가 결국에 FileOutputStream을 사용하고 있으며
     * 표준 함수 use()를 이용해 write()가 사용되고 있었다는 것을 알 수 있다!
     * 그러므로 use()에 의해 close()가 다시 호출되는 것을 예상할 수 있다.
     *
     * 한편 null인 내용을 파일에 쓰는 경우 printWriter()는 null을 파일에 쓸 수 있지만,
     * bufferedWriter()는 NPE를 발생할 수 있다.
     * writeText()를 사용하는 경우에는 자료형 불일치 오류가 발생할 수 있으니 주의하자.
     *
     *
     * FileWriter 사용하기
     *
     * 기본적인 사용 방법은 다음과 같다.
     */
    val writer = FileWriter(path, true) // 인자: 경로, append 여부
    try {
        writer.write(outString)
    } catch (e: Exception) {
        // 오류 발생!
    } finally {
        writer.close()
    }

    /**
     * 이 구조도 코틀린의 use 함수를 사용해 다음 한 줄로 처리하자.
     */
    FileWriter(path, true).use { it.write(outString) }
}