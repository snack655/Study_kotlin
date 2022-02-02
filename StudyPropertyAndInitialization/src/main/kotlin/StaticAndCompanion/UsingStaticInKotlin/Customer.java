package StaticAndCompanion.UsingStaticInKotlin;

public class Customer {
    public static final String LEVEL = "BASIC"; // static 필드
    public static void login() {    // static 메서드
        System.out.println("Login...");
    }
}
