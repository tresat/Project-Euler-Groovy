package com.tomtresansky.projecteuler.problem0020

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem20SolverMark1 extends AbstractProblemSolver implements Problem20Solver {
  @Override
  public Integer getProblemNumber() {
    return 20
  }

  @Override
  BigInteger solve() {
    return [*1..100].inject(1) { BigInteger acc, val -> acc *= val }.toString().inject(0) { BigInteger acc, val -> acc += Integer.valueOf(val) }
  }

  static void main(String... args) {
    run(new Problem20SolverMark1())
  }
}
