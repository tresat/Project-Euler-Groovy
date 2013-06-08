package com.tomtresansky.projecteuler.util

class CollatzGenerator {
  Map collatz = [:].withDefault { key -> generateCollatz(key) }

  private List generateCollatz(n) {
    assert n > 0

    BigInteger remaining = n
    List result = [remaining]
    while (remaining != 1) {
      //println "testing ${remaining}"
      if (collatz.containsKey(remaining.toString())) {
        //println "found ${remaining}"
        result.addAll(collatz[remaining.toString()][1..-1])
        break;
      } else {
        //println "calcing ${remaining}"
        if (remaining % 2 == 0) {
          remaining /= 2
        } else {
          remaining = remaining * 3 + 1
        }

        //println "recursing on ${remaining}"
        if (!collatz.containsKey(remaining.toString())) {
          collatz[remaining.toString()] = generateCollatz(remaining)
        }

        result << remaining
      }
    }

    //println "found $n = $result"
    if (!collatz.containsKey(n.toString())) {
      //println "added mapping $n -> $result"
      collatz[n.toString()] = result
    }
    //println "Map = $collatz"

    return result
  }
}
package com.tomtresansky.projecteuler.util

class CollatzGenerator {
  Map collatz = [:].withDefault { key -> generateCollatz(key) }

  private List generateCollatz(n) {
    assert n > 0

    BigInteger remaining = n
    List result = [remaining]
    while (remaining != 1) {
      //println "testing ${remaining}"
      if (collatz.containsKey(remaining.toString())) {
        //println "found ${remaining}"
        result.addAll(collatz[remaining.toString()][1..-1])
        break;
      } else {
        //println "calcing ${remaining}"
        if (remaining % 2 == 0) {
          remaining /= 2
        } else {
          remaining = remaining * 3 + 1
        }

        //println "recursing on ${remaining}"
        if (!collatz.containsKey(remaining.toString())) {
          collatz[remaining.toString()] = generateCollatz(remaining)
        }

        result << remaining
      }
    }

    //println "found $n = $result"
    if (!collatz.containsKey(n.toString())) {
      //println "added mapping $n -> $result"
      collatz[n.toString()] = result
    }
    //println "Map = $collatz"

    return result
  }
}
