package StaticAndCompanion.ObjectAndSingleTon.ObjectDeclaration

// 1 object 키워드를 사용한 방식
object OCustomer {
    var name = "Kildong"
    fun greeting() = println("Hello World!!")
    val HOBBY = Hobby("Basketball")
    init {
        println("Init!")
    }
}

// 2 컴패니언 객체를 사용한 방식
class CCustomer {
    companion object {
        const val HELLO = "hello"   // 상수 표현
        var name = "Joosol"
        @JvmField val HOBBY = Hobby("Football")
        @JvmStatic fun greeting() = println("Hello World!!")
    }
}

class Hobby(val name: String)

fun main() {
    OCustomer.greeting()
    OCustomer.name = "Dooly"
    println("name = ${OCustomer.name}")
    println(OCustomer.HOBBY.name)

    CCustomer.greeting()
    println("name = ${CCustomer.name}, Hello = ${CCustomer.HELLO}")
    println(CCustomer.HOBBY.name)
}

/**
 * object로 선언된 OCustomer는 멤버 프로프터와 메서드를 객체 생성 없이 이름의 점(.) 표기법으로 바로 사용할 수 있다.
 * 이것 역시 단일 인스턴스를 생성해 처리하기 때문에 싱글톤 패턴에 이용된다.
 *
 * object 선언 방식을 사용하면 접근 시점에 객체가 생성된다.
 * 그렇게 때문에 생성자 호출을 하지 않으므로 object 선언에는 주 생성자와 부 생성자를 사용할 수 없다.
 * 하지만 초기화 블록인 init이 들어갈 수 있는데 최초 접근에서 실행된다.
 * object 선언에서도 클래스나 인터페이스를 상속할 수 있다.
 *
 * 만일 자바에서 object 선언으로 생성된 인스턴스에 접근하려면 INSTANCE를 사용한다.
 * OCustomerAccess.java를 확인하자.
 *
 * object 선언 방식의 역컴파일 파일을 보면 다음과 같다.
 */
/*
public final class OCustomer {
    @NotNull
    private static String name;
    @NotNull
    private static final Hobby HOBBY;
    @NotNull
    public static final OCustomer INSTANCE;

...

    static {
        OCustomer var0 = new OCustomer();
        INSTANCE = var0;
        name = "Kildong";
        HOBBY = new Hobby("Basketball");
        String var1 = "Init!";
        boolean var2 = false;
        System.out.println(var1);
    }
}*/


