package array.useArray

import java.util.Arrays // 배열을 사용하기 위해 자바 표준 라이브러리 임포트

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)

    println("arr: ${arr.contentToString()}") // Arrays.toString()은 배열의 내용을 문자열로 반환
    println("size: ${arr.size}")    // size는 배열의 크기를 나타냄
    println("sum(): ${arr.sum()}")  // sum() 메서드는 배열의 합을 계산
    // 게터에 의한 접근과 대괄호 연산자 표기법
    println(arr.get(2))
    println(arr[2])

    // 세터에 의한 값의 설정
    arr.set(2, 7)
    arr[0] = 8
    println("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    // 루프를 통한 배열 요소의 접근
    for (i in arr.indices) {
        println("arr[$i] = ${arr[i]}")
    }
}