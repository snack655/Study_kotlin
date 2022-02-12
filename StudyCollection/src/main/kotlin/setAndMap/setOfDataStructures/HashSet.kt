package setAndMap.setOfDataStructures

/**
 * hashSetOf() 함수
 *
 * 헬퍼 함수 hashSetOf()를 통해 해시 테이블에 요소를 저장할 수 있는 자바의 HashSet 컬렉션을 만든다.
 * 해시 테이블이란?
 * 내부적으로 키와 인덱스를 이용해 검색과 변경 등을 매우 빠르게 처리할 수 있는 자료구조이다.
 * hashSetOf()는 HashSet를 반환하는데 HashSet는 불변성 선언이 없기 때문에 추가 및 삭제 등의 기능을 수행할 수 있다.
 */

fun main() {
    val intsHashSet: HashSet<Int> = hashSetOf(6, 3, 4, 7)   // 불변성 기능이 없음
    intsHashSet.add(5)  // 추가
    intsHashSet.remove(6)   // 삭제
    println(intsHashSet)
}

/**
 * HashSet는 위 실행 결과와 같이 입력 순서와 중복된 요소는 무시한다.
 * 따로 정렬 기능은 없지만 해시값을 통해 요소를 찾아내므로
 * 검색 속도는 빅 오 표기법으로 O(1)의 상수 시간을 갖는다.
 * 필요한 값을 요청과 즉시 바로 찾아낸다는 의미이다.
 */