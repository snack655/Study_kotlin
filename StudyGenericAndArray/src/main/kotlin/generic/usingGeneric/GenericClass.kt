package generic.usingGeneric

/**
 * 제네릭 클래스
 *
 * 제네릭 클래스는 형식 매개변수를 1개 이상 받는 클래스이다.
 * 클래스를 선언할 때 자료형을 특정하지 않고 인스턴스를 생성하는 시점에서
 * 클래스의 자료형을 정하는 것이다.
 * 제네릭 클래스 내에 메서드에도 다음과 같이 형식 매개 변수를 사용할 수 있다.
 *
 * class MyClass<T> {   // 1개의 형식 매개변수를 가지는 클래스
 *      fun myMethod(a: T) {    // 메서드의 매개변수 자료형에 사용됨
 *          ...
 *      }
 * }
 *
 * 만일 형식 매개변수를 클래스의 프로퍼티에 사용하는 경우 클래스 내부에서는 사용할 수 없다.
 * 자료형이 특정되지 못하므로 인스턴스를 생성할 수 없기 때문이다.
 *
 * class MyClass<T> {
 *      var myProp: T   // 오류! 프로퍼티는 초기화되거나 abstract로 선언되어야 함
 * }
 *
 * 그 대신 다음과 같이 주 생성자나 부 생성자에 형식 매개변수를 지정해 사용할 수 있다.
 * class MyClass<T>(val myProp: T) { }  // 주 생성자의 프로퍼티
 *
 * class MyClass<T> {
 *      val myProp: T   // 프로퍼티
 *      constructor(myProp: T) {    // 부 생성자 이용
 *          this.myProp = myProp
 *      }
 * }
 *
 * 그러면 다음과 같이 인스턴스를 생성할 때 명시적으로 자료형을 지정할 수 있다.
 * var a = MyClass<Int>(12) // 주 생성자 myProp에는 12가 할당되며 Int형으로 결정됨
 * println(a.myProp)    // 12
 * println(a.javaClass) // MyClass
 *
 * 객체 a가 생성되면서 자료형이 Int형으로 결정되며 생성자에 의해 12가 myProp에 초기화된다.
 * 이제 MyClass는 Int형 이외에도 다른 자료형을 받아 myProp의 자료형을 결정할 수 있게 되었다!
 *
 *
 */