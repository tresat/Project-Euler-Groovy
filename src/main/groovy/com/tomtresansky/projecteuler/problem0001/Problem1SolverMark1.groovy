package com.tomtresansky.projecteuler.problem0001

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem1SolverMark1 extends AbstractProblemSolver implements Problem1Solver {
  @Override
  public Integer getProblemNumber() {
    return 1
  }

  @Override
  BigInteger solve() {
    def sum = 0

    for (i in (0..<1000).step(3)) {
      sum += i
    }

    for (i in (0..<1000).step(5)) {
      sum += i
    }

    for (i in (0..<1000).step(15)) {
      sum -= i
    }

    sum
  }

  static void main(String... args) {
    run(new Problem1SolverMark1())
  }
}
