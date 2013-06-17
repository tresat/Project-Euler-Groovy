package com.tomtresansky.projecteuler.problem0017

import com.tomtresansky.projecteuler.AbstractProblemSolverTest

class Problem17SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 21124
  }

  @Override
  public Problem17Solver getProblemSolver() {
    return new Problem17SolverMark1()
  }
}