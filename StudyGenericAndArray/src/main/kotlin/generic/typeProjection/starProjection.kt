package generic.typeProjection

/**
 * 스타 프로젝션
 *
 * 앞서 언급한 Box<> 자료형이 Box<Any?>가 되면 모든 자료형의 요소를 담을 수 있음을 의미하는 반면,
 * Box<*>는 어떤 자료형이라도 들어올 수 있으나 구체젝으로 자료형이 결정되고 난 후에는 그 자료형과
 * 하위 자료형의 요소만 담을 수 있도록 제한할 수 있다.
 *
 * 이렇게 in과 out을 정하지 않고 스타(*)를 통해 지정하는 방법을 스타 프로젝션이라고 한다.
 */

class InOutTest<in T, out U>(t: T, u: U) {
//    val propT: T = t    // 오류! T는 in위치이기 때문에, out 위치에 사용 불가
    val propU: U = u    // U는 out 위치로 가능

//    fun func1(u: U) // 오류! U는 out 위치로 가능
    fun func2(t: T) {   // T는 in 위치에 사용됨
        print(t)
    }
}

fun starTestFunc(v: InOutTest<*, *>) {
//    v.func2(1)  // 오류! Nothing으로 인자를 처리함
    print(v.propU)
}

/**
 * in으로 정의되어 있는 형식 매개변수를 *로 받으면 in Nothing인 것으로 간주하고,
 * out으로 정의되어 있는 형식 매개변수를 *로 받으면 out Any?인 것으로 간주한다.
 * 따라서 *를 사용할 때 그 위치에 따라 메서드 호출이 제한될 수 있다.
 */
