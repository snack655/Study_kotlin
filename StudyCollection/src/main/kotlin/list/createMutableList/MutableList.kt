package list.createMutableList

/**
 * 가변형 mutableListOf() 함수
 *
 * 코틀린의 MutableList 인터페이스를 사용하는 헬퍼 함수 mutableListOf()를 통해
 * List의 요소를 추가, 삭제 또는 교체할 수 있다.
 * 헬퍼 함수의 원형은 다음과 같다.
 *
 * public fun <T> mutableListOf(vararg elements: T): MutableList<T>
 */

fun main() {
    // 가변형 List의 생성 및 추가, 삭제, 변경

    val mutableList: MutableList<String> = mutableListOf<String>("Kildong", "Dooly", "Chelsu")
    mutableList.add("Ben")
    mutableList.removeAt(1)
    mutableList[0] = "Sean"
    println(mutableList)

    // 자료형의 혼합
    val mutableListMixed = mutableListOf("Android", "Apple", 5, 6, 'X')
    println(mutableListMixed)

    /**
     * mutableListOf()는 ArrayList가 아닌 MutableList를 반환하고 있다.
     * MutableList로 add()와 removeAt() 메서드를 통해 요소를 추가, 삭제할 수 있다.
     * 그리고 set() 혹은 대괄호 표현을 통해 인덱스에 해당하는 요소를 바로 변경할 수 있다.
     * 특정 자료형의 제네릭 표현을 생략하면 여러 가지 자료형으로 구성된 MutableList를 할당할 수도 있다.
     *
     * 만일 기존의 불변형 List를 가변형으로 변경하려면 toMutableList()를 사용할 수 있다.
     * 이렇게 하면 기존의 List는 그대로 두고 새로운 공간을 만들어 낸다.
     */

    val names: List<String> = listOf("one", "two", "three") // 불변형 List 초기화
    val mutableNames = names.toMutableList()    // 새로운 가변형 List가 만들어짐
    mutableNames.add("four")
    println(mutableNames)
}