package fileInOutput.writeOnFile

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

/**
 * 파일에 쓰기
 *
 * 먼저 Files 클래스와 그와 연관된 Paths, StandardOpenOption을 살펴보자.
 * Files 클래스는 java.nio.file에 속해 있으며
 * 파일 조작을 위한 각종 static 메서드로 구성되어 있다.
 */

fun main() {
    val path = "/Users/choiminjae/공부/ioTest/hello.txt"    // 파일을 생성할 경로를 지정
    val text = "안녕하세요! Hello World!\n"

    try {
        Files.write(Paths.get(path), text.toByteArray(), StandardOpenOption.CREATE)
    } catch (e: IOException) {
    }

    /**
     * Files 클래스의 write()를 사용해 경로에 지정된 파일을 생성하고 내용을 쓴다.
     * 경로는 Paths 클래스를 사용하고 있고
     * 지정된 문자열 text를 toByteArray()로 변환하여 지정하고 있다.
     * 파일을 생성할 때의 옵션으로 StandardOpenOption을 사용하고 있는데
     * 주요 옵션은 다음과 같다.
     *
     *       옵션 이름      |               의미
     * READ               |  파일을 읽기용으로 연다
     * WRITE              |  파일을 쓰기용으로 연다
     * APPEND             |  파일이 존재하면 마지막에 추가한다
     * CREATE             |  파일이 없으면 새 파일을 생성한다.
     *
     * 파일 경로는 문자열로 지정할 수도 있지만
     * URI 객체로 특정 콘텐츠 자료형에 대한 위치도 허용한다.
     * 오보로딩 된 get() 메서드의 인자를 보자!
     *
     * Paths.get(String first, String...more)
     * Path.get(URI uri)
     *
     * URI란?
     * Uniform Resource Identifier의 약자로서 URL과 비슷하게 사용되는데
     * 각종 자원의 위치를 식별하기 위해 사용하는 규약이다.
     * 예를 들어 https://somewhere.com/abc.gif/와 같은 표현법이다.
     *
     * 그리고 파일을 처리할 때 발생할 수 있는 예외를 처리하도록 try~catch문을 사용해
     * IOException을 처리해야 한다.
     */
}