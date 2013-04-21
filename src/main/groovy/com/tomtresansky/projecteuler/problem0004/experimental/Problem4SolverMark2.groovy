package com.tomtresansky.projecteuler.problem0004.experimental

/**
 * Tried to procedurally generate palindromes from an arbitrary starting point.
 * <p>
 * Not as easy as I thought it might be.
 * <p>
 * Created on Apr 13, 2013.
 *
 * @author Tom
 * @version 0.1
 * @since 0.1
 */
class Problem4SolverMark2 {
  static enum Direction {
    ASC,
    DES
  }

  def List palindromes(BigInteger start) {
    palindromes(start, Direction.ASC)
  }

  def List palindromes(BigInteger start, Direction d) {
    def palindromes = [start]
    palindromes = palindromes.withEagerDefault { nextPalindrome(palindromes, d) }
  }

  private BigInteger nextPalindrome(List palindromes, Direction d) {
    // Find middle number
    def cur = palindromes[-1]
    def curAsStr = new StringBuffer(cur.toString())
    def mids = [Math.floor(curAsStr.size()/2).intValue()]

    if (curAsStr.size() % 2 == 0) {
      mids << (mids[0] - 1)
    }

    //println "Cur: " + curAsStr
    mids.each {
      //println "Idx: ${it}"
      def digit = Integer.parseInt(curAsStr[it])
      def newDigit = ((d == Direction.ASC ? digit + 1 : digit - 1) % 10).toString()

      cur += (10 ** (curAsStr.size() - it - 1))
    }

    //println "Result: " + curAsStr

    return cur
  }

  static void main(String... args) {
    def result = new Problem4SolverMark2().palindromes(995599)
    for (i in 0..100) {
      result[i]
    }
    println result
  }
}
