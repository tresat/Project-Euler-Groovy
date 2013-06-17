package com.tomtresansky.projecteuler.problem0021

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.AmicableNumberFinder

class Problem21SolverMark1 extends AbstractProblemSolver implements Problem21Solver {
  @Override
  public Integer getProblemNumber() {
    return 21
  }

  @Override
  BigInteger solve() {
    AmicableNumberFinder anf = new AmicableNumberFinder()

    [*1..<10000].each { n -> anf.amicableNumbers[(n)] }
    def sol = 0
    anf.amicableNumbers.each { k, v ->
      if (v && v != k) {
        // println "$k -> $v"
        sol += k
      }
    }

    return sol
  }

  static void main(String... args) {
    run(new Problem21SolverMark1())
  }
}
