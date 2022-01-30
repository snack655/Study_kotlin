package ApproachProperty.UseGetterSetter

/**
 * 커스텀 게터와 세터를 통해 나이를 받아들이는 세터를 구성해 인자가
 * 18세 미만인 경우는 18세로 설정하고, 18세부터 30세 범위에 있는 경우에는
 * 사실 그대로 값을 유지한다.
 * 그 외의 30세 초과인 경우에는 제시된 인자에서 3세를 빼고 설정!
 */

fun main() {
    val kim = FakeAge()
    kim.age = 15
    println("Kim's real age = 15, pretended age = ${kim.age}")

    val hong = FakeAge()
    hong.age = 35
    println("Hong's real age = 35, pretended age = ${hong.age}")
}

class FakeAge {
    var age: Int = 0
        set(value) {    // 나이에 따라 판별하는 세터
            field = when {
                value < 18 -> 18
                value in 18..30 -> value
                else -> value - 3
            }
        }
}