package fileInOutput.readOnFile

import java.io.*
import java.lang.Exception

fun main() {
    val path = "/Users/choiminjae/공부/ioTest/Pass the Rhyme.txt"

    // 단순 변환
    /*
    val file = File(path)
    val inputStream: InputStream = file.inputStream()
    val inputStreamReader = InputStreamReader(inputStream)
    val sb = StringBuilder()
    var line: String?
    val br = BufferedReader(inputStreamReader)

    try {
        line = br.readLine()
        while (line != null) {
            sb.append(line, '\n')
            line = br.readLine()
        }
        println(sb)
    } catch (e: Exception) {

    } finally {
        br.close()
    }
     */

    /**
     * 코드가 아직 좀 더럽다.
     * use()를 사용해 close() 부분을 삭제하겠다.
     */

    /*
    val file = File(path)
    val inputStream: InputStream = file.inputStream()
    val text = inputStream.bufferedReader().use { it.readText() }
    println(text)
     */

    /**
     * 여기서 중의할 점은 자바의 InputStream 클래스에는 bufferedReader()라는 멤버 메서드가 없지만
     * 코틀린의 kotlin.io 라이브러리 패키지에서 확장 함수 기법으로 InputStream에 추가되었다는 점이다.
     * 좀 더 간단하게 file 객체를 생략하고 BufferedReader로만 구성해도 된다.
     */

    /*
    val bufferedReader: BufferedReader = File(path).bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    println(inputString)
     */

    /**
     * 줄 단위로 처리하려면 use() 대신 useLines()를 사용할 수 있다.
     * useLines()는 코틀린의 시퀀스를 이용하고 있으며 마찬가지로 처리가 완료된 뒤 파일을 닫는다.
     */

    /*
    val bufferedReader = File(path).bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { println("> $it") }
     */

    /**
     * 각 줄 단위로 람다식에 의해 List 컬렉션에 add()로 채워진다.
     *
     * BufferedReader까지 생략하고 파일을 직접 사용해 보자.
     */

    val lineList = mutableListOf<String>()
    File(path).useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { println("> $it") }
}