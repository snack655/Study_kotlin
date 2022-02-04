package DataAndOtherClass.AnnotationClass

/**
 * 애노테이션의 위치
 */

@Fancy2 class MyClass2 {
    @Fancy2 fun myMethod(@Fancy2 myProperty: Int): Int {
        return (@Fancy2 1)
    }
}

/**
 * 클래스의 앞, 메서드 앞, 프로퍼티의 앞에 애노테이션을 사용할 수 있고
 * 반환할 때에는 값 앞에 표기하고 소괄호로 감싼다.
 *
 * 만일 생성자에 애노테이션을 사용한다면
 * constructor를 생략할 수 없다.
 */

class Foo @Fancy2 constructor(dependencies: MyClass2) {
    // ...
}

/**
 * 애노테이션은 다음과 같이
 * 프로퍼티의 게터/세터에서 사용할 수 있다.
 */

class Foo2 {
    var x: MyClass2? = null
        @Fancy2 set
}