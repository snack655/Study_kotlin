package StaticAndCompanion.UsingCompanionInJava;

public class KCustomerAccess {
    public static void main(String[] args) {
        // 코틀린 클래스의 컴패니언 객체에 접근
        System.out.println(KCustomer.LEVEL);
        KCustomer.login();  // 애노테이션을 사용할 때 접근 방법
        KCustomer.Companion.login();    // 위와 동일한 결과로 애노테이션을 사용하지 않을 때 접근 방법

        /**
         * 확장
         */
        // KJob에 대한 객체 생성 후 접근
        KJob kjob = KCustomer.JOB;
        System.out.println(kjob.getTitle());

        // KCustomer를 통한 접근
        KCustomer.JOB.setTitle("Accountant");
        System.out.println(KCustomer.JOB.getTitle());
    }
}


