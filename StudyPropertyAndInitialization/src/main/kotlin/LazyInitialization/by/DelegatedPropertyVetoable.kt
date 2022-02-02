package LazyInitialization.by

import kotlin.properties.Delegates

fun main() {
    var max: Int by Delegates.vetoable(0) {     // 1 초깃값은 0
        prop, old, new ->
        println(new)
        new > old   // 2 조건에 맞지 않으면 거부권 행사
    }

    println(max)  // 0
    max = 10
    println(max) // 10

    // 여기서는 기존값이 새 값보다 크므로 false. 따라서 5를 재할당하지 않음
    max = 5
    println(max)    // 10

    // 다른 예를 간단하게 보자면
    // List 컬렉션의 data
    var data: List<Any> by Delegates.vetoable(listOf()) { p, old, new ->
        old != new
    }
    // ...
    // 코드 어딘가에서 data 프로퍼티를 설정함
    // adapter.data = ...
}