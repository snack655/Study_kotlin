package useSequence.getElementValue

/**
 * 시퀀스를 이용한 소수
 *
 * Pair를 사용한 방법으로 이를 구현해 보자.
 */

fun main() {
    val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
        val currSeq = it.second.iterator()
        val nextPrime = currSeq.next()
        nextPrime to currSeq.asSequence().filter { it % nextPrime != 0 }
    }.map { it.first }
    println(primes.take(10).toList())
}