package com.tomtresansky.projecteuler.problem0018

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem18SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 1074
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem18SolverMark1()
  }
}
