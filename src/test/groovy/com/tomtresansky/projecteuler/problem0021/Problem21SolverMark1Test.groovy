package com.tomtresansky.projecteuler.problem0021

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem21SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 31626
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem21SolverMark1()
  }
}
