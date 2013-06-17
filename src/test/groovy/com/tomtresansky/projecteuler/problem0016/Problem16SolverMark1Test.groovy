package com.tomtresansky.projecteuler.problem0016

import com.tomtresansky.projecteuler.AbstractProblemSolverTest

class Problem16SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 1366
  }

  @Override
  public Problem16Solver getProblemSolver() {
    return new Problem16SolverMark1()
  }
}