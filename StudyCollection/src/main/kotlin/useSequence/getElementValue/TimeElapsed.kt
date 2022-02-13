package useSequence.getElementValue

/**
 * asSequence()의 시간 성능
 *
 * 꽤 큰 요소에 대한 시간 경과 성능을 살펴보기 위해 경과된 시간을 표시하도록
 * 시스템의 System.nanoTime() 함수를 사용해 보자.
 * 이때 시간을 잴 수 있도록 사용자 함수 timeElapsed()를 만들어 람다식으로 각각의
 * 방식을 인수로 넘긱고 해당 람다식의 시간 경과를 표시해 보자.
 */

fun main() {
    val listBench = (1..1_000_000).toList()
    timeElapsed {
        listBench
            .map { it + 1 }
            .first { it % 100 == 0 }
    }

    timeElapsed {
        listBench
            .asSequence()
            .map { it + 1 }
            .first { it % 100 == 0 }
    }
}

fun timeElapsed(task: () -> Unit) {
    val before = System.nanoTime()
    task()
    val after = System.nanoTime()
    val speed = (after - before) / 1_000
    println("$speed ns")
}

/**
 * 작은 컬렉션에는 시퀀스를 사용하지 않는 것이 좋다.
 * 왜냐하면 filter() 등은 인라인 함수로 설계되어 있는데,
 * 시퀀스를 사용하면 람다식을 저장하는 객체로 표현되기 때문에
 * 인라인되지 않아 작은 컬렉션에는 오히려 좋지 않다.
 * 또한 한 번 계산된 내용은 메모리에 저장하기 떄문에 시퀀스 자체를 인자로 넘기는 형태는 사용하지 않느 것이 좋다.
 */