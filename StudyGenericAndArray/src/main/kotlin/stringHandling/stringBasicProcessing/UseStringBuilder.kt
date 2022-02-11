package stringHandling.stringBasicProcessing

import java.lang.StringBuilder

/**
 * StringBuilder 사용하기
 *
 * StringBuilder를 사용하면 문자열이 사용할 공간을 좀 더 크게 잡을 수 있기 때문에
 * 요소를 변경할 때 이 부분이 사용되어 특정 단어를 변경할 수 있게 된다.
 * 단, 기존의 문자열보다는 처리 속도가 좀 느리고, 만일 단어를 변경하지 않고
 * 그대로 사용하면 임시 공간인 메모리를 조금 더 사용하게 되므로 낭비된다는 단점이 있다.
 * 따라서 문자열이 자주 변경되는 경우에 사용하는 것이 더 좋다.
 */

fun main() {
    var s = StringBuilder("Hello")
    s[2] = 'x'  // 허용되지 않았던 요소의 변경이 가능함. 결과는 Hexlo

    /**
     * 이제 s는 메모리 공간을 새롭게 만들어지지 않고 여유분의 공간을 이용해 문자 요소가 변경된다.
     *
     * StringBuilder의 기타 관련 메서드를 사용하면 포함(append), 추가(insert), 삭제(delete)가 용이하다.
     * 문자열을 호함시키기 위해 사용하는 append()는 생성된 버퍼를 사용하므로
     * 보통 + 연산자를 이용해 새로운 객체를 만들어 처리하는 것보다 더 좋다.
     */

    s.append("World")   // 문자열이 추가되어 HexloWorld
    s.insert(10, "Added")   // 인덱스 10번부터 추가되어 HexloWorldAdded
    s.delete(5, 10) // 인덱스 5번부터 10번 전까지 삭제되어 HexloAdded
}