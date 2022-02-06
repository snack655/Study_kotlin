package generic.usingGeneric

/**
 * 제네릭 함수 혹은 메서드
 *
 * 형식 매개변수를 받는 함수나 메서드를 제네릭 함수 또는 메서드라고 하며
 * 해당 함수나 메서드 앞쪽에 <T>와 같이 형식 매개변수를 지정한다.
 * <K, V>와 같이 형식 매개변수를 여러 개 사용할 수도 있다.
 *
 * 자료형의 결정은 함수가 호출될 때 컴파일러가 자료형을 추론할 수 있으며 이 자료형은 반환 자료형과 매개변수 자료형에 사용할 수 있다.
 *
 * fun <형식 매개변수[,...]> 함수 이름(매개변수: <매개변수 자료형>[, ...]): <반환 자료형>
 *
 * 예를 보자.
 * fun <T> genericFunc(arg: T): T? { ... }  // 매개변수와 반환 자료형에 형식 매개변수 T가 사용됨
 * fun <K, V> put(Key: K, value: V): Unit { ... }   // 형식 매개변수가 2개인 경우
 */

fun <T> find(a: Array<T>, Target: T): Int {
    for (i in a.indices) {
        if (a[i] == Target) return i
    }
    return -1
}

fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr.indices ${arr1.indices}")  // indices는 배열의 유효 범위 반환
    println(find<String>(arr1, "Cherry"))   // 요소 C의 인덱스 찾아내기
    println(find(arr2, 2))  // 요소 2의 인덱스 찾아내기
}

/**
 * Array<T>는 배열을 위한 클래스로 arrayOf() 함수를 이용해 여러 개의 요소를 정의할 수 있다.
 * 이 배열의 맴버로 indices는 배열의 유효 범위를 반환한다.
 * 여기서는 String형 Cherry의 인덱스와 Int형 2의 요소를 찾아내어 출력하고 있다.
 * find()를 사용할 때는 마지막 출력문과 같이 선언에서 <Int>처럼 자료형이 특정되어 있는 경우에는 생략할 수 있다.
 */