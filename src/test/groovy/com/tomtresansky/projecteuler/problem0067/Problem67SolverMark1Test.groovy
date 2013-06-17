package com.tomtresansky.projecteuler.problem0067

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem67SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 7273
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem67SolverMark1()
  }
}
