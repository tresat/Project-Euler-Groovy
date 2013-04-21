package com.tomtresansky.projecteuler.problem0006

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem6SolverMark1 extends AbstractProblemSolver implements Problem6Solver {
  private BigInteger differentOfSums(int start, int end) {
    def nums = [*start..end]
    //println nums
    def sumOfSquares =  nums*.power(2).inject(0) { acc, val -> acc + val }
    //println sumOfSquares
    def squareOfSum = (nums.sum())**2
    //println squareOfSum

    squareOfSum - sumOfSquares
  }

  @Override
  public Integer getProblemNumber() {
    return 6
  }

  @Override
  BigInteger solve() {
    differentOfSums(1, 100)
  }

  static void main(String... args) {
    run(new Problem6SolverMark1())
  }
}
