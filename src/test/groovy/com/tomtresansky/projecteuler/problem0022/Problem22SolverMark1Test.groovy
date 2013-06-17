package com.tomtresansky.projecteuler.problem0022

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem22SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 871198282
  }

  @Override
  public ProblemSolver getProblemSolver() {
    return new Problem22SolverMark1()
  }
}
