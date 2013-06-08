package com.tomtresansky.projecteuler.problem0013


import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem13SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 5537376230;
  }

  @Override
  public Problem13Solver getProblemSolver() {
    return new Problem13SolverMark1()
  }
}
