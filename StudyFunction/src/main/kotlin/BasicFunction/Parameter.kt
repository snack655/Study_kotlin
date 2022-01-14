fun main() {
   add("minjae", "default")
   add("yul", "cy070818@hang.com")
   add("snack655", "default")

   // 이메일이 없을 때,, default를 항상 전달하기 번거러움

   newAdd("whitebear") // email 인자를 생략하여 호출 (name에만 "whitebear"이 전달)

   // --------------------------------------------------------------------------------------------------------
   // 매개변수 이름과 함께 함수 호출하기
   namedParam(x = 200, z = 100)  // x, z의 이름과 함께 함수 호출(y는 기본값 사용)
   namedParam(z = 150)  // z의 이름과 함께 함수 호출(x와 y는 기본 값으로 지정됨)

   // --------------------------------------------------------------------------------------------------------
   // 매개변수의 개수가 고정되지 않은 함수 사용하기
   // 가변 인자를 사용하자.
   // 가변 인자 : '인자의 개수가 변한다'
   // 가변 인자를 사용하면 함수는 하나만 정의해 놓고 여러 개의 인자를 받을 수 있습니다.
   // 함수를 선언할 때 매개변수 왼쪽에 vararg라는 키워드를 붙이면 된다.
   normalVarargs(1, 2, 3, 4)  // 4개의 인자 구성
   normalVarargs(4, 5, 6)  // 3개의 인자 구성
   // 가변 인자 counts는 Int형 배열이 된다.

}

fun add(name : String, email: String) {
    // name과 email을 회원 목록에 저장
}

fun newAdd(name : String, email: String = "default") {
    // name과 email을 회원 목록에 저장
    // email의 기본값은 "default". 즉, email로 넘어오는 값이 없으면 자동으로 "default" 입력!
}

fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
   println(x + y + z)
}

fun normalVarargs(vararg counts: Int) {
   for (num in counts) {
      print("$num ")
   }
   print("\n")
}
