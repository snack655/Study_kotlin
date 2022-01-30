package ApproachProperty;

/**
 * 자바에서 필드는 단순한 변수 선언 부분만을 가지기 때문에 접근하기 위한 메서드를
 * 일일이 만들어 두어야 한다.
 *
 * 접근하기 위한 방법은 접근 메서드의 2가지 형태인 게터(Getter)와 세터(Setter)를 만드는 것이다.
 *
 * 게터와 세터가 있으면 각 필드는 외부에서 직접 접근할 수 없게 되고 필요한 경우에만 게터와 세터를 통해서만
 * 값을 읽거나 지정할 수 있다.
 * 다양한 개체가 필드에 직접 접근하게 하면 데이터 무결성이 깨질 수 있고 보안상 문제도 있기 때문에 이런 접근 메서드를 사용한다.
 */

class Person {
    // 멤버 필드
    private String name;
    private int age;

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 게터와 세터
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Kildong", 30);
        // p1.name = "Dooly"    // 1. 오류 접근 불가!
        p1.setName("Dooly");    // 2. 세터에 의한 접근
        System.out.println(p1.getName());   // 3. 게터에 의한 접근
    }
}

/**
 * 자바의 게터는 반환값의 자료형이 참조할 멤버 필드의 자료형과 일치해야 한다.
 * 이것은 게터와 세터에 행당하는 접근 메서드를 직접 만들어야했다.
 * 따라서 자바의 필드가 접접 늘어나면 그에 상응하는 접근 메서드도 아주 많아자게 되어 코드가 아주 읽기 어려워진다.
 * 이것이 자바의 최대 단점이다.
 *
 * 하지만 코틀린에서는 각 프로퍼티에 게터와 세터가 자동으로 만들어진다.
 * 아래와 같이 위의 코드를 축약할 수 있다.
 * class Person(var name: String, var age: Int)
 */
