package fileInOutput.readOnFile

import java.io.BufferedReader
import java.io.FileReader
import java.lang.Exception

/**
 * 파일에서 읽기
 *
 * File의 FileReader 사용하기
 *
 * 적당한 디렉터리에 'Pass the Rhyme.txt'라는 파일의 이름으로 가사를 적어 저장하다.
 */

fun main() {
    val path = "/Users/choiminjae/공부/ioTest/Pass the Rhyme.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    } catch (e: Exception) {
        println(e.message)
    }

    /**
     * 텍스트 파일은 FileReader로 부터 선언된 read의 readText() 멤버 메서드를 통해 읽어 오고 있다.
     * readText()는 내부적으로 StringWriter()를 호출해 텍스트를 메모리로 가져온 후 그 내용을 반환한다.
     *
     *
     * 자바의 파일 읽기를 코틀린으로 변경하기
     *
     * 자바에서 자주 사용되는 파일 읽기의 방법을 살펴보고
     * 이것을 코틀린의 방법으로 변환해 보자.
     * 먼저 일반적인 자바 코드의 모습을 보자.
     *
     */

    /*
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(
                new InputStream(getAssets().open("datafile.json"), "UTF-8"));

        // 보통 루프를 사용해 피일이 끝날 때까지 줄을 읽음
        String mLine;
        while ((mLine = reader.readLine()) != null) {
            // 읽은 줄 처리
            ...
        }
    }catch (IOException e) {
        // 예외 처리 로그
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                // 예외 처리 로그
            }
        }
    } */

    /**
     * 핵신은 BufferedReader의 인자로 전달된 InputStreamReader를 통해 datafile.json 파일을 UTF-8
     * 인코딩 방식으로 열고 readLine()을 통해 읽어 들인다는 점이다.
     * 모든 것이 정삭적으로 끝나면 finally 블록에서 close()를 호출해 안전하게 파일을 닫는다.
     * 위의 코드는 핵심 코드보다 블록 구문의 자잘한 코드가 더 많아 한눈에 흐름이 파악되지 않는다.
     *
     * 앞의 예제를 코틀린의 코드로 단순 변환해 보자!
     * FileReadMethod.kt로 ->
     */


}