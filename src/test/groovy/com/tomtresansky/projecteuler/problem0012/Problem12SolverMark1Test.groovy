package com.tomtresansky.projecteuler.problem0012

import com.tomtresansky.projecteuler.AbstractProblemSolverTest

class Problem12SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 76576500
  }

  @Override
  public Problem12Solver getProblemSolver() {
    return new Problem12SolverMark1()
  }
}
