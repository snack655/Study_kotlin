package StaticAndCompanion.ObjectAndSingleTon.ObjectDeclaration;

public class OCustomerAccess {
    public static void main(String[] args) {
        String name = OCustomer.INSTANCE.getName(); // 코틀린의 object 선언 객체의 메서드 접근
        System.out.println(name);
    }
}
