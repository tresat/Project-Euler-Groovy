package com.tomtresansky.projecteuler.util

class CollatzGenerator {
  private collatz = [:]

  private List generateCollatz(n) {
    assert n > 0

    BigInteger remaining = n
    def result = [remaining]
    while (remaining != 1) {
      //println "testing ${remaining}"
      if (collatz.containsKey(remaining.toString())) {
        //println "found ${remaining}"
        result[-1] = collatz.get(remaining.toString())
        break;
      } else {
        if (remaining % 2 == 0) {
          remaining /= 2
        } else {
          remaining = remaining * 3 + 1
        }
        result << remaining
      }
    }

    collatz.put(n.toString(), result)

    return result
  }

  def List getCollatz(n) {
    if (!collatz.containsKey(n)) {
      generateCollatz(n)
    }

    return collatz[n]
  }
}
