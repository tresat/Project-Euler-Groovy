package com.tomtresansky.projecteuler.problem0020

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem20SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 648
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem20SolverMark1()
  }
}
