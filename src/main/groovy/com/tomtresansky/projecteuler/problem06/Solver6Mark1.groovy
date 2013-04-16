package com.tomtresansky.projecteuler.problem06

class Solver6Mark1 implements Problem6Solver {
  private BigInteger differentOfSums(int start, int end) {
    def nums = [*start..end]
    //println nums
    def sumOfSquares =  nums*.power(2).inject(0) { acc, val -> acc + val }
    //println sumOfSquares
    def squareOfSum = (nums.sum())**2
    //println squareOfSum

    squareOfSum - sumOfSquares
  }

  BigInteger solve() {
    differentOfSums(1, 100)
  }

  static void main(String... args) {
    println ("Problem 6: " + new Solver6Mark1().solve())
  }
}
