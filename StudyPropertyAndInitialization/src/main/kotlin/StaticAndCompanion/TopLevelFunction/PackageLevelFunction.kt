@file:JvmName("PKLevel")
package StaticAndCompanion.TopLevelFunction

/**
 * 최상위 함수 사용하기
 *
 * 우리가 어떤 특정 기능을 사용하려면 보통 클래스의 객체를 생성한 다음
 * 해당 객체의 멤버 메서드를 호출함으로서 기능을 실행했다.
 * 하지만 우리가 지금까지 클래스 없이 만든 함수는 객체 생성 없이도 main() 함수 어디에서든 실행할 수 있었다.
 * 이것을 최상위 함수(Top-level Function) 혹은 패키지 레벨 함수(Package-level Function)라고 한다.
 */

fun packageLevelFunc() {
    println("Package-Level Function")
}

fun main() {
    packageLevelFunc()
}

/**
 * 이 코드는 클래스나 객체가 없느나 최상위 함수인 PackageLevelFunc() 함수가 main() 블록에서 잘 실행된다.
 * packageLevelFunc() 함수가 main() 함수 밑에 있어도 실행이 된다.
 * 이것을 역컴파일해 보면 최상위 함수 JVM에서 실행되기 위해 static으로 선언되어 있음을 알 수 있다.
 */
/*
자바로 역컴파일된 소스 코드
public final class PackageLevelFunctionKt {
    public static final void packageLevelFunc() {
        String var0 = "Package-Level Function";
        boolean var1 = false;
        System.out.println(var0);
    }

    public static final void main() {
        packageLevelFunc();
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
        main();
    }
}*/

/**
 * 역컴파일된 코드를 보면
 * PackageLevelFunctionKt 클래스가 자동 생성된 것을 알 수 있다.
 * 자동 생성된 클래스의 이름은 파일 이름과 확장자 이름이 붙은 형태로 만들어졌는데 이것을 자바 코드에서 다음과 같이 접근할 수 있다.
 * PackageLevelAccess.java 파일을 보자.
 *
 * 자바 코드에서는 이름이 자동 생성된 코틀린 클래스에 멤버 메서드처럼 접근할 수 있다.
 * 그런데 이렇게 클래스 이름을 자동 생성하지 않고 코틀린 코드에서 임을 명시할 수 있다.
 * 만일 접근할 클래스 이름을 바꾸고 싶다면 @file:JvmName("ClassName")을 코드 상단에 입력하면 된다.
 *
 * 자바에서는 이렇게 변경된 이름을 사용할 수 있게 된다.
 * 최상위 함수는 JVM에서 실행하기 위해 내부적으로 static으로 선언되기 때문에 main() 블록에서 객체 생성 없이
 * 사용될 수 있고 자바에서는 정적 함수처럼 접근이 가능하다.
 */
