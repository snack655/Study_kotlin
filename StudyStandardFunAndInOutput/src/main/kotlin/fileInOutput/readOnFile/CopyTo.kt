package fileInOutput.readOnFile

import java.io.File
import java.util.*

/**
 * copyTo() 사용하기
 *
 * 코틀린에서 확장된 copyTo()는 이름에서 알 수 있듯이 파일에 대한 복사 작업을 처리하고 있다.
 * 코틀린 표준 라이브러리를 보면 다음과 같이 선언되어 있다.
 *
 * public fun File.copyTo(target: File, overwrite: Boolean = false, bufferSize: Int = DEFAULT_BUFFER_SIZE): File
 *
 * copyTo()는 목적지인 target에 파일을 버퍼 크기만큼 한 번에 복사한다.
 * 이때 기존에 파일이 존재하면 덮어쓸지 결정하기 위해 overwrite 매개변수를 통해 결정할 수 있다.
 * bufferSize 매개변수는 버퍼 크기를 설정한다.
 * 함수 선언부에서 보듯 overwrite나 bufferSize는 기본 값이 설정되어 있어 생략할 수 있다.
 *
 * 특정 파일을 다른 파일로 복사하기 위해 다음과 같이 간단히 테스트해 볼 수 있다.
 */

fun main() {
    val path = "/Users/choiminjae/공부/ioTest/Pass the Rhyme.txt"

    File(path).copyTo(File("/Users/choiminjae/공부/ioTest/Pass the Rhyme2.txt"))

    /**
     * 만일 복사하려는 첫 번째 대상인 path가 없으면 FileNotFoundException 오류가 발생한다.
     * 또한 복사할 대상은 오로지 파일이어야만 한다.
     * 파일 용량이 크다면 복사되는 도중에는 블로킹하면서 멈출 수 있다.
     *
     * 그 밖에 코틀린에서는 파일을 다루기 위해 다음과 같은 함수를 지원하고 있다.
     * 파일 내용을 각 줄에 맞춰 처리하거나 바이트, 줄, 텍스트 단위의 읽기 메서드를 사용할 수 있다.
     */

    // 파일의 내용 출력하기
    File(path).forEachLine { println(it) }

    // 바이트 단위로 읽기 (쓰기는 writeBytes())
    val bytes = File(path).readBytes()
    println(bytes.contentToString())

    // 줄 단위로 읽기
    val lines = File(path).readLines()
    lines.forEach { println(it) }

    // 텍스트 단위로 읽기 (쓰기는 writeText())
    val text = File(path).readText()
    println(text)

}