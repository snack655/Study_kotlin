package array.arraySort

import java.util.*

/**
 * 기본 배열 정렬하고 반환하기
 *
 * 정렬 기능은 Array에서 확장된 함수들을 이용할 것이다.
 * sortedArray()와 sortedArrayDescending()을 사용해 정렬된 배열을 반환할 수 있다.
 * 원본은 그대로 두고 정렬된 배열을 새로 할당할 때 사용한다.
 *
 * 만일 원본 배열에 대한 정렬을 수행하려면 sort() 혹은 sortDescending()을 사용한다.
 */

fun main() {
    val arr = arrayOf(8, 4, 3, 2, 5, 9, 1)
    // 1. 오름차순, 내림차순으로 정렬된 일반 배열로 반환
    val sortedNums = arr.sortedArray()
    println("ASC: " + sortedNums.contentToString())

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("DESC: " + sortedNumsDesc.contentToString())

    // 2. 원본 배열에 대한 정렬
    arr.sort(1, 3)  // sort(fromIndex, toIndex)
    println("ORI: " + arr.contentToString())
    arr.sortDescending()
    println("ORI: " + arr.contentToString())
    // 3. List로 반환
    val listSorted: List<Int> = arr.sorted()
    val listDesc: List<Int> = arr.sortedDescending()
    println("LST: $listSorted")
    println("LST: $listDesc")

    // 4. SortBy를 이용한 특정 표현식에 따른 정렬
    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy { item -> item.length }
    println(items.contentToString())
}