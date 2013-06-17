package com.tomtresansky.projecteuler.problem0016

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem16SolverMark1 extends AbstractProblemSolver implements Problem16Solver {
  @Override
  public Integer getProblemNumber() {
    return 16
  }

  @Override
  BigInteger solve() {
    (2**1000).toString().collect { Integer.valueOf(it) }.sum()
  }

  static void main(String... args) {
    run(new Problem16SolverMark1())
  }
}
