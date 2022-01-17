package CaseOfHighOrderAndLambda

// 네트워크 호출 구현 구경하기

// 만약 자바 코드라면?
/**
 public interface Callback {
    void onSuccess(ResultType result);
    void onError(Exception Exception);
 }

 // networkCall 선언
 public void networkCall (Callback callback) {
    try {
        // 성공하면 onSuccess() 콜백 함수 호출
        callback.onSuccess(myResult);
    } catch (e: Throwable) {
        // 실패하면 onError() 콜백 함수 호출
        callback.onError(e);
    }
 }
 ...
 // networkCall 사용 - 인자에서 인터페이스 구현을 익명 객체를 만들어 처리
 networkCall(new Callback() {
    public void onSuccess(ResultType result) {
        // 네트워크 호출에 성공했을 때의 구현부
    }
    public void onError(Exception e) {
        // 네트워크 호출에 실패했을 때의 구현부
    }
 })
 **/

fun main() {
    // 위의 자바를 코틀린 설계로 바꾸자.
    // 2 networkCall() 함수 사용 - 인자 형식에 람다식을 사용
   /* networkCall(result -> {
        // 네트워크 호출에 성공했을 때 구현부
    }, error -> {
        // 네트워크 호출에 실패헀을 때 구현부
    });*/
}

// 코틀린으로 만든 네트워크 호출 구현부
// 1 람다식 함수의 매개변수를 가진 networkCall() 함수 선언
/*
fun networkCall(onSuccess: (ResultType) -> Unit, onError: (Throwable) -> Unit) {
    try {
        onSuccess(myResult)
    } catch (e: Throwable) {
        onError(e)
    }
}*/
