package com.tomtresansky.projecteuler.problem0019

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem19SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 171
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem19SolverMark1()
  }
}
