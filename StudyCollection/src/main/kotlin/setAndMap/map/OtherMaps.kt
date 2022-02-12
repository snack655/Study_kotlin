package setAndMap.map

import java.util.*
import kotlin.collections.HashMap

/**
 * Map의 기타 자료구조
 *
 * Map에서도 자바의 HashMap, SortedMap과 LinkedHashMap을 사용할 수 있다.
 * 다음과 같이 헬퍼 함수를 사용해 생성하고 초기화한다.
 */

fun main() {
    // java.util.HashMap 사용
    val hashMap: HashMap<Int,String> = hashMapOf(1 to "Hello", 2 to "World")
    println("hashMap = $hashMap")

    // java.util.SortedMap 사용
    val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Banana")
    println("sortedMap = $sortedMap")

    // java.util.LinkedHashMap 사용
    val linkedHash: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
    println("linkedHash = $linkedHash")
}

/**
 * SortedMap은 기본적으로 키에 대해 오름차순 정렬된 형태로 사용된다.
 * 내부 구조는 앞서 설명한 Set와 비슷하게 해시, 트리, 링크드 리스트의 자료구조로 구현되어 있다.
 */