package DataAndOtherClass.AnnotationClass

/**
 * 애노테이션 선언하기
 *
 * 사용자 애노테이션을 만들기 위해서는 키워드 annotation을 사용해 클래스를 다음과 같이 선언한다.
 * annotation class 애노테이션 이름
 *
 * 애노테이션 클래스를 선언하면 @ 기호를 붙여서 다음과 같이 사용할 수 있다.
 */

annotation class Fancy  // 선언

@Fancy
class MyClass {
    //...
}

/**
 * 애노테이션은 다음과 같은 몇 가지 속성을 사용해 정의될 수 있다.
 *
 * - @Target: 애노테이션이 저정되어 사용할 종류(클래스, 함수, 프로퍼티 등)를 정의
 * - @Retention: 애노테이션을 컴파일된 클래스 파일에 저장할 것인지 실행 시간에 반영할 것인지 결정
 * - @Repeatable: 애노테이션을 같은 요소에 여러 번 사용 가능하게 할지를 결정
 * - @MustBeDocumented: 애노테이션이 API의 일부분으로 문서화하기 위해 사용
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION,
        AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.SOURCE)  // 애노테이션의 처리 방법 - SOURCE: 컴파일 시간에 제거됨
@MustBeDocumented
annotation class Fancy2

/**
 * 애노테이션 클래스 정의 위에 애노테이션을 사용하고 있다.
 * 여기서 @Retention은 애노테이션의 처리 방법을 기술하고 있다.
 * SOURCE를 사용하면 컴파일 시간에 애노테이션이 제거될 것이고,
 * BINARY를 사용하면 클래스 파일에 포함되지만 리플렉션에 의해 나타나지 않는다.
 * RUNTIME을 사용하면 애노테이션은 클래스 파일에 저장되고 리플렉션에 의해 나타난다.
 *
 * 리플렉션이란?
 * 사전적으로는 '반사'나 '투영'을 뜻하는 리플렉션(Reflection)이란
 * 프로그램을 실행할 때 프로그램의 특정 구조를 분석해 내는 기법으로 사용된다.
 * 예를 들어 어떤 함수를 정의하는데 함수의 매개변수로 클래스 타입을 선언하고 실행할 때
 * 매개변수로 전달될 클래스의 이름, 클래스의 메서드나 프로퍼티를 알아내는 작업이 리플렉션이다.
 *
 * 실행 시간에 클래스를 분석하려면 클래스에 대한 정보를 표현하는 클래스 레퍼런스로부터 알아낸다.
 * 따라서 특정 클래스의 정보를 분석하기 위해 클래스 타입인 KClass<*>로 정의하고
 * 클래스 레퍼런스는 클래스 이름::class와 같은 형태로 표현할 수 있다.
 */