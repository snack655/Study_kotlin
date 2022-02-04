package DataAndOtherClass.AnnotationClass

import java.io.FileNotFoundException
import java.nio.file.Paths
import kotlin.jvm.Throws

/**
 * 표준 애노테이션
 *
 * 코틀린 표준 라이브러리가 가지고 있는 애노테이션을 몇 가지 정리해보자.
 */

@JvmName("filterStrings")
fun filter(list: List<String>): Unit {
    //...
}

@JvmName("filterInts")
fun filter(list: List<Int>): Unit {
    //...
}

/**
 * @JvmName은 filter()라는 이름을 자바에서 각각 filterStrings()와 filterInts()로 바꿔주는 것이다.
 *
 * 그 외에 @JvmStatic은 자바의 정적 메서드로 생성할 수 있게 해주고, @Throw는 코틀린의 throw 구분이
 * 자바에서도 포함되도록 한다.
 * 예를 들어 코틀린의 코드에서 다음과 같이 찾을 수 없는 예외를 발생시키려고 해보자.
 */

class File(val path: String) {
    @Throws(FileNotFoundException::class)
    fun exists(): Boolean {
        if (!Paths.get(path).toFile().exists()) {
            throw FileNotFoundException("$path does not exist")
        }
        return true
    }
}

/**
 * 마지막으로 @JvmOverloads는 코틀린에서 기본값을 적용한 인자에 함수를 모두 오버로딩해 준다.
 * 이렇게 표준 애노테이션은 자바와 원할하게 연동하는데 목적을 두고 있다.
 */